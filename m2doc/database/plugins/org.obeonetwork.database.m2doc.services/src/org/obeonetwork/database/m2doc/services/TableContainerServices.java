/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
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
import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.View;

/**
 * AQL services for M2Doc on table containers.
 * 
 * @author Romain Guider
 */
public class TableContainerServices {

    // @formatter:off
    @Documentation(
            comment = "{m:myTableContainer.tables()}",
            value = "Returns the list of tables contained in the specified table container (database of schema).",
            examples = {
                    @Example(
                            expression = "{m:myTableContainer.tables()}", 
                            result = "the list of tables contained in the specified table container (database of schema).")
            }
        )
    // @formatter:on    
    public List<Table> tables(TableContainer container) {
        final List<Table> res = new ArrayList<Table>();
        for (AbstractTable abstractTable : container.getTables()) {
            if (abstractTable instanceof Table) {
                res.add((Table) abstractTable);
            }
        }

        return res;
    }

    // @formatter:off
    @Documentation(
            comment = "{m:myTableContainer.views()}",
            value = "Returns the list of views contained in a table container (database or schema).",
            examples = {
                    @Example(
                            expression = "{m:myTableContainer.views()}", 
                            result = "the list of views contained in a table container (database or schema).")
            }
        )
    // @formatter:on    
    public List<View> views(TableContainer container) {
        final List<View> res = new ArrayList<View>();

        for (AbstractTable abstractTable : container.getTables()) {
            if (abstractTable instanceof View) {
                res.add((View) abstractTable);
            }
        }

        return res;
    }
}
