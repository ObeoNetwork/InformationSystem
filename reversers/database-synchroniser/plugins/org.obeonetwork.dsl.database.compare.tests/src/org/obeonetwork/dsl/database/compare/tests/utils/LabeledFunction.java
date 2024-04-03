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
package org.obeonetwork.dsl.database.compare.tests.utils;

import java.util.function.Function;

public class LabeledFunction<T, R> {
	private Function<T, R> function;
	private String label;

	public LabeledFunction(String label, Function<T, R> function) {
		this.label = label;
		this.function = function;
	}

	public R apply(T input) {
		return this.function.apply(input);
	}

	public String getLabel() {
		return this.label;
	}
}
