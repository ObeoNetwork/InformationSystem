/**
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.gouv.mindef.safran.database.scaffold.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryKind;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldFactory;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldPackage;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldType;
import fr.gouv.mindef.safran.database.scaffold.TraceabilityInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldInfoImpl#getLeftObject <em>Left Object</em>}</li>
 *   <li>{@link fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldInfoImpl#getRightObject <em>Right Object</em>}</li>
 *   <li>{@link fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldInfoImpl#getLeftToRightAdditionalObjects <em>Left To Right Additional Objects</em>}</li>
 *   <li>{@link fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldInfoImpl#getRightToLeftAdditionalObjects <em>Right To Left Additional Objects</em>}</li>
 *   <li>{@link fr.gouv.mindef.safran.database.scaffold.impl.ScaffoldInfoImpl#getTraceabilityInfos <em>Traceability Infos</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScaffoldInfoImpl extends CDOObjectImpl implements ScaffoldInfo {
	
	private static final String DATABASE_NS_URI = "http://www.obeonetwork.org/dsl/database/";
	private static final String ENTITY_NS_URI = "http://www.obeonetwork.org/dsl/entity/";
	
	private ScaffoldType leftToRightTransformationType = null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2022 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScaffoldInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScaffoldPackage.Literals.SCAFFOLD_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getLeftObject() {
		return (EObject)eGet(ScaffoldPackage.Literals.SCAFFOLD_INFO__LEFT_OBJECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftObject(EObject newLeftObject) {
		eSet(ScaffoldPackage.Literals.SCAFFOLD_INFO__LEFT_OBJECT, newLeftObject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getRightObject() {
		return (EObject)eGet(ScaffoldPackage.Literals.SCAFFOLD_INFO__RIGHT_OBJECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightObject(EObject newRightObject) {
		eSet(ScaffoldPackage.Literals.SCAFFOLD_INFO__RIGHT_OBJECT, newRightObject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<EObject> getLeftToRightAdditionalObjects() {
		return (EList<EObject>)eGet(ScaffoldPackage.Literals.SCAFFOLD_INFO__LEFT_TO_RIGHT_ADDITIONAL_OBJECTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<EObject> getRightToLeftAdditionalObjects() {
		return (EList<EObject>)eGet(ScaffoldPackage.Literals.SCAFFOLD_INFO__RIGHT_TO_LEFT_ADDITIONAL_OBJECTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<TraceabilityInfo> getTraceabilityInfos() {
		return (EList<TraceabilityInfo>)eGet(ScaffoldPackage.Literals.SCAFFOLD_INFO__TRACEABILITY_INFOS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ScaffoldType getLeftToRightTransformationType() {
		if (leftToRightTransformationType == null) {
			leftToRightTransformationType = getScaffoldType(getLeftObject(), getRightObject());
		}
		return leftToRightTransformationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ScaffoldType getRightToLeftTransformationType() {
		if (getLeftToRightTransformationType() != null) {
			return getLeftToRightTransformationType().getOppositeScaffoldType();
		}
		return null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EObject getStartingObjectForTransformation(ScaffoldType scaffoldType) {
		if (scaffoldType == getLeftToRightTransformationType()) {
			return getLeftObject();
		} else if (scaffoldType == getRightToLeftTransformationType()) {
			return getRightObject();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EObject getEndingObjectForTransformation(ScaffoldType scaffoldType) {
		if (scaffoldType == getLeftToRightTransformationType()) {
			return getRightObject();
		} else if (scaffoldType == getRightToLeftTransformationType()) {
			return getLeftObject();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EObject> getAdditionalObjectsForTransformation(ScaffoldType scaffoldType) {
		if (getLeftToRightTransformationType() == scaffoldType) {
			return getLeftToRightAdditionalObjects();
		} else if (getRightToLeftTransformationType() == scaffoldType) {
			return getRightToLeftAdditionalObjects();
		}
		return ECollections.emptyEList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setStartingObjectForTransformation(EObject object, ScaffoldType scaffoldType) {
		if (getLeftToRightTransformationType() == null || scaffoldType == getLeftToRightTransformationType()) {
			setLeftObject(object);
		} else if (scaffoldType == getRightToLeftTransformationType()) {
			setRightObject(object);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setEndingObjectForTransformation(EObject object, ScaffoldType scaffoldType) {
		if (getLeftToRightTransformationType() == null || scaffoldType == getLeftToRightTransformationType()) {
			setRightObject(object);
		} else if (scaffoldType == getRightToLeftTransformationType()) {
			setLeftObject(object);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void clearAdditionalObjectsForTransformation(ScaffoldType scaffoldType) {
		if (scaffoldType == getLeftToRightTransformationType()) {
			getLeftToRightAdditionalObjects().clear();
		} else if (scaffoldType == getRightToLeftTransformationType()) {
			getRightToLeftAdditionalObjects().clear();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addAdditionalObjectsForTransformation(EObject object, ScaffoldType scaffoldType) {
		if (scaffoldType == getLeftToRightTransformationType()) {
			getLeftToRightAdditionalObjects().add(object);
		} else if (scaffoldType == getRightToLeftTransformationType()) {
			getRightToLeftAdditionalObjects().add(object);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EMap<EObject, EObject> getTraceabilityMap(ScaffoldType scaffoldType) {
		Map<EObject, EObject> result = new HashMap<EObject, EObject>();
		
		if (scaffoldType == getLeftToRightTransformationType()) {
			for (TraceabilityInfo info : getTraceabilityInfos()) {
				if (info.getLeft() != null && info.getRight() != null && !info.getLeft().eIsProxy() && !info.getRight().eIsProxy()) {
					result.put(info.getLeft(), info.getRight());
				}
			}
		} else if (scaffoldType == getRightToLeftTransformationType()) {
			for (TraceabilityInfo info : getTraceabilityInfos()) {
				if (info.getLeft() != null && info.getRight() != null && !info.getLeft().eIsProxy() && !info.getRight().eIsProxy()) {					
					result.put(info.getRight(), info.getLeft());
				}
			}
		}
		return new BasicEMap<EObject, EObject>(result);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void replaceTraceabilityInfos(ScaffoldType scaffoldType, EMap<EObject, EObject> infos) {
		getTraceabilityInfos().clear();
		if (scaffoldType == getLeftToRightTransformationType()) {
			for (Entry<EObject, EObject> entry : infos) {
				TraceabilityInfo info = ScaffoldFactory.eINSTANCE.createTraceabilityInfo();
				info.setLeft(entry.getKey());
				info.setRight(entry.getValue());
				getTraceabilityInfos().add(info);
			}
		} else if (scaffoldType == getRightToLeftTransformationType()) {
			for (Entry<EObject, EObject> entry : infos) {
				TraceabilityInfo info = ScaffoldFactory.eINSTANCE.createTraceabilityInfo();
				info.setRight(entry.getKey());
				info.setLeft(entry.getValue());
				getTraceabilityInfos().add(info);
			}
		}
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ScaffoldPackage.SCAFFOLD_INFO__LEFT_OBJECT:
		case ScaffoldPackage.SCAFFOLD_INFO__RIGHT_OBJECT:
			leftToRightTransformationType = null;
			break;
		}
		super.eSet(featureID, newValue);
	}
	
	private ScaffoldType getScaffoldType(EObject from, EObject to) {
		if (from != null && to != null) {
			if (from.eClass().getEPackage().getNsURI().startsWith(ENTITY_NS_URI)) {
				if (to.eClass().getEPackage().getNsURI().startsWith(DATABASE_NS_URI)) {
					if (isInMld(to)) {
						return ScaffoldType.ENTITY_TO_MLD;
					}
				}
			} else if (from.eClass().getEPackage().getNsURI().startsWith(DATABASE_NS_URI)) {
				if (to.eClass().getEPackage().getNsURI().startsWith(ENTITY_NS_URI)) {
					return ScaffoldType.MLD_TO_ENTITY;
				} else if (to.eClass().getEPackage().getNsURI().startsWith(DATABASE_NS_URI)) {
					if (isInMpd(from) && isInMld(to)) {
						return ScaffoldType.MPD_TO_MLD;
					} else if (isInMld(from) && isInMpd(to)) {
						return ScaffoldType.MLD_TO_MPD;
					}
				}
			}
		}
		
		// Unable to get scaffolding type, maybe because one of the objets is from Environment metamodel
		EObject fromRoot = EcoreUtil.getRootContainer(from);
		EObject toRoot = EcoreUtil.getRootContainer(to);
		if (fromRoot != from || toRoot != to) {
			return getScaffoldType(fromRoot, toRoot);
		}
		
		return null;
	}
	
	private boolean isInMld(EObject object) {
		if (object instanceof DatabaseElement) {
			if (object instanceof DataBase) {
				return usesLibraryOfKind((DataBase)object, TypesLibraryKind.LOGICAL_TYPES);
			} else {
				return isInMld(object.eContainer());
			}
		}
		return false;
	}
	
	private boolean isInMpd(EObject object) {
		if (object instanceof DatabaseElement) {
			if (object instanceof DataBase) {
				return usesLibraryOfKind((DataBase)object, TypesLibraryKind.PHYSICAL_TYPES);
			} else {
				return isInMpd(object.eContainer());
			}
		}
		return false;
	}
	
	private boolean usesLibraryOfKind(DataBase database, TypesLibraryKind kind) {
		for (TypesLibrary typesLibrary : database.getUsedLibraries()) {
			if (kind.equals(typesLibrary.getKind())) {
				return true;
			}
		}
		return false;
	}

} //ScaffoldInfoImpl
