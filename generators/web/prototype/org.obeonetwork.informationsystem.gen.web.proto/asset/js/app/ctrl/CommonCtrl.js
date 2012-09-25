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
define(["require", "app/App", "app/security/LogManager", "app/view/page/CommonPage"], function(require) {

	/*__ Libs __*/
	var App = require("app/App");
	var LogManager = require("app/security/LogManager");
	var CommonPage = require("app/view/page/CommonPage");
	/*__ Libs __*/
	
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
	
	/* events */
	/**/
	CommonCtrl.removeChoco = function(choco) {
		//TODO
		App.toast.warning("Server remove not implemented yet. Sorry!");
	}
	CommonCtrl.updateChoco = function(choco) {
		//TODO
		App.toast.warning("Server edit not implemented yet. Sorry!");
	}
	CommonCtrl.addChoco = function(choco) {
		//TODO
		App.toast.warning("Server add not implemented yet. Sorry!");
	}
	CommonCtrl.editChoco = function(choco) {

		App.users.async_allProxies( function(userProxies) { 
			
			for (var i=0; i < userProxies.length; i++) {
				var userProxy = userProxies[i];
				
				if(choco.userProxy.id === userProxy.id) {
			  		choco.set("userProxy", userProxy);
			  		break;
				}
				
			}
			CommonPage.showEditModalChoco(choco, userProxies);
		});
	};
	CommonCtrl.showModalChoco = function(id) {
		
		App.chocos.async_byId(function(choco) {
			CommonPage.showModalChoco(choco);
		}, id);
	};
	
	/**/
	CommonCtrl.removeUser = function(user) {
		//TODO
		App.toast.warning("Server remove not implemented yet. Sorry!");
	}
	CommonCtrl.updateUser = function(user) {
		//TODO
		App.toast.warning("Server edit not implemented yet. Sorry!");
	}
	CommonCtrl.addUser = function(user) {
		//TODO
		App.toast.warning("Server add not implemented yet. Sorry!");
	}
	CommonCtrl.showModalUser = function(id) {
		
		App.users.async_byId(function(user) {
			CommonPage.showModalUser(user);
		}, id);
	};
	CommonCtrl.editUser = function(user) {
		

		App.chocos.async_allProxies(function(chocoProxies) {

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

			App.offices.async_allProxies(function(officeProxies) {

				for (var i = 0; i < officeProxies.length; i++) {
					var officeProxy = officeProxies[i];

					if (user.officeProxy.id === officeProxy.id) {
						user.set("officeProxy", officeProxy);
						break;
					}

				}
				
				CommonPage.showEditModalUser(user, chocoProxies, officeProxies);
			});

			
		}); 
	};
	
	/**/
	CommonCtrl.removeOffice = function(choco) {
		//TODO
		App.toast.warning("Server remove not implemented yet. Sorry!");
	}
	CommonCtrl.updateOffice = function(choco) {
		//TODO
		App.toast.warning("Server edit not implemented yet. Sorry!");
	}
	CommonCtrl.addOffice = function(choco) {
		//TODO
		App.toast.warning("Server add not implemented yet. Sorry!");
	}
	CommonCtrl.showModalOffice = function(id) {
		
		App.offices.async_byId(function(office) {
			CommonPage.showModalOffice(office);
		}, id);
	};
	CommonCtrl.editOffice = function(office) {
		
		CommonPage.showEditModalOffice(office);
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
	
	/**/
	function _reloadPage() {
		
		window.location.replace(host);
	}
	
	return CommonCtrl;
});
