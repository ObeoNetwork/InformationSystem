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
define(["require", "app/App", "app/security/LogManager", "app/view/page/CommonPage", "app/model/Proxy" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var App = require("app/App"),
		LogManager = require("app/security/LogManager"),
		CommonPage = require("app/view/page/CommonPage"),
		Proxy = require("app/model/Proxy");
/** End of user code */

	
	var CommonCtrl = {};
	
	var allowedStates = ["state-default", "state-in-login", "state-user", "state-moderator", "state-admin"];
	var host = "http://"+window.location.host;
	var defaultNumRows = 5;
	function _init() {
			
		if(LogManager.isLogged()) {
			if(LogManager.isAdmin()) {
				CommonCtrl.stateChange(allowedStates[4]);
			} else if(LogManager.isModerator()) {
				CommonCtrl.stateChange(allowedStates[3]);
			} else {
				CommonCtrl.stateChange(allowedStates[2]);
			}
		} else {
			if(LogManager.inLoginProcess()) {
				CommonCtrl.stateChange(allowedStates[1]);
			} else {
				CommonCtrl.stateChange(allowedStates[0]);
			}
		}
		CommonPage.start();
		if(navigator.onLine) {
			CommonPage.renderOnline();
		} else {
			CommonPage.renderOffline();
		}
	}

	CommonCtrl.start = function() {
		_init();
	};
	
	/*
	 * @param {String} the string Id of the state
	 * @return boolean true if it's a valid state
	 */
	CommonCtrl.stateChange = function(state) {
	
		switch(state) {
			case allowedStates[1]:
				_toInLoginState();
				break;
				
			case allowedStates[2]:
				_toUserState();
				break;
				
			case allowedStates[3]:
				_toModeratorState();
				break;
				
			case allowedStates[4]:
				_toAdminState();
				break;
				
			default:
				_toDefaultState();
				break;
		}

	};
	
	/**/
	CommonCtrl.hideModal = function() {
		
		CommonPage.hideModal();
	};
	
	/**/
	CommonCtrl.signOut = function() {
		
		LogManager.logOff();
		_reloadPage();
	};
	
	/* events */
	/**/
	CommonCtrl.removeChoco = function(choco) {
		if(navigator.onLine) {
			App.ChocoManager.async_remove(
				function() { },
				choco
			);
		} else {
			App.ChocoManager.remove(
				function() { },
				choco
			);
		}
	};
	CommonCtrl.updateChoco = function(choco) {
		if(navigator.onLine) {
			App.ChocoManager.async_update(
				function() { },
				choco
			);
		} else {
			App.ChocoManager.update(
				function() { },
				choco
			);
		}
	};
	CommonCtrl.addChoco = function(choco) {
		if(navigator.onLine) {
			App.ChocoManager.async_add(
				function() { },
				choco
			);
		} else {
			App.ChocoManager.add(
				function() { },
				choco
			);
		}
	};
	CommonCtrl.showModalChoco = function(id) {
		App.ChocoManager.async_byId(function(choco) {
			CommonPage.showModalChoco(choco);
		}, id);
	};
	CommonCtrl.editChoco = function(choco) {
		App.UserManager.async_allProxies(function(userProxies) {
			/* <async block start> (User context) 
			 */
			for (var i = 0; i < userProxies.length; i++) {
				var userProxy = userProxies[i];
			
				if (choco.userProxy.id === userProxy.id) {
					choco.set("userProxy", userProxy);
					break;
				}
			}
		
			CommonPage.showEditModalChoco(choco, userProxies);
			/* 
			 * <async block stop> (User context) */
		});
	};

	/**/
	CommonCtrl.removeUser = function(user) {
		if(navigator.onLine) {
			App.UserManager.async_remove(
				function() { },
				user
			);
		} else {
			App.UserManager.remove(
				function() { },
				user
			);
		}
	};
	CommonCtrl.updateUser = function(user) {
		if(navigator.onLine) {
			App.UserManager.async_update(
				function() { },
				user
			);
		} else {
			App.UserManager.update(
				function() { },
				user
			);
		}
	};
	CommonCtrl.addUser = function(user) {
		if(navigator.onLine) {
			App.UserManager.async_add(
				function() { },
				user
			);
		} else {
			App.UserManager.add(
				function() { },
				user
			);
		}
	};
	CommonCtrl.showModalUser = function(id) {
		App.UserManager.async_byId(function(user) {
			CommonPage.showModalUser(user);
		}, id);
	};
	CommonCtrl.editUser = function(user) {
		App.ChocoManager.async_allProxies(function(chocoProxies) {
			/* <async block start> (Choco context) 
			 */
			var oldChocoProxies = user.get("chocoProxies");
			var linkedChocoProxies = [];
			
			for (var i = 0; i < chocoProxies.length; i++) {
				for (var j = 0; j < oldChocoProxies.length; j++) {
			
					if (chocoProxies[i].id === oldChocoProxies[j].id) {
						linkedChocoProxies.push(chocoProxies[i]);
						break;
					}
				}
			}
			user.set("chocoProxies", linkedChocoProxies);
			
		
			App.OfficeManager.async_allProxies(function(officeProxies) {
				/* <async block start> (Office context) 
				 */
				for (var i = 0; i < officeProxies.length; i++) {
					var officeProxy = officeProxies[i];
				
					if (user.officeProxy.id === officeProxy.id) {
						user.set("officeProxy", officeProxy);
						break;
					}
				}
			
				CommonPage.showEditModalUser(user, chocoProxies, officeProxies);
				/* 
				 * <async block stop> (Office context) */
			});
			/* 
			 * <async block stop> (Choco context) */
		});
	};

	/**/
	CommonCtrl.removeOffice = function(office) {
		if(navigator.onLine) {
			App.OfficeManager.async_remove(
				function() { },
				office
			);
		} else {
			App.OfficeManager.remove(
				function() { },
				office
			);
		}
	};
	CommonCtrl.updateOffice = function(office) {
		if(navigator.onLine) {
			App.OfficeManager.async_update(
				function() { },
				office
			);
		} else {
			App.OfficeManager.update(
				function() { },
				office
			);
		}
	};
	CommonCtrl.addOffice = function(office) {
		if(navigator.onLine) {
			App.OfficeManager.async_add(
				function() { },
				office
			);
		} else {
			App.OfficeManager.add(
				function() { },
				office
			);
		}
	};
	CommonCtrl.showModalOffice = function(id) {
		App.OfficeManager.async_byId(function(office) {
			CommonPage.showModalOffice(office);
		}, id);
	};
	CommonCtrl.editOffice = function(office) {
		CommonPage.showEditModalOffice(office);
	};


	CommonCtrl.rerenderWidgetContainer = function(widgetContainer) {
		var childViews = widgetContainer.get('childViews');
		for(var i = 0; i<childViews.length; i++) {
			childViews[i].rerender();
		}
	};

	
	/**/
	CommonCtrl.loadAllChocosInWidget = function(contentWidget) {
		if(navigator.onLine) {
			App.ChocoManager.async_allProxies(
				function(chocoProxies) { contentWidget.loadChocoProxies(chocoProxies); }
			);
		} else {
			App.ChocoManager.allProxies(
				function(chocoProxies) { contentWidget.loadChocoProxies(chocoProxies); }
			);
		}
	};

	CommonCtrl.loadChocosInWidget = function(listWidget, activePage) {
		_async_loadContent(App.ChocoManager, listWidget, activePage);
		var i = 0;
		for(i; i<listWidget.paginationWidgets.length; i++){
			_async_loadPagination(App.ChocoManager, listWidget.paginationWidgets[i], activePage);
		}
	};

	CommonCtrl.loadChocoStatsInWidget = function(contentWidget) {
		_async_loadStat(App.ChocoManager, contentWidget);
	};
	
	/**/
	CommonCtrl.loadAllUsersInWidget = function(contentWidget) {
		if(navigator.onLine) {
			App.UserManager.async_allProxies(
				function(userProxies) { contentWidget.loadUserProxies(userProxies); }
			);
		} else {
			App.UserManager.allProxies(
				function(userProxies) { contentWidget.loadUserProxies(userProxies); }
			);
		}
	};

	CommonCtrl.loadUsersInWidget = function(listWidget, activePage) {
		_async_loadContent(App.UserManager, listWidget, activePage);
		var i = 0;
		for(i; i<listWidget.paginationWidgets.length; i++){
			_async_loadPagination(App.UserManager, listWidget.paginationWidgets[i], activePage);
		}
	};

	CommonCtrl.loadUserStatsInWidget = function(contentWidget) {
		_async_loadStat(App.UserManager, contentWidget);
	};
	
	/**/
	CommonCtrl.loadAllOfficesInWidget = function(contentWidget) {
		if(navigator.onLine) {
			App.OfficeManager.async_allProxies(
				function(officeProxies) { contentWidget.loadOfficeProxies(officeProxies); }
			);
		} else {
			App.OfficeManager.allProxies(
				function(officeProxies) { contentWidget.loadOfficeProxies(officeProxies); }
			);
		}
	};

	CommonCtrl.loadOfficesInWidget = function(listWidget, activePage) {
		_async_loadContent(App.OfficeManager, listWidget, activePage);
		var i = 0;
		for(i; i<listWidget.paginationWidgets.length; i++){
			_async_loadPagination(App.OfficeManager, listWidget.paginationWidgets[i], activePage);
		}
	};

	CommonCtrl.loadOfficeStatsInWidget = function(contentWidget) {
		_async_loadStat(App.OfficeManager, contentWidget);
	};
	

	CommonCtrl.toOnline = function() {
		CommonPage.renderOnline();
		App.ChocoManager.toOnlineProcess();
		App.UserManager.toOnlineProcess();
		App.OfficeManager.toOnlineProcess();
	};
	
	CommonCtrl.toOffline = function() {
		CommonPage.renderOffline();
	};



	function _async_loadContent(objectManager, listWidget, activePage) {
		if(activePage===undefined || activePage==null) {
			activePage = 0;
		}

		if(navigator.onLine) {
			objectManager.async_allByRows(
				function(objects) { listWidget.loadContent(objects); }, defaultNumRows, activePage
			);
		} else {
			objectManager.allByRows(
				function(objects) { listWidget.loadContent(objects); }, defaultNumRows, activePage
			);
		}
	}

	function _async_loadStat(objectManager, contentWidget) {
		if(navigator.onLine) {
			objectManager.async_stats(
				function(stats) { contentWidget.loadContent(stats); }
			);
		} else {
			objectManager.stats(
				function(stats) { contentWidget.loadContent(stats); }
			);
		}
	}
	
	/**/
	function _async_loadPagination(objectManager, paginationWidget, activePage) {
		if(navigator.onLine) {
			objectManager.async_countAll(
				function(count) {
					var pageProxies = [];
					var max = (count / defaultNumRows);
					for(var i = 0; i < max; i++) {
						pageProxies[i] = Proxy.Class.create({
							id : i, desc : "" + (i + 1) + "", active : activePage==i
						});
					};
					
					paginationWidget.loadContent(pageProxies);
				}
			);
		} else {
			objectManager.countAll(
					function(count) {
						var pageProxies = [];
						var max = (count / defaultNumRows);
						for(var i = 0; i < max; i++) {
							pageProxies[i] = Proxy.Class.create({
								id : i, desc : "" + (i + 1) + "", active : activePage==i
							});
						};
						
						paginationWidget.loadContent(pageProxies);
					}
				);
		}
	}

	/**/
	function _reloadPage() {
		
		window.location.replace(host);
	}
	
	/**/
	function _toDefaultState() {
		
		CommonPage.renderDefault();
	}
	
	/**/
	function _toInLoginState() {
		
		LogManager.tokenQuery();
		_reloadPage();
	}
	
	/**/
	function _toUserState() {
		
		CommonPage.renderUserFeatures();
	}
	
	/**/
	function _toModeratorState() {
		
		CommonPage.renderModeratorFeatures();
	}
	
	/**/
	function _toAdminState() {
		
		CommonPage.renderAdminFeatures();
	}
	
	/** Start of user code additional functions */
	/** End of user code */

	return CommonCtrl;
});
