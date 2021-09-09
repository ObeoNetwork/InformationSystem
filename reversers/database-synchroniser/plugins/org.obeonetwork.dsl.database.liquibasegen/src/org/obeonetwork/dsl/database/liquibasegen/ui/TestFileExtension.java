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
