/**
 */
package org.obeonetwork.tools.classdiagramconfiguration.impl;

import fr.obeo.dsl.viewpoint.description.Viewpoint;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage;
import org.obeonetwork.tools.classdiagramconfiguration.ColorInfo;
import org.obeonetwork.tools.classdiagramconfiguration.Configuration;
import org.obeonetwork.tools.classdiagramconfiguration.DiagramConf;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationImpl#getViewpoint <em>Viewpoint</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationImpl#getColors <em>Colors</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.ConfigurationImpl#getJavaExtensions <em>Java Extensions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends CDOObjectImpl implements Configuration {
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassDiagramConfigurationPackage.Literals.CONFIGURATION;
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
		return (String)eDynamicGet(ClassDiagramConfigurationPackage.CONFIGURATION__NAME, ClassDiagramConfigurationPackage.Literals.CONFIGURATION__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(ClassDiagramConfigurationPackage.CONFIGURATION__NAME, ClassDiagramConfigurationPackage.Literals.CONFIGURATION__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eDynamicGet(ClassDiagramConfigurationPackage.CONFIGURATION__DESCRIPTION, ClassDiagramConfigurationPackage.Literals.CONFIGURATION__DESCRIPTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eDynamicSet(ClassDiagramConfigurationPackage.CONFIGURATION__DESCRIPTION, ClassDiagramConfigurationPackage.Literals.CONFIGURATION__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Viewpoint getViewpoint() {
		return (Viewpoint)eDynamicGet(ClassDiagramConfigurationPackage.CONFIGURATION__VIEWPOINT, ClassDiagramConfigurationPackage.Literals.CONFIGURATION__VIEWPOINT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Viewpoint basicGetViewpoint() {
		return (Viewpoint)eDynamicGet(ClassDiagramConfigurationPackage.CONFIGURATION__VIEWPOINT, ClassDiagramConfigurationPackage.Literals.CONFIGURATION__VIEWPOINT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewpoint(Viewpoint newViewpoint) {
		eDynamicSet(ClassDiagramConfigurationPackage.CONFIGURATION__VIEWPOINT, ClassDiagramConfigurationPackage.Literals.CONFIGURATION__VIEWPOINT, newViewpoint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<DiagramConf> getDiagrams() {
		return (EList<DiagramConf>)eDynamicGet(ClassDiagramConfigurationPackage.CONFIGURATION__DIAGRAMS, ClassDiagramConfigurationPackage.Literals.CONFIGURATION__DIAGRAMS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ColorInfo> getColors() {
		return (EList<ColorInfo>)eDynamicGet(ClassDiagramConfigurationPackage.CONFIGURATION__COLORS, ClassDiagramConfigurationPackage.Literals.CONFIGURATION__COLORS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getJavaExtensions() {
		return (EList<String>)eDynamicGet(ClassDiagramConfigurationPackage.CONFIGURATION__JAVA_EXTENSIONS, ClassDiagramConfigurationPackage.Literals.CONFIGURATION__JAVA_EXTENSIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassDiagramConfigurationPackage.CONFIGURATION__DIAGRAMS:
				return ((InternalEList<?>)getDiagrams()).basicRemove(otherEnd, msgs);
			case ClassDiagramConfigurationPackage.CONFIGURATION__COLORS:
				return ((InternalEList<?>)getColors()).basicRemove(otherEnd, msgs);
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
			case ClassDiagramConfigurationPackage.CONFIGURATION__NAME:
				return getName();
			case ClassDiagramConfigurationPackage.CONFIGURATION__DESCRIPTION:
				return getDescription();
			case ClassDiagramConfigurationPackage.CONFIGURATION__VIEWPOINT:
				if (resolve) return getViewpoint();
				return basicGetViewpoint();
			case ClassDiagramConfigurationPackage.CONFIGURATION__DIAGRAMS:
				return getDiagrams();
			case ClassDiagramConfigurationPackage.CONFIGURATION__COLORS:
				return getColors();
			case ClassDiagramConfigurationPackage.CONFIGURATION__JAVA_EXTENSIONS:
				return getJavaExtensions();
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
			case ClassDiagramConfigurationPackage.CONFIGURATION__NAME:
				setName((String)newValue);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__VIEWPOINT:
				setViewpoint((Viewpoint)newValue);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__DIAGRAMS:
				getDiagrams().clear();
				getDiagrams().addAll((Collection<? extends DiagramConf>)newValue);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__COLORS:
				getColors().clear();
				getColors().addAll((Collection<? extends ColorInfo>)newValue);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__JAVA_EXTENSIONS:
				getJavaExtensions().clear();
				getJavaExtensions().addAll((Collection<? extends String>)newValue);
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
			case ClassDiagramConfigurationPackage.CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__VIEWPOINT:
				setViewpoint((Viewpoint)null);
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__DIAGRAMS:
				getDiagrams().clear();
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__COLORS:
				getColors().clear();
				return;
			case ClassDiagramConfigurationPackage.CONFIGURATION__JAVA_EXTENSIONS:
				getJavaExtensions().clear();
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
			case ClassDiagramConfigurationPackage.CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case ClassDiagramConfigurationPackage.CONFIGURATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
			case ClassDiagramConfigurationPackage.CONFIGURATION__VIEWPOINT:
				return basicGetViewpoint() != null;
			case ClassDiagramConfigurationPackage.CONFIGURATION__DIAGRAMS:
				return !getDiagrams().isEmpty();
			case ClassDiagramConfigurationPackage.CONFIGURATION__COLORS:
				return !getColors().isEmpty();
			case ClassDiagramConfigurationPackage.CONFIGURATION__JAVA_EXTENSIONS:
				return !getJavaExtensions().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConfigurationImpl
