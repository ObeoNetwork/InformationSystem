/**
 */
package org.obeonetwork.tools.classdiagramconfiguration.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage;
import org.obeonetwork.tools.classdiagramconfiguration.ColorInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Color Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ColorInfoImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ColorInfoImpl#getRed <em>Red</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ColorInfoImpl#getGreen <em>Green</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ColorInfoImpl#getBlue <em>Blue</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColorInfoImpl extends CDOObjectImpl implements ColorInfo {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getRed() <em>Red</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRed()
	 * @generated
	 * @ordered
	 */
	protected static final int RED_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getGreen() <em>Green</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGreen()
	 * @generated
	 * @ordered
	 */
	protected static final int GREEN_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getBlue() <em>Blue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlue()
	 * @generated
	 * @ordered
	 */
	protected static final int BLUE_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColorInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassDiagramConfigurationPackage.Literals.COLOR_INFO;
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
	public String getName() {
		return (String)eDynamicGet(ClassDiagramConfigurationPackage.COLOR_INFO__NAME, ClassDiagramConfigurationPackage.Literals.COLOR_INFO__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(ClassDiagramConfigurationPackage.COLOR_INFO__NAME, ClassDiagramConfigurationPackage.Literals.COLOR_INFO__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRed() {
		return (Integer)eDynamicGet(ClassDiagramConfigurationPackage.COLOR_INFO__RED, ClassDiagramConfigurationPackage.Literals.COLOR_INFO__RED, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRed(int newRed) {
		eDynamicSet(ClassDiagramConfigurationPackage.COLOR_INFO__RED, ClassDiagramConfigurationPackage.Literals.COLOR_INFO__RED, newRed);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getGreen() {
		return (Integer)eDynamicGet(ClassDiagramConfigurationPackage.COLOR_INFO__GREEN, ClassDiagramConfigurationPackage.Literals.COLOR_INFO__GREEN, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGreen(int newGreen) {
		eDynamicSet(ClassDiagramConfigurationPackage.COLOR_INFO__GREEN, ClassDiagramConfigurationPackage.Literals.COLOR_INFO__GREEN, newGreen);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBlue() {
		return (Integer)eDynamicGet(ClassDiagramConfigurationPackage.COLOR_INFO__BLUE, ClassDiagramConfigurationPackage.Literals.COLOR_INFO__BLUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlue(int newBlue) {
		eDynamicSet(ClassDiagramConfigurationPackage.COLOR_INFO__BLUE, ClassDiagramConfigurationPackage.Literals.COLOR_INFO__BLUE, newBlue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassDiagramConfigurationPackage.COLOR_INFO__NAME:
				return getName();
			case ClassDiagramConfigurationPackage.COLOR_INFO__RED:
				return getRed();
			case ClassDiagramConfigurationPackage.COLOR_INFO__GREEN:
				return getGreen();
			case ClassDiagramConfigurationPackage.COLOR_INFO__BLUE:
				return getBlue();
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
			case ClassDiagramConfigurationPackage.COLOR_INFO__NAME:
				setName((String)newValue);
				return;
			case ClassDiagramConfigurationPackage.COLOR_INFO__RED:
				setRed((Integer)newValue);
				return;
			case ClassDiagramConfigurationPackage.COLOR_INFO__GREEN:
				setGreen((Integer)newValue);
				return;
			case ClassDiagramConfigurationPackage.COLOR_INFO__BLUE:
				setBlue((Integer)newValue);
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
			case ClassDiagramConfigurationPackage.COLOR_INFO__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ClassDiagramConfigurationPackage.COLOR_INFO__RED:
				setRed(RED_EDEFAULT);
				return;
			case ClassDiagramConfigurationPackage.COLOR_INFO__GREEN:
				setGreen(GREEN_EDEFAULT);
				return;
			case ClassDiagramConfigurationPackage.COLOR_INFO__BLUE:
				setBlue(BLUE_EDEFAULT);
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
			case ClassDiagramConfigurationPackage.COLOR_INFO__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case ClassDiagramConfigurationPackage.COLOR_INFO__RED:
				return getRed() != RED_EDEFAULT;
			case ClassDiagramConfigurationPackage.COLOR_INFO__GREEN:
				return getGreen() != GREEN_EDEFAULT;
			case ClassDiagramConfigurationPackage.COLOR_INFO__BLUE:
				return getBlue() != BLUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //ColorInfoImpl
