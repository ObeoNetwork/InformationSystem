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
 /**
 * define a webservice API for the user entity.
 * we use JQuery REST API. In consequence, we are in an asynchrone context.
 * All functions must define a call back function that will run at the end
 * of the REST query.
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/model/User", "app/ws/WsUtil" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var User = require("app/model/User"),
		WsUtil = require("app/ws/WsUtil");
/** End of user code */

	
	var LsUser = {};

	LsUser.getStore = function() {
		return _getStore();
	};
	
	LsUser.setStore = function(store) {
		 _setStore(store);
	}
	
	LsUser.storeUsers = function(users) {
		var store = _getStore();
		for ( var i = 0; i < users.length; i++) {
			var user = users[i];
			user.set('localUpdate', false);
			user.set('localRemove', false);
			user.set('localAdd', false);
			store.users[user.id] = user;
		}
		_setStore(store);
	}
	
	LsUser.storeProxies = function(proxies) {
		var store = _getStore();
		for ( var i = 0; i < proxies.length; i++) {
			var proxy = proxies[i];
			store.proxies[i] = proxy;
		}
		_setStore(store);
	}
	
	LsUser.storeUserStats = function(userStats) {
		var store = _getStore();
		store.userStats = userStats;
		_setStore(store);
	}
	
	LsUser.storeUser = function(user) {
		var store = _getStore();
		user.set('localUpdate', false);
		user.set('localRemove', false);
		user.set('localAdd', false);
		store.users[user.id] = user;
		_setStore(store);
	}
	
	LsUser.removeUser = function(user) {
		var store = _getStore();
		store.users[user.id] = undefined;
		_setStore(store);
	}

	
	
	LsUser.localUpdateUser = function(user) {
		var store = _getStore();
		user.set('localUpdate', true);
		store.users[user.id] = user;
		store.local.usersToUpdate.push(user.id);
		_setStore(store);
	}
	
	LsUser.localStoreUser = function(user) {
		var store = _getStore();
		user.set('localAdd', true);
		store.local.usersToAdd.push(user);
		_setStore(store);
	}
	
	LsUser.localRemoveUser = function(user) {
		var store = _getStore();
		user.set('localRemove', true);
		store.users[user.id] = user;
		store.local.usersToRemove.push(user.id);
		_setStore(store);
	}
	
	function _getStore() {
		var storeBrut = localStorage.getItem("LsUser");
		if(typeof(storeBrut)!=="undefined" && storeBrut!==null ) {
			var store = JSON.parse(storeBrut);
			var usersBrut = store.users;
			var users = {};
			for ( var id in usersBrut) {
				var userBrut = usersBrut[id];
				users[id] = _object2EmberObject(userBrut);
			}
			store.users = users;
			
			for ( var i = 0; i < store.local.usersToAdd.length; i++) {
				store.local.usersToAdd[i] = _object2EmberObject(store.local.usersToAdd[i]);
			}

			//store.local.proxies = WsUtil.json2Proxies(store.local.proxies);
			//store.local.userStats = WsUtil.json2Stats(store.local.userStats);

			return store;
		} else {
			var emptyStore = {
				count : 0,
				users : {},
				proxies : [],
				userStats : [],
				local : {
					usersToAdd : [],
					usersToUpdate : [],
					usersToRemove : [],
				}
			};
			return emptyStore;
		}
	};
	
	function _setStore(store) {
		localStorage.setItem("LsUser", JSON.stringify(store));
	}

	function _object2EmberObject(object) {
		
		var user = User.Class.create({
									id : object.id,
									nickname : object.nickname,
									shortNickname : object.shortNickname,
									firstName : object.firstName,
									lastName : object.lastName,
									chocoProxies : object.chocoProxies,
									officeProxy : object.officeProxy,
									email : object.email,
									level : object.level,
									xp : object.xp,
									localUpdate : object.localUpdate,
									localRemove : object.localRemove,
									localAdd : object.localAdd
		});
		
		return user;
	}	
	
	/** Start of user code additional functions */
	/** End of user code */

	return LsUser;
});
