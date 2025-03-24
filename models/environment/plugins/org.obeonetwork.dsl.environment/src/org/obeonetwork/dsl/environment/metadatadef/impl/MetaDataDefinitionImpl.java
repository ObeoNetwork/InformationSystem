/**
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.environment.metadatadef.impl;

import org.eclipse.emf.ecore.EClass;

import org.obeonetwork.dsl.environment.metadatadef.MetaDataDefinition;
import org.obeonetwork.dsl.environment.metadatadef.MetadatadefPackage;

import org.obeonetwork.dsl.technicalid.impl.IdentifiableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta Data Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.environment.metadatadef.impl.MetaDataDefinitionImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.metadatadef.impl.MetaDataDefinitionImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.environment.metadatadef.impl.MetaDataDefinitionImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetaDataDefinitionImpl extends IdentifiableImpl implements MetaDataDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2025 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getBody() <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected static final String BODY_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String CONDITION_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaDataDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetadatadefPackage.Literals.META_DATA_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTitle() {
		return (String) eDynamicGet(MetadatadefPackage.META_DATA_DEFINITION__TITLE,
				MetadatadefPackage.Literals.META_DATA_DEFINITION__TITLE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTitle(String newTitle) {
		eDynamicSet(MetadatadefPackage.META_DATA_DEFINITION__TITLE,
				MetadatadefPackage.Literals.META_DATA_DEFINITION__TITLE, newTitle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBody() {
		return (String) eDynamicGet(MetadatadefPackage.META_DATA_DEFINITION__BODY,
				MetadatadefPackage.Literals.META_DATA_DEFINITION__BODY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBody(String newBody) {
		eDynamicSet(MetadatadefPackage.META_DATA_DEFINITION__BODY,
				MetadatadefPackage.Literals.META_DATA_DEFINITION__BODY, newBody);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCondition() {
		return (String) eDynamicGet(MetadatadefPackage.META_DATA_DEFINITION__CONDITION,
				MetadatadefPackage.Literals.META_DATA_DEFINITION__CONDITION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCondition(String newCondition) {
		eDynamicSet(MetadatadefPackage.META_DATA_DEFINITION__CONDITION,
				MetadatadefPackage.Literals.META_DATA_DEFINITION__CONDITION, newCondition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MetadatadefPackage.META_DATA_DEFINITION__TITLE:
			return getTitle();
		case MetadatadefPackage.META_DATA_DEFINITION__BODY:
			return getBody();
		case MetadatadefPackage.META_DATA_DEFINITION__CONDITION:
			return getCondition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MetadatadefPackage.META_DATA_DEFINITION__TITLE:
			setTitle((String) newValue);
			return;
		case MetadatadefPackage.META_DATA_DEFINITION__BODY:
			setBody((String) newValue);
			return;
		case MetadatadefPackage.META_DATA_DEFINITION__CONDITION:
			setCondition((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case MetadatadefPackage.META_DATA_DEFINITION__TITLE:
			setTitle(TITLE_EDEFAULT);
			return;
		case MetadatadefPackage.META_DATA_DEFINITION__BODY:
			setBody(BODY_EDEFAULT);
			return;
		case MetadatadefPackage.META_DATA_DEFINITION__CONDITION:
			setCondition(CONDITION_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MetadatadefPackage.META_DATA_DEFINITION__TITLE:
			return TITLE_EDEFAULT == null ? getTitle() != null : !TITLE_EDEFAULT.equals(getTitle());
		case MetadatadefPackage.META_DATA_DEFINITION__BODY:
			return BODY_EDEFAULT == null ? getBody() != null : !BODY_EDEFAULT.equals(getBody());
		case MetadatadefPackage.META_DATA_DEFINITION__CONDITION:
			return CONDITION_EDEFAULT == null ? getCondition() != null : !CONDITION_EDEFAULT.equals(getCondition());
		}
		return super.eIsSet(featureID);
	}

} //MetaDataDefinitionImpl
