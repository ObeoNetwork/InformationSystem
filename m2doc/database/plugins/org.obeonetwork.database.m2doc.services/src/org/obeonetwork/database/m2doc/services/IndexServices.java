/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
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
import org.obeonetwork.dsl.database.Index;

/**
 * AQL services on Index for M2Doc.
 * 
 * @author Obeo
 */
public class IndexServices {

    // @formatter:off
    @Documentation(
            comment = "{m:myIndex.isUnic()}",
            value = "Returns 'Oui' if the element is unique and 'Non' otherwise (or if it's null).",
            examples = {
                    @Example(
                            expression = "{m:myIndex.isUnic()}", 
                            result = "insert 'Oui' or 'Non'.")
            }
        )
    // @formatter:on    
    public String isUnic(Index index) {
        if (index != null) {
            return index.isUnique() ? "Oui" : "Non";
        } else {
            return "Non";
        }
    }

    // @formatter:off
    @Documentation(
            comment = "{m:myIndex.checkUnique()}",
            value = "Returns 'X' if the element is unique and '' otherwise (or if it's null).",
            examples = {
                    @Example(
                            expression = "{m:myIndex.checkUnique()}", 
                            result = "insert 'X' or ''.")
            }
        )
    // @formatter:on    
    public String checkUnique(Index index) {
        if (index != null) {
            return index.isUnique() ? "X" : "";
        } else {
            return "";
        }
    }

}
