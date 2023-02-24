/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.sqlgen;

import org.eclipse.acceleo.parser.compiler.AbstractAcceleoCompiler;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;

/**
 * The Acceleo Standalone compiler.
 * 
 */
public class AcceleoCompiler extends AbstractAcceleoCompiler {
    
    /**
     * The entry point of the compilation.
     * 
     * @param args
     *             The arguments used in the compilation: the source folder,
     *             the output folder, a boolean indicating if we should use binary resource
     *             serialization and finally the dependencies of the project.
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Missing parameters"); //$NON-NLS-1$
        }
        AcceleoCompiler acceleoCompiler = new AcceleoCompiler();
        acceleoCompiler.setSourceFolder(args[0]);
        acceleoCompiler.setOutputFolder(args[1]);
        acceleoCompiler.setBinaryResource(Boolean.valueOf(args[2]).booleanValue());
        if (args.length == 4 && args[3] != null && !"".equals(args[3])) { //$NON-NLS-1$
            acceleoCompiler.setDependencies(args[3]);
        }
        acceleoCompiler.doCompile(new BasicMonitor());
    }
    
    /**
     * Launches the compilation of the mtl files in the generator.
     * 
     * @see org.eclipse.acceleo.parser.compiler.AbstractAcceleoCompiler#doCompile(org.eclipse.emf.common.util.Monitor)
     */
    @Override
    public void doCompile(Monitor monitor) {
        super.doCompile(monitor);
    }
    
    /**
     * Registers the packages of the metamodels used in the generator.
     * 
     * @see org.eclipse.acceleo.parser.compiler.AbstractAcceleoCompiler#registerPackages()
     */
    @Override
    protected void registerPackages() {
        super.registerPackages();
        /*
         * If you want to add the other packages used by your generator, for example UML:
         * org.eclipse.emf.ecore.EPackage.Registry.put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
         **/
        org.eclipse.emf.ecore.EPackage.Registry.INSTANCE.put(DatabasePackage.eNS_URI, DatabasePackage.eINSTANCE);
        org.eclipse.emf.ecore.EPackage.Registry.INSTANCE.put(DbevolutionPackage.eNS_URI, DbevolutionPackage.eINSTANCE);
    }

    /**
     * Registers the resource factories.
     * 
     * @see org.eclipse.acceleo.parser.compiler.AbstractAcceleoCompiler#registerResourceFactories()
     */
    @Override
    protected void registerResourceFactories() {
        super.registerResourceFactories();
        /*
         * If you want to add other resource factories, for example if your metamodel uses a specific serialization:
         * org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
         **/
    }
}
