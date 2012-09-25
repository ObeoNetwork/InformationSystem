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
 * @version 0.9
 * @since 0.2
 */
define(["require", "app/App", "app/view/ViewUtil", "app/view/widget-container/ChocoVote", "app/view/widget-container/Users", "app/view/widget-container/OfficeStatistics", "app/security/LogManager"], function(require) {
	
	/*__ Libs __*/
	var App = require("app/App");
	var ViewUtil = require("app/view/ViewUtil");
	var ChocoVote = require("app/view/widget-container/ChocoVote");
	var Users = require("app/view/widget-container/Users");
	var OfficeStatistics = require("app/view/widget-container/OfficeStatistics");
	var LogManager = require("app/security/LogManager");
	/*__ Libs __*/
	
	var HomePage = {};
	var oldView = undefined;
	
	function _init() {
		_initNav();
	}

	HomePage.start = function() {
		_init();
	};
	
	HomePage.renderUsers = function() {
		
		_insertView(Users.create());
		_changeActiveMenu($(".nav-list a")[0]);
	};

	HomePage.renderChocoVote = function() {
		
		_insertView(ChocoVote.create());
		_changeActiveMenu($(".nav-list a")[1]);
	};

	HomePage.renderOfficeStatistics = function() {

		_insertView(OfficeStatistics.create());
		_changeActiveMenu($(".nav-list a")[2]);
	};

	function _insertView(view) {
		if(LogManager.isLogged()) {
			_cleanWorkspace();
			oldView = view;
			view.appendTo("#workspace");
		}
	}

	function _cleanWorkspace() {
		
		if(oldView != undefined) {
			oldView.remove();
		}
	}

	function _changeActiveMenu(node) {
		
		$(".nav-list li").removeClass("active");
		$(node).parent("li").addClass("active");
		
	}
	
	/* event */
	function _initNav() {
		
		$(".nav-list a").click(function(event) {
			
			event.preventDefault(); // prevent the standard link click
			
			var state = $(this).attr("class");
			App.homeCtrl.stateChange(state);
		});
	};
	
	return HomePage;
});
