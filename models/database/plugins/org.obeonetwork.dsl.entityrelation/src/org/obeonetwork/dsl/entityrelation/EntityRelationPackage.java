/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.entityrelation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.entityrelation.EntityRelationFactory
 * @model kind="package"
 * @generated
 */
public interface EntityRelationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "entityrelation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeonetwork.org/dsl/entityrelation/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "entityrelation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EntityRelationPackage eINSTANCE = org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entityrelation.impl.LogicalElementImpl <em>Logical Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entityrelation.impl.LogicalElementImpl
	 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getLogicalElement()
	 * @generated
	 */
	int LOGICAL_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_ELEMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_ELEMENT__COMMENTS = 1;

	/**
	 * The number of structural features of the '<em>Logical Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entityrelation.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entityrelation.impl.NamedElementImpl
	 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__ID = LOGICAL_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__COMMENTS = LOGICAL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = LOGICAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = LOGICAL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entityrelation.impl.LogicalModelImpl <em>Logical Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entityrelation.impl.LogicalModelImpl
	 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getLogicalModel()
	 * @generated
	 */
	int LOGICAL_MODEL = 0;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_MODEL__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_MODEL__COMMENTS = NAMED_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_MODEL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Used Libraries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_MODEL__USED_LIBRARIES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_MODEL__ENTITIES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_MODEL__RELATIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Logical Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_MODEL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entityrelation.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entityrelation.impl.EntityImpl
	 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 1;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__COMMENTS = NAMED_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ATTRIBUTES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Identifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__IDENTIFIERS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Primary Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__PRIMARY_IDENTIFIER = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entityrelation.impl.RelationImpl <em>Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entityrelation.impl.RelationImpl
	 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getRelation()
	 * @generated
	 */
	int RELATION = 2;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__COMMENTS = NAMED_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__SOURCE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__SOURCE_ROLE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__SOURCE_CARDINALITY = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source Is Composite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__SOURCE_IS_COMPOSITE = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__TARGET = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Target Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__TARGET_ROLE = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Target Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__TARGET_CARDINALITY = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Target Is Composite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__TARGET_IS_COMPOSITE = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__ELEMENTS = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__IDENTIFIER = NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entityrelation.impl.RelationElementImpl <em>Relation Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entityrelation.impl.RelationElementImpl
	 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getRelationElement()
	 * @generated
	 */
	int RELATION_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ELEMENT__ID = LOGICAL_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ELEMENT__COMMENTS = LOGICAL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Source Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ELEMENT__SOURCE_ATTRIBUTE = LOGICAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ELEMENT__TARGET_ATTRIBUTE = LOGICAL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Relation Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_ELEMENT_FEATURE_COUNT = LOGICAL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entityrelation.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entityrelation.impl.AttributeImpl
	 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 4;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__COMMENTS = NAMED_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__OWNER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__REQUIRED = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Used In Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__USED_IN_IDENTIFIER = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>In Primary Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IN_PRIMARY_IDENTIFIER = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entityrelation.impl.IdentifierImpl <em>Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entityrelation.impl.IdentifierImpl
	 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getIdentifier()
	 * @generated
	 */
	int IDENTIFIER = 7;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__COMMENTS = NAMED_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__ATTRIBUTES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.obeonetwork.dsl.entityrelation.Cardinality <em>Cardinality</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.obeonetwork.dsl.entityrelation.Cardinality
	 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getCardinality()
	 * @generated
	 */
	int CARDINALITY = 8;


	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entityrelation.LogicalModel <em>Logical Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Model</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.LogicalModel
	 * @generated
	 */
	EClass getLogicalModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.entityrelation.LogicalModel#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entities</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.LogicalModel#getEntities()
	 * @see #getLogicalModel()
	 * @generated
	 */
	EReference getLogicalModel_Entities();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.entityrelation.LogicalModel#getRelations <em>Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Relations</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.LogicalModel#getRelations()
	 * @see #getLogicalModel()
	 * @generated
	 */
	EReference getLogicalModel_Relations();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entityrelation.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.entityrelation.Entity#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Entity#getAttributes()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.entityrelation.Entity#getIdentifiers <em>Identifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Identifiers</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Entity#getIdentifiers()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Identifiers();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.entityrelation.Entity#getPrimaryIdentifier <em>Primary Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primary Identifier</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Entity#getPrimaryIdentifier()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_PrimaryIdentifier();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entityrelation.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Relation
	 * @generated
	 */
	EClass getRelation();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.entityrelation.Relation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Relation#getSource()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entityrelation.Relation#getSourceRole <em>Source Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Role</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Relation#getSourceRole()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_SourceRole();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entityrelation.Relation#getSourceCardinality <em>Source Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Cardinality</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Relation#getSourceCardinality()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_SourceCardinality();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entityrelation.Relation#isSourceIsComposite <em>Source Is Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Is Composite</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Relation#isSourceIsComposite()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_SourceIsComposite();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.entityrelation.Relation#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Relation#getTarget()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entityrelation.Relation#getTargetRole <em>Target Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Role</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Relation#getTargetRole()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_TargetRole();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entityrelation.Relation#getTargetCardinality <em>Target Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Cardinality</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Relation#getTargetCardinality()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_TargetCardinality();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entityrelation.Relation#isTargetIsComposite <em>Target Is Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Is Composite</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Relation#isTargetIsComposite()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_TargetIsComposite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.obeonetwork.dsl.entityrelation.Relation#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Relation#getElements()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Elements();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.entityrelation.Relation#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifier</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Relation#getIdentifier()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Identifier();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entityrelation.RelationElement <em>Relation Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Element</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.RelationElement
	 * @generated
	 */
	EClass getRelationElement();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.entityrelation.RelationElement#getSourceAttribute <em>Source Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Attribute</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.RelationElement#getSourceAttribute()
	 * @see #getRelationElement()
	 * @generated
	 */
	EReference getRelationElement_SourceAttribute();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.entityrelation.RelationElement#getTargetAttribute <em>Target Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Attribute</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.RelationElement#getTargetAttribute()
	 * @see #getRelationElement()
	 * @generated
	 */
	EReference getRelationElement_TargetAttribute();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entityrelation.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the container reference '{@link org.obeonetwork.dsl.entityrelation.Attribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Attribute#getOwner()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Owner();

	/**
	 * Returns the meta object for the containment reference '{@link org.obeonetwork.dsl.entityrelation.Attribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Attribute#getType()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entityrelation.Attribute#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Attribute#isRequired()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Required();

	/**
	 * Returns the meta object for the reference '{@link org.obeonetwork.dsl.entityrelation.Attribute#getUsedInIdentifier <em>Used In Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Used In Identifier</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Attribute#getUsedInIdentifier()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_UsedInIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entityrelation.Attribute#isInPrimaryIdentifier <em>In Primary Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>In Primary Identifier</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Attribute#isInPrimaryIdentifier()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_InPrimaryIdentifier();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entityrelation.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entityrelation.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entityrelation.LogicalElement <em>Logical Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Element</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.LogicalElement
	 * @generated
	 */
	EClass getLogicalElement();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entityrelation.LogicalElement#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.LogicalElement#getID()
	 * @see #getLogicalElement()
	 * @generated
	 */
	EAttribute getLogicalElement_ID();

	/**
	 * Returns the meta object for the attribute '{@link org.obeonetwork.dsl.entityrelation.LogicalElement#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comments</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.LogicalElement#getComments()
	 * @see #getLogicalElement()
	 * @generated
	 */
	EAttribute getLogicalElement_Comments();

	/**
	 * Returns the meta object for class '{@link org.obeonetwork.dsl.entityrelation.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Identifier
	 * @generated
	 */
	EClass getIdentifier();

	/**
	 * Returns the meta object for the reference list '{@link org.obeonetwork.dsl.entityrelation.Identifier#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attributes</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Identifier#getAttributes()
	 * @see #getIdentifier()
	 * @generated
	 */
	EReference getIdentifier_Attributes();

	/**
	 * Returns the meta object for enum '{@link org.obeonetwork.dsl.entityrelation.Cardinality <em>Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cardinality</em>'.
	 * @see org.obeonetwork.dsl.entityrelation.Cardinality
	 * @generated
	 */
	EEnum getCardinality();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EntityRelationFactory getEntityRelationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entityrelation.impl.LogicalModelImpl <em>Logical Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entityrelation.impl.LogicalModelImpl
		 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getLogicalModel()
		 * @generated
		 */
		EClass LOGICAL_MODEL = eINSTANCE.getLogicalModel();

		/**
		 * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGICAL_MODEL__ENTITIES = eINSTANCE.getLogicalModel_Entities();

		/**
		 * The meta object literal for the '<em><b>Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGICAL_MODEL__RELATIONS = eINSTANCE.getLogicalModel_Relations();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entityrelation.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entityrelation.impl.EntityImpl
		 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__ATTRIBUTES = eINSTANCE.getEntity_Attributes();

		/**
		 * The meta object literal for the '<em><b>Identifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__IDENTIFIERS = eINSTANCE.getEntity_Identifiers();

		/**
		 * The meta object literal for the '<em><b>Primary Identifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__PRIMARY_IDENTIFIER = eINSTANCE.getEntity_PrimaryIdentifier();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entityrelation.impl.RelationImpl <em>Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entityrelation.impl.RelationImpl
		 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getRelation()
		 * @generated
		 */
		EClass RELATION = eINSTANCE.getRelation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__SOURCE = eINSTANCE.getRelation_Source();

		/**
		 * The meta object literal for the '<em><b>Source Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__SOURCE_ROLE = eINSTANCE.getRelation_SourceRole();

		/**
		 * The meta object literal for the '<em><b>Source Cardinality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__SOURCE_CARDINALITY = eINSTANCE.getRelation_SourceCardinality();

		/**
		 * The meta object literal for the '<em><b>Source Is Composite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__SOURCE_IS_COMPOSITE = eINSTANCE.getRelation_SourceIsComposite();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__TARGET = eINSTANCE.getRelation_Target();

		/**
		 * The meta object literal for the '<em><b>Target Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__TARGET_ROLE = eINSTANCE.getRelation_TargetRole();

		/**
		 * The meta object literal for the '<em><b>Target Cardinality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__TARGET_CARDINALITY = eINSTANCE.getRelation_TargetCardinality();

		/**
		 * The meta object literal for the '<em><b>Target Is Composite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__TARGET_IS_COMPOSITE = eINSTANCE.getRelation_TargetIsComposite();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__ELEMENTS = eINSTANCE.getRelation_Elements();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__IDENTIFIER = eINSTANCE.getRelation_Identifier();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entityrelation.impl.RelationElementImpl <em>Relation Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entityrelation.impl.RelationElementImpl
		 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getRelationElement()
		 * @generated
		 */
		EClass RELATION_ELEMENT = eINSTANCE.getRelationElement();

		/**
		 * The meta object literal for the '<em><b>Source Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_ELEMENT__SOURCE_ATTRIBUTE = eINSTANCE.getRelationElement_SourceAttribute();

		/**
		 * The meta object literal for the '<em><b>Target Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_ELEMENT__TARGET_ATTRIBUTE = eINSTANCE.getRelationElement_TargetAttribute();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entityrelation.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entityrelation.impl.AttributeImpl
		 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__OWNER = eINSTANCE.getAttribute_Owner();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__REQUIRED = eINSTANCE.getAttribute_Required();

		/**
		 * The meta object literal for the '<em><b>Used In Identifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__USED_IN_IDENTIFIER = eINSTANCE.getAttribute_UsedInIdentifier();

		/**
		 * The meta object literal for the '<em><b>In Primary Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__IN_PRIMARY_IDENTIFIER = eINSTANCE.getAttribute_InPrimaryIdentifier();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entityrelation.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entityrelation.impl.NamedElementImpl
		 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entityrelation.impl.LogicalElementImpl <em>Logical Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entityrelation.impl.LogicalElementImpl
		 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getLogicalElement()
		 * @generated
		 */
		EClass LOGICAL_ELEMENT = eINSTANCE.getLogicalElement();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGICAL_ELEMENT__ID = eINSTANCE.getLogicalElement_ID();

		/**
		 * The meta object literal for the '<em><b>Comments</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGICAL_ELEMENT__COMMENTS = eINSTANCE.getLogicalElement_Comments();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entityrelation.impl.IdentifierImpl <em>Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entityrelation.impl.IdentifierImpl
		 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getIdentifier()
		 * @generated
		 */
		EClass IDENTIFIER = eINSTANCE.getIdentifier();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIER__ATTRIBUTES = eINSTANCE.getIdentifier_Attributes();

		/**
		 * The meta object literal for the '{@link org.obeonetwork.dsl.entityrelation.Cardinality <em>Cardinality</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.obeonetwork.dsl.entityrelation.Cardinality
		 * @see org.obeonetwork.dsl.entityrelation.impl.EntityRelationPackageImpl#getCardinality()
		 * @generated
		 */
		EEnum CARDINALITY = eINSTANCE.getCardinality();

	}

} //EntityRelationPackage
