/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.database.m2doc.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.acceleo.annotations.api.documentation.Documentation;
import org.eclipse.acceleo.annotations.api.documentation.Example;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.Table;

/**
 * AQL services on tables for M2Doc.
 * 
 * @author Romain Guider
 */
public class TableServices {

    // @formatter:off
    @Documentation(
            comment = "{m:myTable.primaryKeyName()}",
            value = "Returns the name of the specified table's primary key. Returns '' if there's no primary key.",
            examples = {
                    @Example(
                            expression = "{m:myTable.primaryKeyName()}", 
                            result = "insert the table's primary key name.")
            }
        )
    // @formatter:on    
    public String primaryKeyName(Table table) {
        PrimaryKey key = table.getPrimaryKey();
        String result = null;
        if (key != null) {
            result = key.getName();
        }
        return result == null ? "" : result;
    }

    // @formatter:off
    @Documentation(
            comment = "{m:myTable.foreignKeyNames()}",
            value = "Returns the list of the foreign key's names.",
            examples = {
                    @Example(
                            expression = "{m:myTable.foreignKeyNames()}", 
                            result = "the list of foreign key's names")
            }
        )
    // @formatter:on    
    public List<String> foreignKeyNames(Table table) {
        final List<String> res = new ArrayList<String>();

        for (ForeignKey key : table.getForeignKeys()) {
            res.add(key.getName());
        }

        return res;
    }

    // @formatter:off
    @Documentation(
            comment = "{m:myTable.pureColumns()}",
            value = "Returns the list of columns that are nor primary key neither foreign key.",
            examples = {
                    @Example(
                            expression = "{m:myTable.pureColumns()}", 
                            result = "the list of columns that are nor primary key neither foreign key.")
            }
        )
    // @formatter:on    
    public List<Column> pureColumns(Table table) {
        final List<Column> res = new ArrayList<Column>();

        for (Column column : table.getColumns()) {
            if (!column.isInForeignKey() && !column.isInPrimaryKey()) {
                res.add(column);
            }
        }

        return res;
    }

    public List<Column> allColumns(Table table) {
        return table.getColumns();
    }

    // @formatter:off
    @Documentation(
            comment = "{m:myTable.allColumnNames()}",
            value = "Returns the list of all the column's names.",
            examples = {
                    @Example(
                            expression = "{m:myTable.allColumnNames()}", 
                            result = "the list of all the column's names.")
            }
        )
    // @formatter:on    
    public List<String> allColumnNames(Table table) {
        List<String> result = new ArrayList<String>();
        for (Column column : table.getColumns()) {
            result.add(column.getName());
        }
        return result;
    }

    // @formatter:off
    @Documentation(
            comment = "{m:myTable.pureColumnNames()}",
            value = "Returns the list of pure column names.",
            examples = {
                    @Example(
                            expression = "{m:myTable.pureColumnNames()}", 
                            result = "the list of pure column names.")
            }
        )
    // @formatter:on    
    public List<String> pureColumnNames(Table table) {
        final List<String> res = new ArrayList<String>();
        for (Column column : table.getColumns()) {
            if (!column.isInForeignKey() && !column.isInPrimaryKey()) {
                res.add(column.getName());
            }
        }

        return res;
    }

}
