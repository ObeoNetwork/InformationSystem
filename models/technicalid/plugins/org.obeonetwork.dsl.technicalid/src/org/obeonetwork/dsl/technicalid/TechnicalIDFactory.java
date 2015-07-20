/**
 */
package org.obeonetwork.dsl.technicalid;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.technicalid.TechnicalIDPackage
 * @generated
 */
public interface TechnicalIDFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TechnicalIDFactory eINSTANCE = org.obeonetwork.dsl.technicalid.impl.TechnicalIDFactoryImpl.init();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TechnicalIDPackage getTechnicalIDPackage();

} //TechnicalIDFactory
