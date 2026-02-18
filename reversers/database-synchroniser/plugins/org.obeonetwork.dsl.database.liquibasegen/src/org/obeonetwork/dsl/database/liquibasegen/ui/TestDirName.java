/**
 * 
 */
package org.obeonetwork.dsl.database.liquibasegen.ui;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.internal.resources.Container;

/**
 * @author Vincent BOUSSAUD
 *
 */
@SuppressWarnings("restriction")
public class TestDirName extends PropertyTester {
	
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof Container) {
			Container container = (Container) receiver;
			if (container.getParent() == null || container.getProject() == null) {
				return false;
			}else {
				return container.getName().equals(container.getProject().getName()+"-"+container.getParent().getName());
			}
		}
		return false;
	}

}
