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
		//TODO
		App.toast.warning("Server remove not implemented yet. Sorry!");
	};
	CommonCtrl.updateChoco = function(choco) {
		//TODO
		App.toast.warning("Server edit not implemented yet. Sorry!");
	};
	CommonCtrl.addChoco = function(choco) {
		//TODO
		App.toast.warning("Server add not implemented yet. Sorry!");
	};
	CommonCtrl.showModalChoco = function(id) {
		/** Start of user code showModalChoco */
		App.ChocoManager.async_byId(function(choco) {
			CommonPage.showModalChoco(choco);
		}, id);
		/** End of user code */
	};
	CommonCtrl.editChoco = function(choco) {
		/** Start of user code editChoco */
		if(navigator.onLine) {
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
		} else {
			// TODO something
		}
		/** End of user code */
	};

	/**/
	CommonCtrl.removeUser = function(user) {
		//TODO
		App.toast.warning("Server remove not implemented yet. Sorry!");
	};
	CommonCtrl.updateUser = function(user) {
		//TODO
		App.toast.warning("Server edit not implemented yet. Sorry!");
	};
	CommonCtrl.addUser = function(user) {
		//TODO
		App.toast.warning("Server add not implemented yet. Sorry!");
	};
	CommonCtrl.showModalUser = function(id) {
		/** Start of user code showModalUser */
		App.UserManager.async_byId(function(user) {
			CommonPage.showModalUser(user);
		}, id);
		/** End of user code */
	};
	CommonCtrl.editUser = function(user) {
		/** Start of user code editUser */
		if(navigator.onLine) {
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
		} else {
			// TODO something
		}
		/** End of user code */
	};

	/**/
	CommonCtrl.removeOffice = function(office) {
		//TODO
		App.toast.warning("Server remove not implemented yet. Sorry!");
	};
	CommonCtrl.updateOffice = function(office) {
		//TODO
		App.toast.warning("Server edit not implemented yet. Sorry!");
	};
	CommonCtrl.addOffice = function(office) {
		//TODO
		App.toast.warning("Server add not implemented yet. Sorry!");
	};
	CommonCtrl.showModalOffice = function(id) {
		/** Start of user code showModalOffice */
		if(navigator.onLine) {
			App.OfficeManager.async_byId(function(office) {
				CommonPage.showModalOffice(office);
			}, id);
		} else {
			// TODO something
		}
		/** End of user code */
	};
	CommonCtrl.editOffice = function(office) {
		/** Start of user code editOffice */
		CommonPage.showEditModalOffice(office);
		/** End of user code */
	};


	
	/**/
	CommonCtrl.loadAllChocosInWidget = function(contentWidget) {
		/** Start of user code loadAllChocosInWidget */
		if(navigator.onLine) {
			App.ChocoManager.async_allProxies(
				function(chocoProxies) { contentWidget.loadChocoProxies(chocoProxies); }
			);
		} else {
			// TODO something
		}
		/** End of user code */
	};

	CommonCtrl.loadChocosInWidget = function(contentWidget, paginationWidgets, activePage) {
		_async_loadContent(App.ChocoManager, contentWidget, activePage);
		_async_loadPagination(App.ChocoManager, paginationWidgets, activePage);
	};

	CommonCtrl.loadChocoStatsInWidget = function(contentWidget) {
		_async_loadStat(App.ChocoManager, contentWidget);
	};
	
	/**/
	CommonCtrl.loadAllUsersInWidget = function(contentWidget) {
		/** Start of user code loadAllUsersInWidget */
		if(navigator.onLine) {
			App.UserManager.async_allProxies(
				function(userProxies) { contentWidget.loadUserProxies(userProxies); }
			);
		} else {
			// TODO something
		}
		/** End of user code */
	};

	CommonCtrl.loadUsersInWidget = function(contentWidget, paginationWidgets, activePage) {
		_async_loadContent(App.UserManager, contentWidget, activePage);
		_async_loadPagination(App.UserManager, paginationWidgets, activePage);
	};

	CommonCtrl.loadUserStatsInWidget = function(contentWidget) {
		_async_loadStat(App.UserManager, contentWidget);
	};
	
	/**/
	CommonCtrl.loadAllOfficesInWidget = function(contentWidget) {
		/** Start of user code loadAllOfficesInWidget */
		if(navigator.onLine) {
			App.OfficeManager.async_allProxies(
				function(officeProxies) { contentWidget.loadOfficeProxies(officeProxies); }
			);
		} else {
			App.OfficeManager.allProxies(
					function(officeProxies) { contentWidget.loadOfficeProxies(officeProxies); }
				);
		}
		/** End of user code */
	};

	CommonCtrl.loadOfficesInWidget = function(contentWidget, paginationWidgets, activePage) {
		_async_loadContent(App.OfficeManager, contentWidget, activePage);
		_async_loadPagination(App.OfficeManager, paginationWidgets, activePage);
	};

	CommonCtrl.loadOfficeStatsInWidget = function(contentWidget) {
		_async_loadStat(App.OfficeManager, contentWidget);
	};
	





	function _async_loadContent(objectManager, contentWidget, activePage) {
		/** Start of user code default _async_loadContent*/
		if(activePage===undefined || activePage==null) {
			activePage = 0;
		}
		
		if(navigator.onLine) {
			objectManager.async_allByRows(
				function(offices) { contentWidget.loadContent(offices); }, 5, activePage
			);
		} else {
			objectManager.allByRows(
					function(offices) { contentWidget.loadContent(offices); }, 5, activePage
				);
		}
		/** End of user code */
	}

	function _async_loadStat(objectManager, contentWidget) {
		/** Start of user code default _async_loadStat*/
		if(navigator.onLine) {
			objectManager.async_stats(
				function(stats) { contentWidget.loadContent(stats); }
			);
		} else {
			// TODO something
		}
		/** End of user code */
	}
	
	/**/
	function _async_loadPagination(objectManager, paginationWidgets, activePage) {
		/** Start of user code default _async_loadPagination */
		if(paginationWidgets===undefined || paginationWidgets==null) {
			paginationWidgets = [];
		}
		if(activePage===undefined || activePage==null) {
			activePage = 0;
		}
		if(navigator.onLine) {
			objectManager.async_countAll(
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
		} else {
			// TODO something
		}
		/** End of user code */
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
	CommonCtrl.toOnline = function() {
		CommonPage.renderOnline();
	};
	
	CommonCtrl.toOffline = function() {
		CommonPage.renderOffline();
	};
	/** End of user code */

	return CommonCtrl;
});
