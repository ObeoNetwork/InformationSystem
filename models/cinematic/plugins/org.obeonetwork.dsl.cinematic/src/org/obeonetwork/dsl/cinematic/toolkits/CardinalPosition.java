/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.cinematic.toolkits;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Cardinal Position</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.cinematic.toolkits.ToolkitsPackage#getCardinalPosition()
 * @model
 * @generated
 */
public enum CardinalPosition implements Enumerator {
	/**
	 * The '<em><b>WEST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEST_VALUE
	 * @generated
	 * @ordered
	 */
	WEST(1, "WEST", "WEST"),

	/**
	 * The '<em><b>EAST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EAST_VALUE
	 * @generated
	 * @ordered
	 */
	EAST(3, "EAST", "EAST"),

	/**
	 * The '<em><b>NORTH WEST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NORTH_WEST_VALUE
	 * @generated
	 * @ordered
	 */
	NORTH_WEST(4, "NORTH_WEST", "NORTH_WEST"),

	/**
	 * The '<em><b>NORTH EAST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NORTH_EAST_VALUE
	 * @generated
	 * @ordered
	 */
	NORTH_EAST(5, "NORTH_EAST", "NORTH_EAST");

	/**
	 * The '<em><b>WEST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WEST_VALUE = 1;

	/**
	 * The '<em><b>EAST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EAST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EAST_VALUE = 3;

	/**
	 * The '<em><b>NORTH WEST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NORTH_WEST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NORTH_WEST_VALUE = 4;

	/**
	 * The '<em><b>NORTH EAST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NORTH_EAST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NORTH_EAST_VALUE = 5;

	/**
	 * An array of all the '<em><b>Cardinal Position</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CardinalPosition[] VALUES_ARRAY =
		new CardinalPosition[] {
			WEST,
			EAST,
			NORTH_WEST,
			NORTH_EAST,
		};

	/**
	 * A public read-only list of all the '<em><b>Cardinal Position</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CardinalPosition> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Cardinal Position</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CardinalPosition get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CardinalPosition result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Cardinal Position</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CardinalPosition getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CardinalPosition result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Cardinal Position</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CardinalPosition get(int value) {
		switch (value) {
			case WEST_VALUE: return WEST;
			case EAST_VALUE: return EAST;
			case NORTH_WEST_VALUE: return NORTH_WEST;
			case NORTH_EAST_VALUE: return NORTH_EAST;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CardinalPosition(int value, String name, String literal) {
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
	
} //CardinalPosition
