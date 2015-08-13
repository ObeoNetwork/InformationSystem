/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.ecorebinding.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.obeonetwork.dsl.ecorebinding.*;

import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.technicalid.Identifiable;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.ecorebinding.EcorebindingPackage
 * @generated
 */
public class EcorebindingSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EcorebindingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcorebindingSwitch() {
		if (modelPackage == null) {
			modelPackage = EcorebindingPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EcorebindingPackage.BBASE: {
				BBase bBase = (BBase)theEObject;
				T result = caseBBase(bBase);
				if (result == null) result = caseBoundableElement(bBase);
				if (result == null) result = caseIdentifiable(bBase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcorebindingPackage.BMODEL: {
				BModel bModel = (BModel)theEObject;
				T result = caseBModel(bModel);
				if (result == null) result = caseBBase(bModel);
				if (result == null) result = caseBoundableElement(bModel);
				if (result == null) result = caseIdentifiable(bModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcorebindingPackage.BPACKAGE: {
				BPackage bPackage = (BPackage)theEObject;
				T result = caseBPackage(bPackage);
				if (result == null) result = caseBBase(bPackage);
				if (result == null) result = caseBoundableElement(bPackage);
				if (result == null) result = caseIdentifiable(bPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcorebindingPackage.BCLASS: {
				BClass bClass = (BClass)theEObject;
				T result = caseBClass(bClass);
				if (result == null) result = caseBClassifier(bClass);
				if (result == null) result = caseBBase(bClass);
				if (result == null) result = caseBoundableElement(bClass);
				if (result == null) result = caseIdentifiable(bClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcorebindingPackage.BFEATURE: {
				BFeature bFeature = (BFeature)theEObject;
				T result = caseBFeature(bFeature);
				if (result == null) result = caseBTypedElement(bFeature);
				if (result == null) result = caseBBase(bFeature);
				if (result == null) result = caseBoundableElement(bFeature);
				if (result == null) result = caseIdentifiable(bFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcorebindingPackage.BENUM: {
				BEnum bEnum = (BEnum)theEObject;
				T result = caseBEnum(bEnum);
				if (result == null) result = caseBDataType(bEnum);
				if (result == null) result = caseBClassifier(bEnum);
				if (result == null) result = caseBBase(bEnum);
				if (result == null) result = caseBoundableElement(bEnum);
				if (result == null) result = caseIdentifiable(bEnum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcorebindingPackage.BENUM_LITERAL: {
				BEnumLiteral bEnumLiteral = (BEnumLiteral)theEObject;
				T result = caseBEnumLiteral(bEnumLiteral);
				if (result == null) result = caseBBase(bEnumLiteral);
				if (result == null) result = caseBoundableElement(bEnumLiteral);
				if (result == null) result = caseIdentifiable(bEnumLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcorebindingPackage.BCLASSIFIER: {
				BClassifier bClassifier = (BClassifier)theEObject;
				T result = caseBClassifier(bClassifier);
				if (result == null) result = caseBBase(bClassifier);
				if (result == null) result = caseBoundableElement(bClassifier);
				if (result == null) result = caseIdentifiable(bClassifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcorebindingPackage.BDATA_TYPE: {
				BDataType bDataType = (BDataType)theEObject;
				T result = caseBDataType(bDataType);
				if (result == null) result = caseBClassifier(bDataType);
				if (result == null) result = caseBBase(bDataType);
				if (result == null) result = caseBoundableElement(bDataType);
				if (result == null) result = caseIdentifiable(bDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcorebindingPackage.BOPERATION: {
				BOperation bOperation = (BOperation)theEObject;
				T result = caseBOperation(bOperation);
				if (result == null) result = caseBTypedElement(bOperation);
				if (result == null) result = caseBBase(bOperation);
				if (result == null) result = caseBoundableElement(bOperation);
				if (result == null) result = caseIdentifiable(bOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcorebindingPackage.BPARAMETER: {
				BParameter bParameter = (BParameter)theEObject;
				T result = caseBParameter(bParameter);
				if (result == null) result = caseBTypedElement(bParameter);
				if (result == null) result = caseBBase(bParameter);
				if (result == null) result = caseBoundableElement(bParameter);
				if (result == null) result = caseIdentifiable(bParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcorebindingPackage.BTYPED_ELEMENT: {
				BTypedElement bTypedElement = (BTypedElement)theEObject;
				T result = caseBTypedElement(bTypedElement);
				if (result == null) result = caseBBase(bTypedElement);
				if (result == null) result = caseBoundableElement(bTypedElement);
				if (result == null) result = caseIdentifiable(bTypedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcorebindingPackage.BTYPE_PARAMETER: {
				BTypeParameter bTypeParameter = (BTypeParameter)theEObject;
				T result = caseBTypeParameter(bTypeParameter);
				if (result == null) result = caseBBase(bTypeParameter);
				if (result == null) result = caseBoundableElement(bTypeParameter);
				if (result == null) result = caseIdentifiable(bTypeParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BBase</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BBase</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBBase(BBase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BModel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BModel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBModel(BModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPackage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPackage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPackage(BPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BClass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BClass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBClass(BClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BFeature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BFeature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBFeature(BFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BEnum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BEnum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBEnum(BEnum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BEnum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BEnum Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBEnumLiteral(BEnumLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BClassifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BClassifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBClassifier(BClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BData Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BData Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBDataType(BDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BOperation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BOperation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBOperation(BOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BParameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BParameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBParameter(BParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BTyped Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BTyped Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBTypedElement(BTypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BType Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BType Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBTypeParameter(BTypeParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifiable(Identifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boundable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boundable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundableElement(BoundableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //EcorebindingSwitch
