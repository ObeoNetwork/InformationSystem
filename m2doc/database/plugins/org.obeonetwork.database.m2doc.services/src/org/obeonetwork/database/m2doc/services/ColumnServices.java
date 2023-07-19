/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.database.m2doc.services;

import org.eclipse.acceleo.annotations.api.documentation.Documentation;
import org.eclipse.acceleo.annotations.api.documentation.Example;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.Type;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.UserDefinedTypeRef;

/**
 * Column's AQL services for M2Doc.
 * 
 * @author Obeo
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

    // @formatter:off
    @Documentation(
            comment = "{m:mycolumn.isAutoincrement()}",
            value = "Returns the 'Oui' string if the column is automatically incremented and 'No' otherwise.",
            examples = {
                    @Example(
                            expression = "{m:mycolumn.isAutoincrement()}", 
                            result = "insert 'Oui' or 'Non'.")
            }
        )
    // @formatter:on    
    public String isAutoincrement(Column column) {
        if (column != null) {
            return yesNo(column.isAutoincrement());
        } else {
            return "No";
        }
    }

    // @formatter:off
    @Documentation(
            comment = "{m:mycolumn.checkAutoincrement()}",
            value = "Returns the 'X' string if the column is automatically incremented and '' otherwise.",
            examples = {
                    @Example(
                            expression = "{m:mycolumn.checkAutoincrement()}", 
                            result = "insert 'X' or ''.")
            }
        )
    // @formatter:on    
    public String checkAutoincrement(Column column) {
        if (column != null) {
            return column.isAutoincrement() ? "X" : "";
        } else {
            return "";
        }
    }

    // @formatter:off
    @Documentation(
            comment = "{m:mycolumn.isInPrimaryKey()}",
            value = "Returns the 'Oui' string if the column is in a primary key and 'Non' otherwise.",
            examples = {
                    @Example(
                            expression = "{m:mycolumn.isInPrimaryKey()}", 
                            result = "insert 'Oui' or 'Non'.")
            }
        )
    // @formatter:on    
    public String isInPrimaryKey(Column column) {
        if (column != null) {
            return yesNo(column.isInPrimaryKey());
        } else {
            return "No";
        }
    }

    // @formatter:off
    @Documentation(
            comment = "{m:mycolumn.isInForeignKey()}",
            value = "Returns the 'Oui' string if the column is in a foreign key and 'Non' otherwise.",
            examples = {
                    @Example(
                            expression = "{m:mycolumn.isInForeignKey()}", 
                            result = "insert 'Oui' or 'Non'.")
            }
        )
    // @formatter:on    
    public String isInForeignKey(Column column) {
        if (column != null) {
            return yesNo(column.isInForeignKey());
        } else {
            return "No";
        }
    }

    // @formatter:off
    @Documentation(
            comment = "{m:mycolumn.isUnic()}",
            value = "Returns the 'Oui' string if the column is unique and 'Non' otherwise.",
            examples = {
                    @Example(
                            expression = "{m:mycolumn.isUnic()}", 
                            result = "insert 'Oui' or 'Non'.")
            }
        )
    // @formatter:on    
    public String isUnic(Column column) {
        if (column != null) {
            return yesNo(column.isUnique());
        } else {
            return "No";
        }
    }

    // @formatter:off
    @Documentation(
            comment = "{m:mycolumn.checkNullable()}",
            value = "Returns the 'X' string if the column is nullable and '' otherwise.",
            examples = {
                    @Example(
                            expression = "{m:mycolumn.checkNullable()}", 
                            result = "insert 'X' or ''.")
            }
        )
    // @formatter:on    
    public String checkNullable(Column column) {
        if (column != null) {
            return column.isNullable() ? "X" : "";
        } else {
            return "";
        }
    }

    // @formatter:off
    @Documentation(
            comment = "{m:mycolumn.isNullable()}",
            value = "Returns the 'Oui' string if the column is nullable and 'Non' otherwise.",
            examples = {
                    @Example(
                            expression = "{m:mycolumn.isNullable()}", 
                            result = "insert 'Oui' or 'Non'.")
            }
        )
    // @formatter:on    
    public String isNullable(Column column) {
        if (column != null) {
            return yesNo(column.isNullable());
        } else {
            return "No";
        }
    }

    // @formatter:off
    @Documentation(
            comment = "{m:mycolumn.checkMandatory()}",
            value = "Returns the 'X' string if the column is mandatory and '' otherwise.",
            examples = {
                    @Example(
                            expression = "{m:mycolumn.checkMandatory()}", 
                            result = "insert 'X' or ''.")
            }
        )
    // @formatter:on    
    public String checkMandatory(Column column) {
        if (column != null) {
            return column.isNullable() ? "" : "X";
        } else {
            return "";
        }
    }

    // @formatter:off
    @Documentation(
            comment = "{m:mycolumn.isMandatory()}",
            value = "Returns the 'Oui' string if the column is mandatory and 'Non' otherwise.",
            examples = {
                    @Example(
                            expression = "{m:mycolumn.isMandatory()}", 
                            result = "insert 'Oui' or 'Non'.")
            }
        )
    // @formatter:on    
    public String isMandatory(Column column) {
        if (column != null) {
            return yesNo(!column.isNullable());
        } else {
            return "No";
        }
    }

    // @formatter:off
    @Documentation(
            comment = "{m:mycolumn.checkInForeignKey()}",
            value = "Returns the 'X' string if the column is in foreign key and '' otherwise.",
            examples = {
                    @Example(
                            expression = "{m:mycolumn.checkInForeignKey()}", 
                            result = "insert 'X' or ''.")
            }
        )
    // @formatter:on    
    public String checkInForeignKey(Column column) {
        if (column != null) {
            return column.isInForeignKey() ? "X" : "";
        } else {
            return "";
        }
    }

    // @formatter:off
    @Documentation(
            comment = "{m:mycolumn.checkUnique()}",
            value = "Returns the 'X' string if the column is unique and '' otherwise.",
            examples = {
                    @Example(
                            expression = "{m:mycolumn.checkUnique()}", 
                            result = "insert 'X' or ''.")
            }
        )
    // @formatter:on    
    public String checkUnique(Column column) {
        if (column != null) {
            return column.isUnique() ? "X" : "";
        } else {
            return "";
        }
    }

    // @formatter:off
    @Documentation(
            comment = "{m:mycolumn.checkInPrimaryKey()}",
            value = "Returns the 'X' string if the column is in primary key and '' otherwise.",
            examples = {
                    @Example(
                            expression = "{m:mycolumn.checkInPrimaryKey()}", 
                            result = "insert 'X' or ''.")
            }
        )
    // @formatter:on    
    public String checkInPrimaryKey(Column col) {
        if (col != null) {
            return col.isInPrimaryKey() ? "X" : "";
        } else {
            return "";
        }
    }

    // @formatter:off
    @Documentation(
            comment = "{m:mycolumn.typeName()}",
            value = "Returns the name of the column type.",
            examples = {
                    @Example(
                            expression = "{m:mycolumn.typeName()}", 
                            result = "insert 'SomeType' or 'no name found'.")
            }
        )
    // @formatter:on    
    public String typeName(Column column) {
        String res = null;
        Type type = column.getType();
        if (type instanceof UserDefinedTypeRef) {
            res = ((UserDefinedTypeRef) type).getType().getName();
        } else if (type instanceof TypeInstance) {
            NativeType nativeType = ((TypeInstance) type).getNativeType();
            if (nativeType != null) {
                res = nativeType.getName();
            }
        }
        if (res == null) {
            res = "no name found";
        }
        return res;
    }

    // @formatter:off
    @Documentation(
            comment = "{m:mycolumn.typeLength()}",
            value = "Returns the length and the precision of the type associated to the column.\n" + 
                "Result is like follows :\n" + 
                "<ul>\n" + 
                "<li>&lt;length&gt; if the type has the NativeKind.LENGTH attribute</li>\n" + 
                "<li>&lt;length,precision&gt; if the type has the NativeKind.LENGTH_AND_PRECISION attribute</li>\n" + 
                "</ul>\n",
            examples = {
                    @Example(
                            expression = "{m:mycolumn.typeLength()}", 
                            result = "insert a description of the length of the column's type.")
            }
        )
    // @formatter:on    
    public String typeLength(Column col) {
        String res = "";
        Type type = col.getType();
        if (type instanceof TypeInstance) {
            TypeInstance instance = (TypeInstance) type;
            NativeType nativeType = instance.getNativeType();
            if (nativeType != null) {
                switch (nativeType.getSpec()) {
                    case LENGTH:
                        // Fix for SAFRAN-676 : Potential NPE
                        if (instance.getLength() != null) {
                            res = instance.getLength().toString();
                        }
                        break;
                    case LENGTH_AND_PRECISION:
                        // Fix for SAFRAN-676 : Potential NPE
                        if (instance.getLength() != null) {
                            res += instance.getLength();
                        }
                        res += ",";
                        if (instance.getPrecision() != null) {
                            res += instance.getPrecision();
                        }
                        break;
                    default:
                        res = "";
                }
            }
        }
        return res;
    }

    // @formatter:off
    @Documentation(
            comment = "{m:mycolumn.defaultValue()}",
            value = "Returns the default value of the column.",
            examples = {
                    @Example(
                            expression = "{m:mycolumn.defaultValue()}", 
                            result = "insert the default value.")
            }
        )
    // @formatter:on    
    public String defaultValue(Column col) {
        if (col.getDefaultValue() != null) {
            return col.getDefaultValue();
        } else {
            return "";
        }
    }
}
