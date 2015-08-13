/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.soa;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Binding Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.dsl.soa.SoaPackage#getBindingKind()
 * @model
 * @generated
 */
public enum BindingKind implements Enumerator
{
	/**
	 * The '<em><b>Webservice</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEBSERVICE
	 * @generated
	 * @ordered
	 */
	WEBSERVICE_LITERAL(0, "webservice", "webservice"),
	/**
	 * The '<em><b>Rmi</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RMI
	 * @generated
	 * @ordered
	 */
	RMI_LITERAL(1, "rmi", "rmi"),
	/**
	 * The '<em><b>Corba</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CORBA
	 * @generated
	 * @ordered
	 */
	CORBA_LITERAL(2, "corba", "corba"),
	/**
	 * The '<em><b>Ejb</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EJB
	 * @generated
	 * @ordered
	 */
	EJB_LITERAL(3, "ejb", "ejb"),
	/**
	 * The '<em><b>Java</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JAVA
	 * @generated
	 * @ordered
	 */
	JAVA_LITERAL(4, "java", "java");
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * The '<em><b>Webservice</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Webservice</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WEBSERVICE_LITERAL
	 * @model name="webservice"
	 * @generated
	 * @ordered
	 */
	public static final int WEBSERVICE = 0;

	/**
	 * The '<em><b>Rmi</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Rmi</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RMI_LITERAL
	 * @model name="rmi"
	 * @generated
	 * @ordered
	 */
	public static final int RMI = 1;

	/**
	 * The '<em><b>Corba</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Corba</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CORBA_LITERAL
	 * @model name="corba"
	 * @generated
	 * @ordered
	 */
	public static final int CORBA = 2;

	/**
	 * The '<em><b>Ejb</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ejb</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EJB_LITERAL
	 * @model name="ejb"
	 * @generated
	 * @ordered
	 */
	public static final int EJB = 3;

	/**
	 * The '<em><b>Java</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Java</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JAVA_LITERAL
	 * @model name="java"
	 * @generated
	 * @ordered
	 */
	public static final int JAVA = 4;

	/**
	 * An array of all the '<em><b>Binding Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final BindingKind[] VALUES_ARRAY =
		new BindingKind[] {
			WEBSERVICE_LITERAL,
			RMI_LITERAL,
			CORBA_LITERAL,
			EJB_LITERAL,
			JAVA_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Binding Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<BindingKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Binding Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BindingKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BindingKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Binding Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BindingKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BindingKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Binding Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BindingKind get(int value) {
		switch (value) {
			case WEBSERVICE: return WEBSERVICE_LITERAL;
			case RMI: return RMI_LITERAL;
			case CORBA: return CORBA_LITERAL;
			case EJB: return EJB_LITERAL;
			case JAVA: return JAVA_LITERAL;
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
	private BindingKind(int value, String name, String literal) {
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
