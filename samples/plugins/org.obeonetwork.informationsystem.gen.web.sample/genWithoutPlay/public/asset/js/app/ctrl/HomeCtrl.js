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
define(["require", "app/App", "app/view/page/HomePage" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var App = require("app/App"),
		HomePage = require("app/view/page/HomePage");
/** End of user code */

	var HomeCtrl = {};
	
	var allowedStates = ["default", "users", "choco-vote", "office-statistics"];
	
	function _init() {

		HomePage.start();
		HomeCtrl.stateChange();
	}

	HomeCtrl.start = function() {
		
		_init();
	};

	HomeCtrl.stop = function() {
		
		HomePage.stop();
	};

	HomeCtrl.refresh = function() {
		
		HomePage.refresh();
	};
	
	/*
	 * @param {String} the string Id of the state
	 * @return boolean true if it's a valid state
	 */
	HomeCtrl.stateChange = function(state, historyMode) {

		switch(state) {
			case allowedStates[2]:
				_toChocoVoteState();
				break;
			
			case allowedStates[3]:
				_toOfficeStatisticsState();
				break;
			
			default:
				_toUsersState();
				break;
		}

	};
	
	/**/
	function _toUsersState() {
		
		HomePage.renderUsers();
		HomePage.changeActiveMenu(allowedStates[1]);
	}
	/**/
	function _toChocoVoteState() {
		
		HomePage.renderChocoVote();
		HomePage.changeActiveMenu(allowedStates[2]);
	}
	/**/
	function _toOfficeStatisticsState() {
		
		HomePage.renderOfficeStatistics();
		HomePage.changeActiveMenu(allowedStates[3]);
	}
	
	/** Start of user code additional functions */
	/** End of user code */

	return HomeCtrl;
});
