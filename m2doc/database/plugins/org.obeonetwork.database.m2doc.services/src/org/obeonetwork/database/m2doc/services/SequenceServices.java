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

import java.util.Collections;
import java.util.List;

import org.eclipse.acceleo.annotations.api.documentation.Documentation;
import org.eclipse.acceleo.annotations.api.documentation.Example;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Sequence;

/**
 * AQL Services on Sequence for M2Doc.
 * 
 * @author Obeo
 */
public class SequenceServices {

    // @formatter:off
    @Documentation(
            comment = "{m:mySequence.checkCycle()}",
            value = "Returns 'Oui' if the sequence is cyclic and 'Non' otherwise (or if it's null).",
            examples = {
                    @Example(
                            expression = "{m:mySequence.checkCycle()}", 
                            result = "insert 'Oui' or 'Non'.")
            }
        )
    // @formatter:on    
    public String isCycle(Sequence sequence) {
        if (sequence != null) {
            return sequence.isCycle() ? "Oui" : "Non";
        } else {
            return "Non";
        }
    }

    // @formatter:off
    @Documentation(
            comment = "{m:mySequence.checkCycle()}",
            value = "Returns 'X' if the sequence is cyclic and '' otherwise (or if it's null).",
            examples = {
                    @Example(
                            expression = "{m:mySequence.checkCycle()}", 
                            result = "insert 'X' or ''.")
            }
        )
    // @formatter:on    
    public String checkCycle(Sequence sequence) {
        if (sequence != null) {
            return sequence.isCycle() ? "X" : "";
        } else {
            return "";
        }
    }

    // @formatter:off
    @Documentation(
            comment = "{m:mySequence.columns()}",
            value = "Returns the list of columns of the sequence and the empty list if the sequence is null.",
            examples = {
                    @Example(
                            expression = "{m:mySequence.columns()}", 
                            result = "the list of columns of the sequence and the empty list if the sequence is null.")
            }
        )
    // @formatter:on    
    public List<Column> columns(Sequence sequence) {
        if (sequence == null) {
            return Collections.emptyList();
        } else {
            return sequence.getColumns();
        }
    }

}
