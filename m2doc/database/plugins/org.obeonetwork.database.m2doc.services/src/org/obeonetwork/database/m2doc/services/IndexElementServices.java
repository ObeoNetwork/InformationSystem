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

import org.obeonetwork.dsl.database.IndexElement;

/**
 * AQL IndexElement services for M2Doc.
 * 
 * @author Romain Guider
 */
public class IndexElementServices {

    /**
     * Returns "X" if the element is sorted in ascending order and "" otherwise (or if it's null).
     * 
     * @param element
     * @return "X" if the element is sorted in ascending order.
     */
    public String checkAscending(IndexElement element) {
        if (element != null) {
            return element.isAsc() ? "X" : "";
        } else {
            return "";
        }
    }

    /**
     * Returns "Oui" if the element is sorted in ascending order and "No" otherwise (or "" if it's null).
     * 
     * @param element
     * @return "Oui" or "Non" if the element is sorted in ascending order or not.
     */
    public String isAscending(IndexElement element) {
        if (element != null) {
            return element.isAsc() ? "Oui" : "Non";
        } else {
            return "";
        }
    }

}
