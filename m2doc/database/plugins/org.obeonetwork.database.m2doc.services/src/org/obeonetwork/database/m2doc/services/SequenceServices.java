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

import java.util.Collections;
import java.util.List;

import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Sequence;

/**
 * AQL Services on Sequence for M2Doc.
 * 
 * @author Romain Guider
 */
public class SequenceServices {

    /**
     * Returns "Oui" if the sequence is cyclic and "No" otherwise (or if it's null).
     * 
     * @param sequence
     * @return "Oui" or "Non" if the sequence is cyclic.
     */
    public String isCycle(Sequence sequence) {
        if (sequence != null) {
            return sequence.isCycle() ? "Oui" : "Non";
        } else {
            return "Non";
        }
    }

    /**
     * Returns "X" if the sequence is cyclic and "" otherwise (or if it's null).
     * 
     * @param element
     * @return "X" if the sequence is cyclic.
     */
    public String checkCycle(Sequence sequence) {
        if (sequence != null) {
            return sequence.isCycle() ? "X" : "";
        } else {
            return "";
        }
    }

    /**
     * REturns the list of columns of the sequence and the empty list if the sequence is null.
     * 
     * @param sequence
     * @return the list of columns.
     */
    public List<Column> columns(Sequence sequence) {
        if (sequence == null) {
            return Collections.emptyList();
        } else {
            return sequence.getColumns();
        }
    }

}
