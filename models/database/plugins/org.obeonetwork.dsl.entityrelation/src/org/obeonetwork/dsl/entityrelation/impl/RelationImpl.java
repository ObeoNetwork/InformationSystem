/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.entityrelation.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.entityrelation.Cardinality;
import org.obeonetwork.dsl.entityrelation.Entity;
import org.obeonetwork.dsl.entityrelation.EntityRelationPackage;
import org.obeonetwork.dsl.entityrelation.Identifier;
import org.obeonetwork.dsl.entityrelation.Relation;
import org.obeonetwork.dsl.entityrelation.RelationElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.RelationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.RelationImpl#getSourceRole <em>Source Role</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.RelationImpl#getSourceCardinality <em>Source Cardinality</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.RelationImpl#isSourceIsComposite <em>Source Is Composite</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.RelationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.RelationImpl#getTargetRole <em>Target Role</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.RelationImpl#getTargetCardinality <em>Target Cardinality</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.RelationImpl#isTargetIsComposite <em>Target Is Composite</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.RelationImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.entityrelation.impl.RelationImpl#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationImpl extends NamedElementImpl implements Relation {
	/**
	 * The default value of the '{@link #getSourceRole() <em>Source Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceRole()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_ROLE_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getSourceCardinality() <em>Source Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceCardinality()
	 * @generated
	 * @ordered
	 */
	protected static final Cardinality SOURCE_CARDINALITY_EDEFAULT = Cardinality.ZERO_STAR;
	/**
	 * The default value of the '{@link #isSourceIsComposite() <em>Source Is Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSourceIsComposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SOURCE_IS_COMPOSITE_EDEFAULT = false;
	/**
	 * The default value of the '{@link #getTargetRole() <em>Target Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetRole()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_ROLE_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getTargetCardinality() <em>Target Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetCardinality()
	 * @generated
	 * @ordered
	 */
	protected static final Cardinality TARGET_CARDINALITY_EDEFAULT = Cardinality.ZERO_ONE;
	/**
	 * The default value of the '{@link #isTargetIsComposite() <em>Target Is Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTargetIsComposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TARGET_IS_COMPOSITE_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntityRelationPackage.Literals.RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getSource() {
		return (Entity)eDynamicGet(EntityRelationPackage.RELATION__SOURCE, EntityRelationPackage.Literals.RELATION__SOURCE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetSource() {
		return (Entity)eDynamicGet(EntityRelationPackage.RELATION__SOURCE, EntityRelationPackage.Literals.RELATION__SOURCE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Entity newSource) {
		eDynamicSet(EntityRelationPackage.RELATION__SOURCE, EntityRelationPackage.Literals.RELATION__SOURCE, newSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceRole() {
		return (String)eDynamicGet(EntityRelationPackage.RELATION__SOURCE_ROLE, EntityRelationPackage.Literals.RELATION__SOURCE_ROLE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceRole(String newSourceRole) {
		eDynamicSet(EntityRelationPackage.RELATION__SOURCE_ROLE, EntityRelationPackage.Literals.RELATION__SOURCE_ROLE, newSourceRole);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Cardinality getSourceCardinality() {
		return (Cardinality)eDynamicGet(EntityRelationPackage.RELATION__SOURCE_CARDINALITY, EntityRelationPackage.Literals.RELATION__SOURCE_CARDINALITY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceCardinality(Cardinality newSourceCardinality) {
		eDynamicSet(EntityRelationPackage.RELATION__SOURCE_CARDINALITY, EntityRelationPackage.Literals.RELATION__SOURCE_CARDINALITY, newSourceCardinality);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSourceIsComposite() {
		return (Boolean)eDynamicGet(EntityRelationPackage.RELATION__SOURCE_IS_COMPOSITE, EntityRelationPackage.Literals.RELATION__SOURCE_IS_COMPOSITE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceIsComposite(boolean newSourceIsComposite) {
		eDynamicSet(EntityRelationPackage.RELATION__SOURCE_IS_COMPOSITE, EntityRelationPackage.Literals.RELATION__SOURCE_IS_COMPOSITE, newSourceIsComposite);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getTarget() {
		return (Entity)eDynamicGet(EntityRelationPackage.RELATION__TARGET, EntityRelationPackage.Literals.RELATION__TARGET, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetTarget() {
		return (Entity)eDynamicGet(EntityRelationPackage.RELATION__TARGET, EntityRelationPackage.Literals.RELATION__TARGET, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Entity newTarget) {
		eDynamicSet(EntityRelationPackage.RELATION__TARGET, EntityRelationPackage.Literals.RELATION__TARGET, newTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetRole() {
		return (String)eDynamicGet(EntityRelationPackage.RELATION__TARGET_ROLE, EntityRelationPackage.Literals.RELATION__TARGET_ROLE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetRole(String newTargetRole) {
		eDynamicSet(EntityRelationPackage.RELATION__TARGET_ROLE, EntityRelationPackage.Literals.RELATION__TARGET_ROLE, newTargetRole);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Cardinality getTargetCardinality() {
		return (Cardinality)eDynamicGet(EntityRelationPackage.RELATION__TARGET_CARDINALITY, EntityRelationPackage.Literals.RELATION__TARGET_CARDINALITY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetCardinality(Cardinality newTargetCardinality) {
		eDynamicSet(EntityRelationPackage.RELATION__TARGET_CARDINALITY, EntityRelationPackage.Literals.RELATION__TARGET_CARDINALITY, newTargetCardinality);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTargetIsComposite() {
		return (Boolean)eDynamicGet(EntityRelationPackage.RELATION__TARGET_IS_COMPOSITE, EntityRelationPackage.Literals.RELATION__TARGET_IS_COMPOSITE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetIsComposite(boolean newTargetIsComposite) {
		eDynamicSet(EntityRelationPackage.RELATION__TARGET_IS_COMPOSITE, EntityRelationPackage.Literals.RELATION__TARGET_IS_COMPOSITE, newTargetIsComposite);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<RelationElement> getElements() {
		return (EList<RelationElement>)eDynamicGet(EntityRelationPackage.RELATION__ELEMENTS, EntityRelationPackage.Literals.RELATION__ELEMENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getIdentifier() {
		return (Identifier)eDynamicGet(EntityRelationPackage.RELATION__IDENTIFIER, EntityRelationPackage.Literals.RELATION__IDENTIFIER, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier basicGetIdentifier() {
		return (Identifier)eDynamicGet(EntityRelationPackage.RELATION__IDENTIFIER, EntityRelationPackage.Literals.RELATION__IDENTIFIER, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(Identifier newIdentifier) {
		eDynamicSet(EntityRelationPackage.RELATION__IDENTIFIER, EntityRelationPackage.Literals.RELATION__IDENTIFIER, newIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EntityRelationPackage.RELATION__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
			case EntityRelationPackage.RELATION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case EntityRelationPackage.RELATION__SOURCE_ROLE:
				return getSourceRole();
			case EntityRelationPackage.RELATION__SOURCE_CARDINALITY:
				return getSourceCardinality();
			case EntityRelationPackage.RELATION__SOURCE_IS_COMPOSITE:
				return isSourceIsComposite();
			case EntityRelationPackage.RELATION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case EntityRelationPackage.RELATION__TARGET_ROLE:
				return getTargetRole();
			case EntityRelationPackage.RELATION__TARGET_CARDINALITY:
				return getTargetCardinality();
			case EntityRelationPackage.RELATION__TARGET_IS_COMPOSITE:
				return isTargetIsComposite();
			case EntityRelationPackage.RELATION__ELEMENTS:
				return getElements();
			case EntityRelationPackage.RELATION__IDENTIFIER:
				if (resolve) return getIdentifier();
				return basicGetIdentifier();
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
			case EntityRelationPackage.RELATION__SOURCE:
				setSource((Entity)newValue);
				return;
			case EntityRelationPackage.RELATION__SOURCE_ROLE:
				setSourceRole((String)newValue);
				return;
			case EntityRelationPackage.RELATION__SOURCE_CARDINALITY:
				setSourceCardinality((Cardinality)newValue);
				return;
			case EntityRelationPackage.RELATION__SOURCE_IS_COMPOSITE:
				setSourceIsComposite((Boolean)newValue);
				return;
			case EntityRelationPackage.RELATION__TARGET:
				setTarget((Entity)newValue);
				return;
			case EntityRelationPackage.RELATION__TARGET_ROLE:
				setTargetRole((String)newValue);
				return;
			case EntityRelationPackage.RELATION__TARGET_CARDINALITY:
				setTargetCardinality((Cardinality)newValue);
				return;
			case EntityRelationPackage.RELATION__TARGET_IS_COMPOSITE:
				setTargetIsComposite((Boolean)newValue);
				return;
			case EntityRelationPackage.RELATION__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends RelationElement>)newValue);
				return;
			case EntityRelationPackage.RELATION__IDENTIFIER:
				setIdentifier((Identifier)newValue);
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
			case EntityRelationPackage.RELATION__SOURCE:
				setSource((Entity)null);
				return;
			case EntityRelationPackage.RELATION__SOURCE_ROLE:
				setSourceRole(SOURCE_ROLE_EDEFAULT);
				return;
			case EntityRelationPackage.RELATION__SOURCE_CARDINALITY:
				setSourceCardinality(SOURCE_CARDINALITY_EDEFAULT);
				return;
			case EntityRelationPackage.RELATION__SOURCE_IS_COMPOSITE:
				setSourceIsComposite(SOURCE_IS_COMPOSITE_EDEFAULT);
				return;
			case EntityRelationPackage.RELATION__TARGET:
				setTarget((Entity)null);
				return;
			case EntityRelationPackage.RELATION__TARGET_ROLE:
				setTargetRole(TARGET_ROLE_EDEFAULT);
				return;
			case EntityRelationPackage.RELATION__TARGET_CARDINALITY:
				setTargetCardinality(TARGET_CARDINALITY_EDEFAULT);
				return;
			case EntityRelationPackage.RELATION__TARGET_IS_COMPOSITE:
				setTargetIsComposite(TARGET_IS_COMPOSITE_EDEFAULT);
				return;
			case EntityRelationPackage.RELATION__ELEMENTS:
				getElements().clear();
				return;
			case EntityRelationPackage.RELATION__IDENTIFIER:
				setIdentifier((Identifier)null);
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
			case EntityRelationPackage.RELATION__SOURCE:
				return basicGetSource() != null;
			case EntityRelationPackage.RELATION__SOURCE_ROLE:
				return SOURCE_ROLE_EDEFAULT == null ? getSourceRole() != null : !SOURCE_ROLE_EDEFAULT.equals(getSourceRole());
			case EntityRelationPackage.RELATION__SOURCE_CARDINALITY:
				return getSourceCardinality() != SOURCE_CARDINALITY_EDEFAULT;
			case EntityRelationPackage.RELATION__SOURCE_IS_COMPOSITE:
				return isSourceIsComposite() != SOURCE_IS_COMPOSITE_EDEFAULT;
			case EntityRelationPackage.RELATION__TARGET:
				return basicGetTarget() != null;
			case EntityRelationPackage.RELATION__TARGET_ROLE:
				return TARGET_ROLE_EDEFAULT == null ? getTargetRole() != null : !TARGET_ROLE_EDEFAULT.equals(getTargetRole());
			case EntityRelationPackage.RELATION__TARGET_CARDINALITY:
				return getTargetCardinality() != TARGET_CARDINALITY_EDEFAULT;
			case EntityRelationPackage.RELATION__TARGET_IS_COMPOSITE:
				return isTargetIsComposite() != TARGET_IS_COMPOSITE_EDEFAULT;
			case EntityRelationPackage.RELATION__ELEMENTS:
				return !getElements().isEmpty();
			case EntityRelationPackage.RELATION__IDENTIFIER:
				return basicGetIdentifier() != null;
		}
		return super.eIsSet(featureID);
	}

} //RelationImpl
