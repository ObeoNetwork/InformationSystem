/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.entityrelation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.obeonetwork.dsl.entityrelation.*;
import org.obeonetwork.dsl.entityrelation.Attribute;
import org.obeonetwork.dsl.entityrelation.Cardinality;
import org.obeonetwork.dsl.entityrelation.Entity;
import org.obeonetwork.dsl.entityrelation.EntityRelationFactory;
import org.obeonetwork.dsl.entityrelation.EntityRelationPackage;
import org.obeonetwork.dsl.entityrelation.Identifier;
import org.obeonetwork.dsl.entityrelation.LogicalModel;
import org.obeonetwork.dsl.entityrelation.Relation;
import org.obeonetwork.dsl.entityrelation.RelationElement;
import org.obeonetwork.dsl.entityrelation.spec.RelationSpec;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EntityRelationFactoryImpl extends EFactoryImpl implements EntityRelationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EntityRelationFactory init() {
		try {
			EntityRelationFactory theEntityRelationFactory = (EntityRelationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.obeonetwork.org/dsl/entityrelation/1.0"); 
			if (theEntityRelationFactory != null) {
				return theEntityRelationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EntityRelationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityRelationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EntityRelationPackage.LOGICAL_MODEL: return (EObject)createLogicalModel();
			case EntityRelationPackage.ENTITY: return (EObject)createEntity();
			case EntityRelationPackage.RELATION: return (EObject)createRelation();
			case EntityRelationPackage.RELATION_ELEMENT: return (EObject)createRelationElement();
			case EntityRelationPackage.ATTRIBUTE: return (EObject)createAttribute();
			case EntityRelationPackage.IDENTIFIER: return (EObject)createIdentifier();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EntityRelationPackage.CARDINALITY:
				return createCardinalityFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EntityRelationPackage.CARDINALITY:
				return convertCardinalityToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalModel createLogicalModel() {
		LogicalModelImpl logicalModel = new LogicalModelImpl();
		return logicalModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity createEntity() {
		EntityImpl entity = new EntityImpl();
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated Not
	 */
	public Relation createRelation() {
		RelationImpl relation = new RelationSpec();
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationElement createRelationElement() {
		RelationElementImpl relationElement = new RelationElementImpl();
		return relationElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		TypeInstance type = TypesLibraryFactory.eINSTANCE.createTypeInstance();
		attribute.setType(type);
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier createIdentifier() {
		IdentifierImpl identifier = new IdentifierImpl();
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Cardinality createCardinalityFromString(EDataType eDataType, String initialValue) {
		Cardinality result = Cardinality.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCardinalityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityRelationPackage getEntityRelationPackage() {
		return (EntityRelationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EntityRelationPackage getPackage() {
		return EntityRelationPackage.eINSTANCE;
	}

} //EntityRelationFactoryImpl
