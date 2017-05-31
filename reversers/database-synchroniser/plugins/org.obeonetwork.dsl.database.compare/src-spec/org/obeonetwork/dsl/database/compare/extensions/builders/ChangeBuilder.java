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
package org.obeonetwork.dsl.database.compare.extensions.builders;

import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.compare.Activator;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;

public abstract class ChangeBuilder {
	
	protected EClass semanticType;
	
	public ChangeBuilder(EClass semanticType) {
		this.semanticType = semanticType;
	}
	
	protected void log(String msg) {
		Activator.getDefault().logWarning(msg);
	}
	
	protected Diff handleAddChange(ReferenceChange change) {
		if (change.getKind() == DifferenceKind.ADD) {
			Activator.getDefault().logWarning("[DatabaseComparison] handleAddChange : should be implemented for '" + change + "' in " + this.getClass().getSimpleName());
		}		
		return null;
	}

	protected Diff handleRemoveChange(ReferenceChange change) {
		if (change.getKind() == DifferenceKind.DELETE) {
			Activator.getDefault().logWarning("[DatabaseComparison] handleRemoveChange : should be implemented for '" + change + "' in " + this.getClass().getSimpleName());
		}
		return null;
	}

	protected Diff handleAlterChange(Match match) {
		Activator.getDefault().logWarning("[DatabaseComparison] handleAlterChange : should be implemented for '" + match + "' in " + this.getClass().getSimpleName());
		return null;
	}
	
	protected Diff handleAlterChange(AttributeChange change) {
		Activator.getDefault().logWarning("[DatabaseComparison] handleAlterChange : should be implemented for '" + change + "' in " + this.getClass().getSimpleName());
		return null;
	}
	
	protected Diff handleAlterChange(ReferenceChange change) {
		Activator.getDefault().logWarning("[DatabaseComparison] handleAlterChange : should be implemented for '" + change + "' in " + this.getClass().getSimpleName());
		return null;
	}
	
	protected boolean isReferenceAdd(Diff diff) {
		return diff instanceof ReferenceChange && diff.getKind() == DifferenceKind.ADD;
	}
	
	protected boolean isReferenceDelete(Diff diff) {
		return diff instanceof ReferenceChange && diff.getKind() == DifferenceKind.DELETE;
	}
	
	public boolean canHandle(EObject obj) {
		if (obj instanceof Diff) {
			Diff diff = (Diff) obj;
			if (isReferenceAdd(diff)) {	
				return semanticType.isInstance(((ReferenceChange) diff).getValue());				
			} else if (isReferenceDelete(diff)) {				
				return semanticType.isInstance(((ReferenceChange) diff).getValue());				
			} else if (diff.getKind() == DifferenceKind.CHANGE) {
				if (diff instanceof AttributeChange) {
					return semanticType.isInstance(((AttributeChange) diff).getMatch().getRight());
				}
				if (diff instanceof ReferenceChange) {
					return semanticType.isInstance(((ReferenceChange) diff).getMatch().getRight());
				}
			}
			return false;
		} else if (obj instanceof Match
				&& ((Match)obj).getRight() != null 
				&& ((Match)obj).getLeft() != null) {
			return semanticType.isInstance(((Match)obj).getRight());
		}
		return false;
	}
	
	public Diff handle(EObject comparisonElement) {
		Diff createdDiffElement = null;
		
		if (comparisonElement instanceof Diff) {
			Diff diff = (Diff) comparisonElement;
			
			if (isReferenceAdd(diff)) {				
				createdDiffElement = handleAddChange((ReferenceChange) diff);				
			} else if (isReferenceDelete(diff)) {
				createdDiffElement = handleRemoveChange((ReferenceChange) diff);
			} else if (diff.getKind() == DifferenceKind.CHANGE) {
				if (diff instanceof AttributeChange) {
					AttributeChange attributeChange = (AttributeChange) diff;
					// Ignore TechID
					if (DatabasePackage.eINSTANCE.getDatabaseElement_TechID() != attributeChange.getAttribute()) {
						createdDiffElement = handleAlterChange(attributeChange);
					}
				}
				if (diff instanceof ReferenceChange) {
					createdDiffElement = handleAlterChange((ReferenceChange) diff);
				}
			}
			
			// Attach newly created element to its parent
			if (createdDiffElement != null) {
				createdDiffElement.getRefinedBy().add(diff);
				diff.getMatch().getDifferences().add(createdDiffElement);
			}	
			
		} else if (comparisonElement instanceof Match) {
			Match match = (Match) comparisonElement;
			if (match.getAllDifferences().iterator().hasNext()) {
				// There is at least one Diff in this match or one of its submatches,
				// thus we created a Diff that marks that there is some update to perform inside the match's contents.
				createdDiffElement = handleAlterChange((Match) comparisonElement);
			}
			
			if (createdDiffElement != null) {	
				Match parent = null;
				EObject container = match.eContainer();
				if (container instanceof Match) {
					parent = (Match) container;
				} else {
					parent = (Match) comparisonElement;
				}
				parent.getDifferences().add(createdDiffElement);			
			}	
		}
		return createdDiffElement;
	}
	
	protected void fillDBDiff(DBDiff newChange, ReferenceChange change) {
		newChange.setTarget(change.getValue());
		newChange.setSource(change.getSource()); // FIXME needed ?
	}
	
	protected void fillDBDiff(DBDiff newChange, Match match) {
		newChange.setTarget(match.getRight());
	}

	protected static EObject getValue(Match match) {
		EObject result = match.getRight();
		if (result == null) {
			result = match.getLeft();
		}
		return result;
	}
	
	protected static boolean isAddedOnLeft(EObject obj, Comparison comparison) {
		Match match = comparison.getMatch(obj);
		return match.getLeft() == obj && match.getRight() == null && match.getOrigin() == null;
	}
	
}
