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
package org.obeonetwork.database.transfo;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import org.obeonetwork.database.scaffold.ScaffoldInfo;
import org.obeonetwork.database.scaffold.ScaffoldType;

public interface Transformation {
	
	public boolean transform(URI scaffoldInfoURI, ScaffoldType scaffoldType);
	public boolean transform(ScaffoldInfo scaffoldInfo, ScaffoldType scaffoldType);
	public boolean doTransformationFirstStep(ScaffoldInfo scaffoldInfo, ScaffoldType scaffoldType);
	public void doTransformationFinalStep();
	public Resource getResult();
	public void setSaveFinalResource(boolean saveFinalResource);
}
