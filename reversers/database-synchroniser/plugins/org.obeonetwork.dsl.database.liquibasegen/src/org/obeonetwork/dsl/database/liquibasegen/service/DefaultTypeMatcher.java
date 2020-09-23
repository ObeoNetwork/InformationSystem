/*******************************************************************************
 * Copyright (c) 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.liquibasegen.service;

import static org.obeonetwork.dsl.database.gen.common.services.StatusUtils.createErrorStatus;

import java.text.MessageFormat;
import java.text.ParseException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.obeonetwork.dsl.database.gen.common.services.StatusUtils;
import org.obeonetwork.dsl.typeslibrary.NativeType;

import liquibase.util.ISODateFormat;

/**
 * Helper class used to handle column type and default value for the liquibase
 * generation
 *
 */
public class DefaultTypeMatcher {

	private static final String FALSE_NUM = "0";
	private static final String TRUE_NUM = "1";
	private static final String FALSE = "false";
	private static final String TRUE = "true";
	private static final String BINARY_FORMAT = "Binary";
	private static final String BOOLEAN_FORMAT = "Booleen";
	private static final String DATE_FORMAT = "Date";
	private static final String DECIMAL_FORAMT = "Décimal";
	private static final String INT_FORMAT = "Entier";
	private static final String LONG_FORMAT = "Entier long";
	private static final String FLOAT_FORMAT = "Réel";
	private static final String STRING_FORMAT = "Texte";
	private static final String TIME_FORMAT = "Time";
	private static final String TIMESTAMPFORMAT = "Timestamp";

	public enum LiquibaseDefaultType {

		/**
		 * Returned if the given type has an unknown data type
		 */
		UNKWOWN,
		/**
		 * Return if the model is not complete enough to guess the matching types
		 */
		INVALID,
		/**
		 * Returned for data type that can set default value in liquibase
		 */
		UNHANDLED, BOOLEAN, STRING, DATE, NUM

	}

	/**
	 * Gets the matching {@link LiquibaseDefaultType} for the given
	 * {@link NativeType}
	 * 
	 * @param nativeType a {@link NativeType}
	 * @return a {@link LiquibaseDefaultType}
	 */
	public static LiquibaseDefaultType getLiquibaseDefaultType(NativeType nativeType) {
		if (nativeType != null) {
			NativeType mdlType = nativeType.getMapsTo();
			if (mdlType != null) {
				switch (mdlType.getName()) {
				case BOOLEAN_FORMAT:
					return LiquibaseDefaultType.BOOLEAN;
				case DECIMAL_FORAMT:
				case INT_FORMAT:
				case FLOAT_FORMAT:
				case LONG_FORMAT:
					return LiquibaseDefaultType.NUM;
				case TIME_FORMAT:
				case DATE_FORMAT:
					return LiquibaseDefaultType.DATE;
				case STRING_FORMAT:
					return LiquibaseDefaultType.STRING;
				case BINARY_FORMAT:
				case TIMESTAMPFORMAT:
					return LiquibaseDefaultType.UNHANDLED;
				default:
					return LiquibaseDefaultType.UNKWOWN;
				}
			}
		}
		return LiquibaseDefaultType.INVALID;
	}

	/**
	 * Validate the given value for the matching data type
	 * 
	 * @param type  a {@link LiquibaseDefaultType}
	 * @param value the default value
	 * @return an {@link Status#OK_STATUS} if ok, a status with a message otherwise
	 */
	public static IStatus validateValue(LiquibaseDefaultType type, String value) {
		if (type == null) {
			return Status.OK_STATUS;
		}
		switch (type) {
		case DATE:
			return validateDateDefaultValue(value);
		case BOOLEAN:
			return validateProcessBoolean(value);
		default:
			return Status.OK_STATUS;
		}
	}

	/**
	 * Pre process the default value to it can be used by the Liquibase API
	 * 
	 * @param type  the Liquibase type
	 * @param value the input value
	 * @return a transformed (or not) value
	 */
	public static String preProcessDefaultValue(LiquibaseDefaultType type, String value) {
		if (type == null) {
			return value;
		}
		switch (type) {
		case STRING:
			return preProcessString(value);
		case BOOLEAN:
			return preProcessBoolean(value);
		default:
			return value;
		}
	}

	private static String preProcessBoolean(String defaultValueBoolean) {
		if (TRUE.equalsIgnoreCase(defaultValueBoolean) || TRUE_NUM.equals(defaultValueBoolean)) {
			return Boolean.TRUE.toString();
		} else if (FALSE.equalsIgnoreCase(defaultValueBoolean) || FALSE_NUM.equals(defaultValueBoolean)) {
			return Boolean.TRUE.toString();
		} else {
			return defaultValueBoolean;
		}

	}

	private static IStatus validateProcessBoolean(String defaultValueBoolean) {
		if (TRUE.equalsIgnoreCase(defaultValueBoolean) || TRUE_NUM.equals(defaultValueBoolean) //
				|| FALSE.equalsIgnoreCase(defaultValueBoolean) || FALSE_NUM.equals(defaultValueBoolean)) {
			return Status.OK_STATUS;
		} else {
			return StatusUtils.createWarningStatus(MessageFormat.format(
					"Default value for boolean can only be: {0},{1},{2} or {3}", TRUE, TRUE_NUM, FALSE, FALSE_NUM));
		}
	}

	private static String preProcessString(String value) {
		String trimmedValue = value.trim();
		if (trimmedValue.length() < 2) {
			return trimmedValue;
		}
		if (trimmedValue.charAt(0) == '\'' && trimmedValue.charAt(trimmedValue.length() - 1) == '\'') {
			return trimmedValue.substring(1, trimmedValue.length() - 1);
		}
		return trimmedValue;
	}

	private static IStatus validateDateDefaultValue(String value) {
		try {
			new ISODateFormat().parse(value);
			return Status.OK_STATUS;
		} catch (ParseException e) {
			return createErrorStatus("Unable to use " + value + " has default date. Expecting ISO Date", e);
		}
	}

}
