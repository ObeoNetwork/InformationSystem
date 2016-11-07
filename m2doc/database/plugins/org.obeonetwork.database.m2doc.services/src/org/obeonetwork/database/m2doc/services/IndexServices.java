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

import org.obeonetwork.dsl.database.Index;

/**
 * AQL services on Index for M2Doc.
 * 
 * @author Romain Guider
 */
public class IndexServices {

    /**
     * Returns "Oui" if the element is unique and "No" otherwise (or if it's null).
     * 
     * @param element
     * @return "Oui" or "Non" if the element is unique.
     */
    public String isUnic(Index index) {
        if (index != null) {
            return index.isUnique() ? "Oui" : "Non";
        } else {
            return "Non";
        }
    }

    /**
     * Returns "X" if the element is unique and "" otherwise (or if it's null).
     * 
     * @param element
     * @return "X" if the element is unique.
     */
    public String checkUnique(Index index) {
        if (index != null) {
            return index.isUnique() ? "X" : "";
        } else {
            return "";
        }
    }

}
