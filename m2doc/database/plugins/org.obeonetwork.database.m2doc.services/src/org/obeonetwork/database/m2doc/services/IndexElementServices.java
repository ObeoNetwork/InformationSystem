/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
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
import org.obeonetwork.dsl.database.IndexElement;

/**
 * AQL IndexElement services for M2Doc.
 * 
 * @author Obeo
 */
public class IndexElementServices {

    // @formatter:off
    @Documentation(
            comment = "{m:myIndexElement.checkAscending()}",
            value = "Returns 'X' if the element is sorted in ascending order and '' otherwise (or if it's null).",
            examples = {
                    @Example(
                            expression = "{m:myIndexElement.checkAscending()}", 
                            result = "insert 'X' or ''.")
            }
        )
    // @formatter:on    
    public String checkAscending(IndexElement element) {
        if (element != null) {
            return element.isAsc() ? "X" : "";
        } else {
            return "";
        }
    }

    // @formatter:off
    @Documentation(
            comment = "{m:myIndexElement.checkAscending()}",
            value = "Returns 'Oui' if the element is sorted in ascending order and 'Non' otherwise (or if it's null).",
            examples = {
                    @Example(
                            expression = "{m:myIndexElement.checkAscending()}", 
                            result = "insert 'Oui' or 'Non'.")
            }
        )
    // @formatter:on    
    public String isAscending(IndexElement element) {
        if (element != null) {
            return element.isAsc() ? "Oui" : "Non";
        } else {
            return "";
        }
    }

}
