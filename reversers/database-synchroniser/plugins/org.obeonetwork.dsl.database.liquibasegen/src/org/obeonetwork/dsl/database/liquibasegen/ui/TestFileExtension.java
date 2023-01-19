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
package org.obeonetwork.dsl.database.liquibasegen.ui;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.internal.resources.File;

@SuppressWarnings("restriction")
public class TestFileExtension extends PropertyTester {

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof File) {
			File file = (File) receiver;
			file.getName();
			return file.getName().endsWith("changelog.xml");
		}
		return false;
	}

}
