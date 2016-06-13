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
 * @since 0.1.0
 * @generated
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/App", "app/view/page/AdminPage" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var App = require("app/App"),
		AdminPage = require("app/view/page/AdminPage");
/** End of user code */

	var AdminCtrl = {};
	
	var allowedStates = ["default", "admins"];
	
	function _init() {

		AdminPage.start();
		AdminCtrl.stateChange();
	}

	AdminCtrl.start = function() {
		
		_init();
	};

	AdminCtrl.stop = function() {
		
		AdminPage.stop();
	};

	AdminCtrl.refresh = function() {
		
		AdminPage.refresh();
	};
	
	/*
	 * @param {String} the string Id of the state
	 * @return boolean true if it's a valid state
	 */
	AdminCtrl.stateChange = function(state, historyMode) {

		switch(state) {
			default:
				_toAdminsState();
				break;
		}

	};
	
	/**/
	function _toAdminsState() {
		
		AdminPage.renderAdmins();
		AdminPage.changeActiveMenu(allowedStates[1]);
	}
	
	/** Start of user code additional functions */
	/** End of user code */

	return AdminCtrl;
});
