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

import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.ForeignKeyElement;

/**
 * M2Doc services for the ForeignKeyElements
 * 
 * @author Romain Guider
 */
public class ForeignKeyElementServices {

    /**
     * returns the column associated to the foreign key element.
     * 
     * @param element
     * @return the associated column.
     */
    public Column foreignKeyColumn(ForeignKeyElement element) {
        return element.getFkColumn();
    }

    /**
     * returns the column associated to the foreign key element as a primary key.
     * 
     * @param element
     * @return the associated column.
     */
    public Column primaryKeyColumn(ForeignKeyElement element) {
        return element.getPkColumn();
    }

}
