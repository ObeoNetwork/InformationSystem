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
 * @since 0.1
 */
define(["require", "app/App", "app/view/page/HomePage", "app/model/Proxy"], function(require) {

	/*__ Libs __*/
	var App = require("app/App");
	var HomePage = require("app/view/page/HomePage");
	var Proxy = require("app/model/Proxy");
	/*__ Libs __*/
	
	var HomeCtrl = {};
	
	var allowedStates = ["state-default", "state-users", "state-choco-vote", "state-office-statistics"];
	
	function _init() {

		window.onpopstate = function(event) {
			
			if(event.state == null || event.state == undefined) {
				HomeCtrl.stateChange();
			} else {
				HomeCtrl.stateChange(event.state.homeCtrl, true);
			}
		};
		HomePage.start();
	}

	HomeCtrl.start = function() {
		
		_init();
	};
	
	/*
	 * @param {String} the string Id of the state
	 * @return boolean true if it's a valid state
	 */
	HomeCtrl.stateChange = function(state, historyMode) {

		switch(state) {
			case allowedStates[2]:
				if(!historyMode) 
					window.history.pushState({homeCtrl: state});
				_toChocoVoteState();
				break;
				
			case allowedStates[3]:
				if(!historyMode) 
					window.history.pushState({homeCtrl: state});
				_toOfficeStatisticsState();
				break;
				
			default:
				if(!historyMode) 
					window.history.pushState({homeCtrl: allowedStates[1]});
				_toUsersState();
				break;
		}

	};
	
	/**/
	function _toUsersState() {
		
		HomePage.renderUsers();
	}
	
	/**/
	function _toChocoVoteState() {
		
		HomePage.renderChocoVote();
	}
	
	/**/
	function _toOfficeStatisticsState() {

		HomePage.renderOfficeStatistics();
	}
	
	/* events */
	
	/**/
	HomeCtrl.loadAllUsersInWidget = function(contentWidget) {
		
		App.users.async_allProxies(
			function(userProxies) { contentWidget.loadUsers(userProxies); }
		);
	};
	/**/
	HomeCtrl.loadAllChocosInWidget = function(contentWidget) {
		
		App.chocos.async_allProxies(
			function(chocoProxies) { contentWidget.loadChocos(chocoProxies); }
		);
	};
	/**/
	HomeCtrl.loadAllOfficesInWidget = function(contentWidget) {
		
		App.offices.async_allProxies(
			function(officeProxies) { contentWidget.loadOffices(officeProxies); }
		);
	};
	
	
	/**/
	HomeCtrl.loadUsersInWidget = function(contentWidget, paginationWidgets, activePage) {
		
		_async_loadContent(App.users, contentWidget, activePage);
		
		_async_loadPagination(App.users, paginationWidgets, activePage);
	};
	
	/**/
	HomeCtrl.loadChocosInWidget = function(contentWidget, paginationWidgets, activePage) {
		
		_async_loadContent(App.chocos, contentWidget, activePage);
		
		_async_loadPagination(App.chocos, paginationWidgets, activePage);
	};
	
	/**/
	HomeCtrl.loadOfficesInWidget = function(contentWidget, paginationWidgets, activePage) {
		
		_async_loadContent(App.offices, contentWidget, activePage);
		
		_async_loadPagination(App.offices, paginationWidgets, activePage);
	};
	
	/**/
	function _async_loadContent(appEntities, contentWidget, activePage) {
		
		if(activePage===undefined || activePage==null) {
			activePage = 0;
		}
		
		appEntities.async_allByRows(
			function(offices) { contentWidget.loadContent(offices); }, 5, activePage
		);
	}
	
	/**/
	function _async_loadPagination(appEntities, paginationWidgets, activePage) {
		
		if(paginationWidgets===undefined || paginationWidgets==null) {
			paginationWidgets = [];
		}
		if(activePage===undefined || activePage==null) {
			activePage = 0;
		}
		
		appEntities.async_countAll(
			function(count) {
				var pageProxies = [];
				for(var i = 0; i < count / 5; i++) {
					pageProxies[i] = Proxy.Class.create({
						id : i, desc : "" + (i + 1) + "", active : activePage==i
					});
				};
				for (var i=0; i < paginationWidgets.length; i++) {
				  paginationWidgets[i].loadContent(pageProxies);
				};
			}
		);
	}
	
	return HomeCtrl;
});
