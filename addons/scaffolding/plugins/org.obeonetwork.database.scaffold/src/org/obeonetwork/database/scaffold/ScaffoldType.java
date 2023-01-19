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
package org.obeonetwork.database.scaffold;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.obeonetwork.database.scaffold.ScaffoldPackage#getScaffoldType()
 * @model
 * @generated
 */
public enum ScaffoldType implements Enumerator {
	/**
	 * The '<em><b>Entity To Mld</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENTITY_TO_MLD_VALUE
	 * @generated
	 * @ordered
	 */
	ENTITY_TO_MLD(0, "EntityToMld", "0"),

	/**
	 * The '<em><b>Mld To Entity</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MLD_TO_ENTITY_VALUE
	 * @generated
	 * @ordered
	 */
	MLD_TO_ENTITY(1, "MldToEntity", "1"),

	/**
	 * The '<em><b>Mpd To Mld</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MPD_TO_MLD_VALUE
	 * @generated
	 * @ordered
	 */
	MPD_TO_MLD(2, "MpdToMld", "2"),

	/**
	 * The '<em><b>Mld To Mpd</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MLD_TO_MPD_VALUE
	 * @generated
	 * @ordered
	 */
	MLD_TO_MPD(3, "MldToMpd", "3");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2023 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The '<em><b>Entity To Mld</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Entity To Mld</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENTITY_TO_MLD
	 * @model name="EntityToMld" literal="0"
	 * @generated
	 * @ordered
	 */
	public static final int ENTITY_TO_MLD_VALUE = 0;

	/**
	 * The '<em><b>Mld To Entity</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mld To Entity</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MLD_TO_ENTITY
	 * @model name="MldToEntity" literal="1"
	 * @generated
	 * @ordered
	 */
	public static final int MLD_TO_ENTITY_VALUE = 1;

	/**
	 * The '<em><b>Mpd To Mld</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mpd To Mld</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MPD_TO_MLD
	 * @model name="MpdToMld" literal="2"
	 * @generated
	 * @ordered
	 */
	public static final int MPD_TO_MLD_VALUE = 2;

	/**
	 * The '<em><b>Mld To Mpd</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mld To Mpd</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MLD_TO_MPD
	 * @model name="MldToMpd" literal="3"
	 * @generated
	 * @ordered
	 */
	public static final int MLD_TO_MPD_VALUE = 3;

	/**
	 * An array of all the '<em><b>Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ScaffoldType[] VALUES_ARRAY =
		new ScaffoldType[] {
			ENTITY_TO_MLD,
			MLD_TO_ENTITY,
			MPD_TO_MLD,
			MLD_TO_MPD,
		};

	/**
	 * A public read-only list of all the '<em><b>Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ScaffoldType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ScaffoldType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ScaffoldType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ScaffoldType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ScaffoldType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ScaffoldType get(int value) {
		switch (value) {
			case ENTITY_TO_MLD_VALUE: return ENTITY_TO_MLD;
			case MLD_TO_ENTITY_VALUE: return MLD_TO_ENTITY;
			case MPD_TO_MLD_VALUE: return MPD_TO_MLD;
			case MLD_TO_MPD_VALUE: return MLD_TO_MPD;
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
	private ScaffoldType(int value, String name, String literal) {
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
	
	public ScaffoldType getOppositeScaffoldType() {
		switch(this) {
		case ENTITY_TO_MLD :
				return MLD_TO_ENTITY;
		case MLD_TO_ENTITY :
			return ENTITY_TO_MLD;
		case MLD_TO_MPD :
			return MPD_TO_MLD;
		case MPD_TO_MLD :
			return MLD_TO_MPD;
		}
		return null;
	}
	
} //ScaffoldType
