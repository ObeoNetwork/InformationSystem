/*******************************************************************************
 *  Copyright (c) 2016 Obeo. 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *   
 *   Contributors:
 *       Obeo - initial API and implementation
 *  
 *******************************************************************************/
package org.obeonetwork.database.m2doc.services;

import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.typeslibrary.Type;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.UserDefinedTypeRef;

/**
 * Column's AQL services for M2Doc.
 * 
 * @author Romain Guider
 */
public class ColumnServices {

    /**
     * The number of records.
     */
    private static final int NUMBER_OF_RECORD = 5000;

    /**
     * Returns the string "Oui" when the parameter is </code>true<code> and "Non" otherwise.
     * 
     * @param b
     * @return a yes/no string representation of the parameter.
     */
    private String yesNo(boolean b) {
        return b ? "Oui" : "Non";
    }

    /**
     * Returns the "Oui" string if the column is automatically incremented and "No" otherwise.
     * 
     * @param column
     * @return "Oui" or "Non" depending on whether the column is automatically incremented or not.
     */
    public String isAutoincrement(Column column) {
        if (column != null) {
            return yesNo(column.isAutoincrement());
        } else {
            return "No";
        }
    }

    /**
     * Returns "X" when the column is autoincrement and "" if the column is not unique or is <code>null</code>
     * 
     * @param column
     * @return
     */
    public String checkAutoincrement(Column column) {
        if (column != null) {
            return column.isAutoincrement() ? "X" : "";
        } else {
            return "";
        }
    }

    /**
     * Returns the "Oui" string if the column is in a primary key and "No" otherwise.
     * 
     * @param column
     * @return "Oui" or "Non" depending on whether the column is in a primary key or not.
     */
    public String isInPrimaryKey(Column column) {
        if (column != null) {
            return yesNo(column.isInPrimaryKey());
        } else {
            return "No";
        }
    }

    /**
     * Returns the "Oui" string if the column is in a foreign key and "No" otherwise.
     * 
     * @param column
     * @return "Oui" or "Non" depending on whether the column is in a foreign key or not.
     */
    public String isInForeignKey(Column column) {
        if (column != null) {
            return yesNo(column.isInForeignKey());
        } else {
            return "No";
        }
    }

    /**
     * Returns the "Oui" string if the column is unique and "No" otherwise.
     * 
     * @param column
     * @return "Oui" or "Non" depending on whether the column is unique or not.
     */
    public String isUnic(Column column) {
        if (column != null) {
            return yesNo(column.isUnique());
        } else {
            return "No";
        }
    }

    /**
     * Returns "X" when the column is nullable and "" if the column is not nullable or is <code>null</code>
     * 
     * @param column
     * @return "X" if the column is nullable and "" in any other case.
     */
    public String checkNullable(Column column) {
        if (column != null) {
            return column.isNullable() ? "X" : "";
        } else {
            return "";
        }
    }

    /**
     * Returns "Yes" when the column is nullable and "No" otherwise or if it is <code>null</code>.
     * 
     * @param column
     * @return "Oui" or "Non" depending on whether the column is nullable or not.
     */
    public String isNullable(Column column) {
        if (column != null) {
            return yesNo(column.isNullable());
        } else {
            return "No";
        }
    }

    /**
     * Returns "X" when the column is mandatory and "" if the column is not mandatory or is <code>null</code>
     * 
     * @param column
     * @return "X" if the column is mandatory and "" in any other case.
     */
    public String checkMandatory(Column column) {
        if (column != null) {
            return column.isNullable() ? "" : "X";
        } else {
            return "";
        }
    }

    /**
     * Returns "Yes" when the column is nullable and "No" otherwise or if it is <code>null</code>.
     * 
     * @param column
     * @return "Oui" or "Non" depending on whether the column is mandatory or not.
     */
    public String isMandatory(Column column) {
        if (column != null) {
            return yesNo(!column.isNullable());
        } else {
            return "No";
        }
    }

    /**
     * Returns "X" when the column is in a foreign key and "" otherwise or if the column is <code>null</code/
     * 
     * @param column
     * @return "X" if the column is in a foreign key and "" in any other case.
     */
    public String checkInForeignKey(Column column) {
        if (column != null) {
            return column.isInForeignKey() ? "X" : "";
        } else {
            return "";
        }
    }

    /**
     * Returns "X" when the column is unique and "" if the column is not unique or is <code>null</code/
     * 
     * @param column
     * @return "X" if the column is unique and "" in any other case.
     */
    public String checkUnique(Column column) {
        if (column != null) {
            return column.isUnique() ? "X" : "";
        } else {
            return "";
        }
    }

    /**
     * Returns "X" when the column is in a primary key and "" otherwise or if the column is <code>null</code/
     * 
     * @param column
     * @return "X" if the column is in a primary key and "" in any other case.
     */
    public String checkInPrimaryKey(Column col) {
        if (col != null) {
            return col.isInPrimaryKey() ? "X" : "";
        } else {
            return "";
        }
    }

    /**
     * Returns the name of the column's type.
     * 
     * @param column
     * @return the name of the column's type.
     */
    public String typeName(Column column) {
        final String res;
        Type type = column.getType();
        if (type instanceof UserDefinedTypeRef) {
            res = ((UserDefinedTypeRef) type).getType().getName();
        } else if (type instanceof TypeInstance) {
            res = ((TypeInstance) type).getNativeType().getName();
        } else {
            res = "no name found";
        }

        return res;
    }

    /**
     * Returns the length and the precision of the type associated to the column.
     * Result is like follows :
     * <ul>
     * <li>&lt;length&gt; if the type has the NativeKind.LENGTH attribute</li>
     * <li>&lt;length,precision&gt; if the type has the NativeKind.LENGTH_AND_PRECISION attribute</li>
     * 
     * @param col
     *            the column
     * @return a description of the length of the column's type.
     */
    public String typeLength(Column col) {
        final String res;
        Type type = col.getType();
        if (type instanceof TypeInstance) {
            TypeInstance instance = (TypeInstance) type;
            switch (instance.getNativeType().getSpec()) {
                case LENGTH:
                    res = instance.getLength().toString();
                    break;
                case LENGTH_AND_PRECISION:
                    res = instance.getLength() + "," + instance.getPrecision();
                    break;
                default:
                    res = "";
            }
        } else {
            res = "";
        }
        return res;
    }

    /**
     * Returns the default value of the column if one is specified and the empty string otherwise.
     * 
     * @param col
     *            the column
     * @return the default value
     */
    public String defaultValue(Column col) {
        if (col.getDefaultValue() != null) {
            return col.getDefaultValue();
        } else {
            return "";
        }
    }
}
