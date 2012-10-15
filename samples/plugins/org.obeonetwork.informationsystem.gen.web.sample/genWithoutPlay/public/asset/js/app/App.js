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
define(["require", "app/query/ChocoManager", "app/query/UserManager", "app/query/OfficeManager", "app/query/AccountManager", "ember" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var ChocoManager = require("app/query/ChocoManager"),
		UserManager = require("app/query/UserManager"),
		OfficeManager = require("app/query/OfficeManager"),
		AccountManager = require("app/query/AccountManager");
	// ember does not need to be stored in a variable.
/** End of user code */

	
	var App = Em.Application.create();
	App.debug = false;

	App.AccountManager = AccountManager;
	
	App.ChocoManager = ChocoManager;
	App.UserManager = UserManager;
	App.OfficeManager = OfficeManager;

	/** Start of user code default toast system */
	App.toast = {};
	
	App.toast.debug = function(msg) {
		
		if(App.debug) {
			_addToast(msg, "debug");
		}
	}
	
	App.toast.info = function(msg) {
		
		_addToast(msg, "info");
	}
	
	App.toast.warning = function(msg) {
		
		_addToast(msg, "warning");
	}
	
	App.toast.success = function(msg) {
		
		_addToast(msg, "success");
	}
	
	App.toast.error = function(msg) {
		
		_addToast(msg, "danger");
	}
	
	/*
	 * @param {String} the html message
	 * @param {String} the toast type (info, warning, success, debug or danger)
	 */
	function _addToast(msg, type) {
		
		var htmlMsg;
		var cssClass;
		
		switch(type) {
			case "debug" : 
				htmlMsg = "<strong>Debug!</strong> "+msg;
				cssClass = "alert-error"; 
			break;
			case "danger" : 
				htmlMsg = "<strong>Error!</strong> "+msg;
				cssClass = "alert-error"; 
			break;
			case "warning" : 
				htmlMsg = "<strong>Warning!</strong> "+msg;
				cssClass = ""; 
			break;
			case "success" : 
				htmlMsg = "<strong>Well done!</strong> "+msg;
				cssClass = "alert-success"; 
			break;
			default : 
				htmlMsg = "<strong>Info!</strong>" +msg;
				cssClass = "alert-info"; 
			break;
		}
		var template = "<div class=\"alert "+cssClass+"\"><button class=\"close\" data-dismiss=\"alert\">x</button>"+htmlMsg+"</div>";
		var addedInDom = $(template).prependTo("#toasts");
	};
	/** End of user code */

	/** Start of user code additional functions */
	/** End of user code */

	return App;
});
