/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.compare.extensions.match;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.eobject.CachingDistance;
import org.eclipse.emf.compare.match.eobject.EditionDistance;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.eobject.ProximityEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.utils.ReferenceUtil;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.database.ForeignKeyElement;
import org.obeonetwork.dsl.database.NamedElement;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class DatabaseMatchEngineFactory extends MatchEngineFactoryImpl {
	
	public DatabaseMatchEngineFactory() {
		this(UseIdentifiers.NEVER);
	}
	
	public DatabaseMatchEngineFactory(UseIdentifiers useIDs) {
		
		final IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
		
		final EditionDistance editionDistance = new EditionDistance() {
			@Override
			public boolean areIdentic(Comparison inProgress, EObject a,
					EObject b) {
				return areSimilar(inProgress, a, b);
			}
			
			@Override
			public double distance(Comparison inProgress, EObject a, EObject b) {
				if (!areSimilar(inProgress, a, b)) {
					return Double.MAX_VALUE;
				} else {
					return 0;
				}
			}
			
			protected boolean areSimilar(Comparison inProgress, EObject obj1, EObject obj2) {
			
				// They are different is they are not from the same type.
				if (!obj1.eClass().equals(obj2.eClass())) {
					return false;
				}
				
				// obj1 and obj2 are similar 
				if (areUniqueSchemas(obj1, obj2) || obj1 instanceof DataBase) {
					// if they are unique schemas or database
					return true;
				} else {		
					// OR...
					
					if (obj1 instanceof TypeInstance) {
						return areSimilar(inProgress, obj1.eContainer(), obj2.eContainer());
					}
					
					return areSimilarFromName(inProgress, obj1, buildName(obj1), obj2, buildName(obj2));							
				}
				
				
			}
			
			private boolean areSimilarFromName(Comparison inProgress, EObject obj1, String obj1Name, EObject obj2, String obj2Name) {
				Boolean areInTheSameContainer = null;
				
				// obj1 and obj2 are similar...
				
				if (obj1Name.equals(obj2Name)) {
					
					areInTheSameContainer = areInTheSameContainer(inProgress, obj1, obj2);
					if (areInTheSameContainer) {
						// if they have the same name in the same container
						return true;
					}
					
				} else {
					
					if (isExistInTheOtherSide(obj1, obj2)) {
						
						areInTheSameContainer = areInTheSameContainer(inProgress, obj1, obj2);
						if (areInTheSameContainer) {
							// They are different if they have not the same name and it exists an element with the same name in the same container
							return false;
						}
						
					}
					
					if (obj1 instanceof DatabaseElement && obj2 instanceof DatabaseElement
							&& ((DatabaseElement)obj1).getTechID().equals(((DatabaseElement)obj2).getTechID())) {
						
						if (areInTheSameContainer == null) {
							areInTheSameContainer = areInTheSameContainer(inProgress, obj1, obj2);
						}
						
						if (areInTheSameContainer) {
							// OR if techId is the same and the name is different and it is located in the same container, we can not determine:
							// - They are identical if the object was renamed
							// - They are different if it is a copy of the object + a renaming
							// So, we let the default match engine to choose. This one might be set to privilege the similarity if the most of the feature values are identical.
							return areSimilarForComparisonEngine(inProgress, obj1, obj2); // or return false to force the post processor to call the equality helper
						}
						
					}
				}
				
				// In the other cases, the objects are not identical.
				return false;
			}
			
			protected boolean areInTheSameContainer(Comparison comparison, EObject obj1, EObject obj2) {				
				EObject parentObject1 = obj1.eContainer();
				EObject parentObject2 = obj2.eContainer();
				
				if (parentObject1 == null && parentObject2 != null
						|| parentObject1 != null && parentObject2 == null) {
					return false;
				} else if (parentObject1 != null && parentObject2 != null) {
					if (!areSimilar(comparison, parentObject1, parentObject2)) {
						return false;
					} else {
						return areInTheSameContainer(comparison, parentObject1, parentObject2);
					}	
				}
				return true;			
			}
			
			protected boolean areUniqueSchemas(EObject obj1, EObject obj2) {
				return obj1 instanceof Schema 
						&& obj1.eContainer() != null 
						&& obj2.eContainer() != null 
						&& (((DataBase)obj1.eContainer()).getSchemas().size() == 1) 
						&& (((DataBase)obj2.eContainer()).getSchemas().size() == 1);
			}
			
			protected boolean areSimilarForComparisonEngine(Comparison inProgress, EObject obj1, EObject obj2) {
				
				if (hasSameNumberOfChildren(obj1, obj2)) {
					return true;
				} else {
					if (super.areIdentic(inProgress, obj1, obj2)) {
						return true;
					} else {
						double distance = super.distance(inProgress, obj1, obj2);
						double maxDist = Math.max(getThresholdAmount(obj1), getThresholdAmount(obj2));
						return distance <= maxDist;
					}
				}
				
			}
			
			private boolean hasSameNumberOfChildren(EObject obj1, EObject obj2) {
				int nbChildrenObj1 = 0;
				for (EReference reference : obj1.eClass().getEAllContainments()) {
					nbChildrenObj1 += ReferenceUtil.getAsList(obj1, reference).size();
				}
				
				int nbChildrenObj2 = 0;
				for (EReference reference : obj2.eClass().getEAllContainments()) {
					nbChildrenObj2 += ReferenceUtil.getAsList(obj2, reference).size();
				}
				return nbChildrenObj1 == nbChildrenObj2;
			}
			
			protected boolean isExistInTheOtherSide(final EObject obj1, final EObject obj2) {
				boolean result = false;
				if (obj2.eContainer() != null) {
					result = Iterables.any(obj2.eContainer().eContents(), new Predicate<EObject>() {
						public boolean apply(EObject input) {
							return input.eClass() == obj1.eClass() 
									&& buildName(input).equals(buildName(obj1));
						}
					});
				}
				if (result) {
					return true;
				} else {
					if (obj1.eContainer() != null && !result) {
						result = Iterables.any(obj1.eContainer().eContents(), new Predicate<EObject>() {
							public boolean apply(EObject input) {
								return input.eClass() == obj2.eClass() 
										&& buildName(input).equals(buildName(obj2));
							}
						});
					}
				}
				return result;
			}
			
			private String buildName(EObject element) {	
				String result = "";
				if (element instanceof NamedElement) {
					result = ((NamedElement) element).getName();
				} else if (element instanceof ForeignKeyElement) {
					Column fkColumn = ((ForeignKeyElement) element).getFkColumn();
					if(fkColumn != null) {
						result += fkColumn.getName();
					}
					Column pkColumn = ((ForeignKeyElement) element).getPkColumn();
					if(pkColumn != null) {
						result += " -> " + pkColumn.getName();
					}
				} else if (element instanceof TypeInstance) {
					NativeType type = ((TypeInstance) element).getNativeType();
					if (type != null) {
						result += type.getName();
					}
				} else if (element instanceof NativeType) {
					result += ((NativeType) element).getName();
				}
				return result;
			}
			
		};
		
		final CachingDistance cachedDistance = new CachingDistance(editionDistance);
		final IEObjectMatcher matcher = new ProximityEObjectMatcher(cachedDistance);
		matchEngine = new DefaultMatchEngine(matcher, comparisonFactory);
	}
	
}
