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
 * @since 0.2.0
 * @generated
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/App", "app/view/ViewUtil", "app/security/LogManager", "app/view/widget/HomeMenuLeft", "app/view/widget-container/Users", "app/view/widget-container/ChocoVote", "app/view/widget-container/OfficeStatistics" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var App = require("app/App"),
		ViewUtil = require("app/view/ViewUtil"),
		LogManager = require("app/security/LogManager"),
		HomeMenuLeft = require("app/view/widget/HomeMenuLeft"),
		Users = require("app/view/widget-container/Users"),
		ChocoVote = require("app/view/widget-container/ChocoVote"),
		OfficeStatistics = require("app/view/widget-container/OfficeStatistics");
/** End of user code */


	var HomePage = {};
	var oldView = undefined;
	var viewHomeMenuLeft = undefined;

	function _init() {
		_renderMenuLeft();
	}

	HomePage.start = function() {
		_init();
	};

	HomePage.stop = function() {
		viewHomeMenuLeft.remove();
		_cleanWorkspace();
	};

	HomePage.refresh = function() {
		_cleanWorkspace();
		if(oldView != undefined) {
			_insertView(oldView);
		}
	}
	HomePage.renderUsers = function() {
		
		_insertView(Users.create());
	};
	HomePage.renderChocoVote = function() {
		
		_insertView(ChocoVote.create());
	};
	HomePage.renderOfficeStatistics = function() {
		
		_insertView(OfficeStatistics.create());
	};

	HomePage.changeActiveMenu = function(cssClass) {
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
			viewHomeMenuLeft = HomeMenuLeft.create();
			viewHomeMenuLeft.didInsertElement = function() {
				_initNav();
			}
			viewHomeMenuLeft.appendTo("#menu-left");
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

	return HomePage;
});
