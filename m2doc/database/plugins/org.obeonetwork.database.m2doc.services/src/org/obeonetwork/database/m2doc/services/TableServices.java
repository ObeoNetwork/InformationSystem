/*******************************************************************************
 * Copyright (c) 2016, 2017 Obeo.
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

    /**
     * Returns the name of the specified table's primary key. Returns "" if there's no primary key.
     * 
     * @param table
     * @return the table's primary key name.
     */
    public String primaryKeyName(Table table) {
        PrimaryKey key = table.getPrimaryKey();
        String result = null;
        if (key != null) {
            result = key.getName();
        }
        return result == null ? "" : result;
    }

    /**
     * Returns the list of the foreign key's names.
     * 
     * @param table
     * @return the list of foreign key's names.
     */
    public List<String> foreignKeyNames(Table table) {
        final List<String> res = new ArrayList<String>();

        for (ForeignKey key : table.getForeignKeys()) {
            res.add(key.getName());
        }

        return res;
    }

    /**
     * Returns the list of columns that are nor primary key neither foreign key.
     * 
     * @param table
     * @return
     */
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

    /**
     * Returns the list of all the column's names.
     * 
     * @param table
     * @return the list of column names.
     */
    public List<String> allColumnNames(Table table) {
        List<String> result = new ArrayList<String>();
        for (Column column : table.getColumns()) {
            result.add(column.getName());
        }
        return result;
    }

    /**
     * Returns the list of pure column names.
     * 
     * @param table
     * @return the list of pure column names.
     */
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
