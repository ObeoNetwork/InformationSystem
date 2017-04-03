 /*******************************************************************************
 * Copyright (c) 2012, 2016 Obeo.
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
 * @since 0.2.0
 * @generated
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/App", "app/view/ViewUtil", "app/security/LogManager", "app/view/widget/AdminMenuLeft", "app/view/widget-container/Admins" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var App = require("app/App"),
		ViewUtil = require("app/view/ViewUtil"),
		LogManager = require("app/security/LogManager"),
		AdminMenuLeft = require("app/view/widget/AdminMenuLeft"),
		Admins = require("app/view/widget-container/Admins");
/** End of user code */


	var AdminPage = {};
	var oldView = undefined;
	var viewAdminMenuLeft = undefined;

	function _init() {
		_renderMenuLeft();
	}

	AdminPage.start = function() {
		_init();
	};

	AdminPage.stop = function() {
		viewAdminMenuLeft.remove();
		_cleanWorkspace();
	};

	AdminPage.refresh = function() {
		_cleanWorkspace();
		if(oldView != undefined) {
			_insertView(oldView);
		}
	}
	AdminPage.renderAdmins = function() {
		
		_insertView(Admins.create());
	};

	AdminPage.changeActiveMenu = function(cssClass) {
		/** Start of user code default changeActiveMenu */
		var node = $("#menu-left .nav-list a."+cssClass);
		$("#menu-left .nav-list li").removeClass("active");
		$(node).parent("li").addClass("active");
		/** End of user code */
	}

	function _insertView(view) {
		if(LogManager.isLogged()) {
			_cleanWorkspace();
			oldView = view;
			view.appendTo("#workspace");
		}
	}

	function _renderMenuLeft() {
		
		if(LogManager.isLogged()) {
			viewAdminMenuLeft = AdminMenuLeft.create();
			viewAdminMenuLeft.didInsertElement = function() {
				_initNav();
			}
			viewAdminMenuLeft.appendTo("#menu-left");
		}
	}

	function _cleanWorkspace() {
		
		if(oldView != undefined) {
			oldView.remove();
		}
	}
	
	/* event */
	function _initNav() {
		
		$("#menu-left .nav-list a").click(function(event) {
			
			event.preventDefault(); // prevent the standard link click
			
			var state = $(this).attr("class");
			App.ctrl.stateChange(state);
		});
	};
	
	/** Start of user code additional functions */
	/** End of user code */

	return AdminPage;
});
