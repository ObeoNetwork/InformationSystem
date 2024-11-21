/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.is.designer.acceleo.aql.business;

import org.eclipse.sirius.ext.base.I18N;
import org.eclipse.sirius.ext.base.I18N.TranslatableMessage;

/**
 * Helper class to obtains translated strings.
 * 
 * @author pcdavid
 */
public final class Messages {

    static {
        I18N.initializeMessages(Messages.class, AQLSiriusPlugin.INSTANCE);
    }

    // CHECKSTYLE:OFF
    @TranslatableMessage
    public static String AQLInterpreter_errorLoadingJavaClass;

    @TranslatableMessage
    public static String AQLInterpreter_javaClassNotFound;

    @TranslatableMessage
    public static String AQLInterpreter_errorWithExpression;

    // CHECKSTYLE:ON

    private Messages() {
        // Prevents instanciation.
    }
}
