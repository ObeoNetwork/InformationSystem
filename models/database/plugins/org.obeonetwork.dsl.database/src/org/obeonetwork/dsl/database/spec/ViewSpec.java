package org.obeonetwork.dsl.database.spec;


import org.obeonetwork.dsl.database.impl.ViewImpl;

public class ViewSpec extends ViewImpl{

	/**
	 *  View content is initialized.
	 * The view have references (tables, columns) which are not saved 
	 * and need to be computed at the opening of a diagram.
	 */
	public boolean initialized = false;
	
	public ViewSpec(){
		super();
	}

}