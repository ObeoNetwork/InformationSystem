/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.actions.testers;

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
