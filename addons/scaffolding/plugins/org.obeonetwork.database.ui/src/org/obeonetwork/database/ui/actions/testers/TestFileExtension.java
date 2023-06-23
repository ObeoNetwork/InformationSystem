/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.database.ui.actions.testers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;

public class TestFileExtension extends PropertyTester {

	public TestFileExtension() {
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (args != null && args.length >= 1) {
			String extension = (String) args[0];
			if (extension != null) {
				if (receiver instanceof IFile) {
					return extension.equals(((IFile) receiver).getFileExtension());
				} else if (receiver instanceof Resource) {
					return extension.equals(((Resource) receiver).getURI().fileExtension());
				}
			}
		}
		return false;
	}

}
