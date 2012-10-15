 /*******************************************************************************
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Hugo Marchadour (Obeo) - initial API and implementation
 *******************************************************************************/

 /**
 * @autor hugo.marchadour@obeo.fr
 * @version 1.0.0
 * @since 1.0
 * @generated
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/App", "app/view/ViewUtil", "app/view/CommonEvents", "ember" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var App = require("app/App"),
		ViewUtil = require("app/view/ViewUtil"),
		CommonEvents = require("app/view/CommonEvents");
	// ember does not need to be stored in a variable.
/** End of user code */

	
	var AdminMenuLeft = {},
		_Class = Em.View.extend({ templateName : "admin-menu-left" });

	
	
	/*
	 */
	AdminMenuLeft.create = function() {
		ViewUtil.loadWidgetTemplate("./asset/template/widget/other/admin-menu-left");

		var view = _Class.create({
			
			didInsertElement : cb_whenInsert,
			/** Start of user code additional features */
			/** End of user code */
		});
		
		return view;
	};
	
	AdminMenuLeft.getClass = function() { return _Class; };
	
	/*call backs*/
	var cb_loadAccount = function(account) {

		this.set('account', account);
	};

	var cb_whenInsert = function() {
		
	};
	
	/** Start of user code additional functions */
	/** End of user code */

	return AdminMenuLeft;
});
