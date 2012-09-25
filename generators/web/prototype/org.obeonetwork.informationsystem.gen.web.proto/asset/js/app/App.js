/*******************************************************************************
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

/*
 * @autor hugo.marchadour@obeo.fr
 * @version 0.8
 *
 */
define(["require", "app/query/usersManager", "app/query/accountManager", "app/query/officesManager", "app/query/chocosManager", "ember"], function(require) {

	var usersManager = require("app/query/usersManager");
	var accountManager = require("app/query/accountManager");
	var officesManager = require("app/query/officesManager");
	var chocosManager = require("app/query/chocosManager");
	
	App = Em.Application.create();
	App.debug = false;

	App.users = usersManager;
	
	App.chocos = chocosManager;
	
	App.offices = officesManager;
	
	App.account = accountManager;

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
		var template = "<div class=\"alert "+cssClass+"\"><button class=\"close\" data-dismiss=\"alert\">×</button>"+htmlMsg+"</div>";
		var addedInDom = $(template).prependTo("#toasts");
	};
	
	return App;
});
