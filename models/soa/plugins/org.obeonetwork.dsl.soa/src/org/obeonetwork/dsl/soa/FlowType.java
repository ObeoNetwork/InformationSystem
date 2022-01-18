/**
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.soa;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Flow Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.soa.SoaPackage#getFlowType()
 * @model
 * @generated
 */
public enum FlowType implements Enumerator {
	/**
	 * The '<em><b>IMPLICIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMPLICIT_VALUE
	 * @generated
	 * @ordered
	 */
	IMPLICIT(0, "IMPLICIT", "IMPLICIT"),

	/**
	 * The '<em><b>PASSWORD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PASSWORD_VALUE
	 * @generated
	 * @ordered
	 */
	PASSWORD(1, "PASSWORD", "PASSWORD"),

	/**
	 * The '<em><b>CREDENTIALS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREDENTIALS_VALUE
	 * @generated
	 * @ordered
	 */
	CREDENTIALS(2, "CREDENTIALS", "CREDENTIALS"),

	/**
	 * The '<em><b>AUTHORIZATIONCODE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTHORIZATIONCODE_VALUE
	 * @generated
	 * @ordered
	 */
	AUTHORIZATIONCODE(3, "AUTHORIZATIONCODE", "AUTHORIZATIONCODE");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2022 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The '<em><b>IMPLICIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMPLICIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IMPLICIT_VALUE = 0;

	/**
	 * The '<em><b>PASSWORD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PASSWORD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PASSWORD_VALUE = 1;

	/**
	 * The '<em><b>CREDENTIALS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREDENTIALS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CREDENTIALS_VALUE = 2;

	/**
	 * The '<em><b>AUTHORIZATIONCODE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTHORIZATIONCODE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AUTHORIZATIONCODE_VALUE = 3;

	/**
	 * An array of all the '<em><b>Flow Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FlowType[] VALUES_ARRAY =
		new FlowType[] {
			IMPLICIT,
			PASSWORD,
			CREDENTIALS,
			AUTHORIZATIONCODE,
		};

	/**
	 * A public read-only list of all the '<em><b>Flow Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FlowType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Flow Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FlowType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FlowType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Flow Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FlowType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FlowType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Flow Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FlowType get(int value) {
		switch (value) {
			case IMPLICIT_VALUE: return IMPLICIT;
			case PASSWORD_VALUE: return PASSWORD;
			case CREDENTIALS_VALUE: return CREDENTIALS;
			case AUTHORIZATIONCODE_VALUE: return AUTHORIZATIONCODE;
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
	private FlowType(int value, String name, String literal) {
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
	
} //FlowType
