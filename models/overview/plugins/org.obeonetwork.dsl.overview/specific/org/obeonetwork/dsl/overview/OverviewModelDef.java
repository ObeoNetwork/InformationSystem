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
package org.obeonetwork.dsl.overview;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.notify.AdapterFactory;

public interface OverviewModelDef {

    public final static String EXTENSION_POINT = "org.obeonetwork.dsl.overview.overviewModelDef";
	
    //Check root metadatas and return true if the current Model Def is applicable on the current
    //Overview model
    boolean isApplicable(Root root);
    
    String getFileNameExtension();
    
    AdapterFactory getAdapterFactory();
    
    void initModel(Root root);
    
	Collection<?> getNewChildDescriptors(Root root);

	String getID();
	
	void openEditor(IFile modelFile);
}
