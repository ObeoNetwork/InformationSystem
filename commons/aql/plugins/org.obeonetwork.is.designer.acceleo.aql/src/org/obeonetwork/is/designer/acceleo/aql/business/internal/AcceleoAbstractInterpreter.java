/*******************************************************************************
 * Copyright (c) 2015, 2019 Obeo.
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
package org.obeonetwork.is.designer.acceleo.aql.business.internal;

import java.util.Collection;

import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.common.tools.api.interpreter.JavaExtensionsManager;
import org.eclipse.sirius.common.tools.internal.interpreter.AbstractInterpreter;

/**
 * An abstract class which handles the classloading status.
 *
 * @author cedric
 */
public abstract class AcceleoAbstractInterpreter extends AbstractInterpreter {
    /**
     * Instance responsible for managing the imports, dependencies and Java Services.
     */
    protected JavaExtensionsManager javaExtensions;

    /**
     * Create a new Interpreter.
     */
    public AcceleoAbstractInterpreter() {
        javaExtensions = JavaExtensionsManager.createManagerWithOverride();
    }

    @Override
    public void dispose() {
        this.javaExtensions.dispose();
        super.dispose();
    }

    @Override
    public void setProperty(Object key, Object value) {
        /*
         * This is called by the framework with the FILES key in order to pass us all the VSM files as a Collection.
         */
        if (IInterpreter.FILES.equals(key)) {
            javaExtensions.updateScope((Collection<String>) value);
        }
    }

    @Override
    public void addImport(String dependency) {
        javaExtensions.addImport(dependency);

    }

    @Override
    public void removeImport(String dependency) {
        javaExtensions.removeImport(dependency);
    }

    @Override
    public Collection<String> getImports() {
        return javaExtensions.getImports();

    }

    @Override
    public void clearImports() {
        javaExtensions.clearImports();
    }
}
