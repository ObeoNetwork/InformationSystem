/**
 */
package org.obeonetwork.tools.classdiagramconfiguration.impl;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.tools.classdiagramconfiguration.ClassDiagramConfigurationPackage;
import org.obeonetwork.tools.classdiagramconfiguration.DiagramConf;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram Conf</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.DiagramConfImpl#getDescriptionId <em>Description Id</em>}</li>
 *   <li>{@link org.obeonetwork.tools.classdiagramconfiguration.impl.DiagramConfImpl#getMetamodels <em>Metamodels</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramConfImpl extends ConfigurationElementImpl implements DiagramConf {
	/**
	 * The default value of the '{@link #getDescriptionId() <em>Description Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionId()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_ID_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramConfImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassDiagramConfigurationPackage.Literals.DIAGRAM_CONF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescriptionId() {
		return (String)eDynamicGet(ClassDiagramConfigurationPackage.DIAGRAM_CONF__DESCRIPTION_ID, ClassDiagramConfigurationPackage.Literals.DIAGRAM_CONF__DESCRIPTION_ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionId(String newDescriptionId) {
		eDynamicSet(ClassDiagramConfigurationPackage.DIAGRAM_CONF__DESCRIPTION_ID, ClassDiagramConfigurationPackage.Literals.DIAGRAM_CONF__DESCRIPTION_ID, newDescriptionId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getMetamodels() {
		return (EList<String>)eDynamicGet(ClassDiagramConfigurationPackage.DIAGRAM_CONF__METAMODELS, ClassDiagramConfigurationPackage.Literals.DIAGRAM_CONF__METAMODELS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassDiagramConfigurationPackage.DIAGRAM_CONF__DESCRIPTION_ID:
				return getDescriptionId();
			case ClassDiagramConfigurationPackage.DIAGRAM_CONF__METAMODELS:
				return getMetamodels();
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
			case ClassDiagramConfigurationPackage.DIAGRAM_CONF__DESCRIPTION_ID:
				setDescriptionId((String)newValue);
				return;
			case ClassDiagramConfigurationPackage.DIAGRAM_CONF__METAMODELS:
				getMetamodels().clear();
				getMetamodels().addAll((Collection<? extends String>)newValue);
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
			case ClassDiagramConfigurationPackage.DIAGRAM_CONF__DESCRIPTION_ID:
				setDescriptionId(DESCRIPTION_ID_EDEFAULT);
				return;
			case ClassDiagramConfigurationPackage.DIAGRAM_CONF__METAMODELS:
				getMetamodels().clear();
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
			case ClassDiagramConfigurationPackage.DIAGRAM_CONF__DESCRIPTION_ID:
				return DESCRIPTION_ID_EDEFAULT == null ? getDescriptionId() != null : !DESCRIPTION_ID_EDEFAULT.equals(getDescriptionId());
			case ClassDiagramConfigurationPackage.DIAGRAM_CONF__METAMODELS:
				return !getMetamodels().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DiagramConfImpl
