package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper;

import org.obeonetwork.dsl.environment.bindingdialect.DBoundElement;

public class TreeRoot {
	private DBoundElement element;
	
	public TreeRoot(DBoundElement element) {
		super();
		this.element = element;
	}

	public DBoundElement getElement() {
		return element;
	}
}
