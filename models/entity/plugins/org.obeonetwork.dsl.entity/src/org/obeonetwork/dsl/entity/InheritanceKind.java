/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Inheritance Kind</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.entity.EntityPackage#getInheritanceKind()
 * @model
 * @generated
 */
public enum InheritanceKind implements Enumerator
{
	/**
	 * The '<em><b>TABLE PER SUBCLASS</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #TABLE_PER_SUBCLASS
	 * @generated
	 * @ordered
	 */
	TABLE_PER_SUBCLASS_LITERAL(0, "TABLE_PER_SUBCLASS", "TABLE_PER_SUBCLASS"),
	/**
	 * The '<em><b>TABLE PER CLASS HIERARCHY</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #TABLE_PER_CLASS_HIERARCHY
	 * @generated
	 * @ordered
	 */
	TABLE_PER_CLASS_HIERARCHY_LITERAL(1, "TABLE_PER_CLASS_HIERARCHY", "TABLE_PER_CLASS_HIERARCHY");
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2017 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The '<em><b>TABLE PER SUBCLASS</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TABLE PER SUBCLASS</b></em>' literal
	 * object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #TABLE_PER_SUBCLASS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TABLE_PER_SUBCLASS = 0;

	/**
	 * The '<em><b>TABLE PER CLASS HIERARCHY</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TABLE PER CLASS HIERARCHY</b></em>'
	 * literal object isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #TABLE_PER_CLASS_HIERARCHY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TABLE_PER_CLASS_HIERARCHY = 1;

	/**
	 * An array of all the '<em><b>Inheritance Kind</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final InheritanceKind[] VALUES_ARRAY =
		new InheritanceKind[] {
			TABLE_PER_SUBCLASS_LITERAL,
			TABLE_PER_CLASS_HIERARCHY_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Inheritance Kind</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<InheritanceKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Inheritance Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static InheritanceKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			InheritanceKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Inheritance Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static InheritanceKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			InheritanceKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Inheritance Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static InheritanceKind get(int value) {
		switch (value) {
			case TABLE_PER_SUBCLASS: return TABLE_PER_SUBCLASS_LITERAL;
			case TABLE_PER_CLASS_HIERARCHY: return TABLE_PER_CLASS_HIERARCHY_LITERAL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	private InheritanceKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
}
