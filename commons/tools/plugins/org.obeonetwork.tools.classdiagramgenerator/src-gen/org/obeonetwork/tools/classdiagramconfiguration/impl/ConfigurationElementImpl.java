/**
 */
package org.obeonetwork.tools.classdiagramconfiguration.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.obeonetwork.tools.classdiagramconfiguration.BooleanValue;
import org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage;
import org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement;
import org.obeonetwork.tools.classdiagramconfiguration.StringValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationElementImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationElementImpl#getFullQualifiedId <em>Full Qualified Id</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationElementImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationElementImpl#getStringValues <em>String Values</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationElementImpl#getBooleanValues <em>Boolean Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationElementImpl extends CDOObjectImpl implements ConfigurationElement {
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
	protected ConfigurationElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassDiagramConfigurationPackage.Literals.CONFIGURATION_ELEMENT;
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
		return (String)eDynamicGet(ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__ID, ClassDiagramConfigurationPackage.Literals.CONFIGURATION_ELEMENT__ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eDynamicSet(ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__ID, ClassDiagramConfigurationPackage.Literals.CONFIGURATION_ELEMENT__ID, newId);
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
	@SuppressWarnings("unchecked")
	public EList<ConfigurationElement> getChildren() {
		return (EList<ConfigurationElement>)eDynamicGet(ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__CHILDREN, ClassDiagramConfigurationPackage.Literals.CONFIGURATION_ELEMENT__CHILDREN, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<StringValue> getStringValues() {
		return (EList<StringValue>)eDynamicGet(ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__STRING_VALUES, ClassDiagramConfigurationPackage.Literals.CONFIGURATION_ELEMENT__STRING_VALUES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<BooleanValue> getBooleanValues() {
		return (EList<BooleanValue>)eDynamicGet(ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__BOOLEAN_VALUES, ClassDiagramConfigurationPackage.Literals.CONFIGURATION_ELEMENT__BOOLEAN_VALUES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__STRING_VALUES:
				return ((InternalEList<?>)getStringValues()).basicRemove(otherEnd, msgs);
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__BOOLEAN_VALUES:
				return ((InternalEList<?>)getBooleanValues()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__ID:
				return getId();
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__FULL_QUALIFIED_ID:
				return getFullQualifiedId();
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__CHILDREN:
				return getChildren();
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__STRING_VALUES:
				return getStringValues();
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__BOOLEAN_VALUES:
				return getBooleanValues();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__ID:
				setId((String)newValue);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends ConfigurationElement>)newValue);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__STRING_VALUES:
				getStringValues().clear();
				getStringValues().addAll((Collection<? extends StringValue>)newValue);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__BOOLEAN_VALUES:
				getBooleanValues().clear();
				getBooleanValues().addAll((Collection<? extends BooleanValue>)newValue);
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
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__ID:
				setId(ID_EDEFAULT);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__CHILDREN:
				getChildren().clear();
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__STRING_VALUES:
				getStringValues().clear();
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__BOOLEAN_VALUES:
				getBooleanValues().clear();
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
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__FULL_QUALIFIED_ID:
				return FULL_QUALIFIED_ID_EDEFAULT == null ? getFullQualifiedId() != null : !FULL_QUALIFIED_ID_EDEFAULT.equals(getFullQualifiedId());
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__CHILDREN:
				return !getChildren().isEmpty();
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__STRING_VALUES:
				return !getStringValues().isEmpty();
			case ClassDiagramConfigurationPackage.CONFIGURATION_ELEMENT__BOOLEAN_VALUES:
				return !getBooleanValues().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConfigurationElementImpl
