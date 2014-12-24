/**
 */
package org.obeonetwork.tools.classdiagramconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage;
import org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement;
import org.obeonetwork.tools.classdiagramconfiguration.ConfigurationValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationValueImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationValueImpl#getFullQualifiedId <em>Full Qualified Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConfigurationValueImpl extends CDOObjectImpl implements ConfigurationValue {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getFullQualifiedId() <em>Full Qualified Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullQualifiedId()
	 * @generated
	 * @ordered
	 */
	protected static final String FULL_QUALIFIED_ID_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassDiagramConfigurationPackage.Literals.CONFIGURATION_VALUE;
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
	public String getId() {
		return (String)eDynamicGet(ClassDiagramConfigurationPackage.CONFIGURATION_VALUE__ID, ClassDiagramConfigurationPackage.Literals.CONFIGURATION_VALUE__ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eDynamicSet(ClassDiagramConfigurationPackage.CONFIGURATION_VALUE__ID, ClassDiagramConfigurationPackage.Literals.CONFIGURATION_VALUE__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getFullQualifiedId() {
		if (eContainer() instanceof ConfigurationElement) {
			return ((ConfigurationElement)eContainer()).getFullQualifiedId() + "." + getId();
		} else {
			return getId();
		}		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassDiagramConfigurationPackage.CONFIGURATION_VALUE__ID:
				return getId();
			case ClassDiagramConfigurationPackage.CONFIGURATION_VALUE__FULL_QUALIFIED_ID:
				return getFullQualifiedId();
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
			case ClassDiagramConfigurationPackage.CONFIGURATION_VALUE__ID:
				setId((String)newValue);
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
			case ClassDiagramConfigurationPackage.CONFIGURATION_VALUE__ID:
				setId(ID_EDEFAULT);
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
			case ClassDiagramConfigurationPackage.CONFIGURATION_VALUE__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case ClassDiagramConfigurationPackage.CONFIGURATION_VALUE__FULL_QUALIFIED_ID:
				return FULL_QUALIFIED_ID_EDEFAULT == null ? getFullQualifiedId() != null : !FULL_QUALIFIED_ID_EDEFAULT.equals(getFullQualifiedId());
		}
		return super.eIsSet(featureID);
	}

} //ConfigurationValueImpl
