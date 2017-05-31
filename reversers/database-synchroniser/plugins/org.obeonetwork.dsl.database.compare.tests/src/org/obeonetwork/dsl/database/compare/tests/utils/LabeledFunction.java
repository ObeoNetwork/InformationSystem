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
