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
 * @since 0.8.0
 * @generated
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/ws/WsUser", "app/ls/LsUser" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var WsUser = require("app/ws/WsUser"),
		LsUser = require("app/ls/LsUser");
/** End of user code */


	var UserManager = {},
		lsEnable = (typeof(Storage)!=="undefined");

	UserManager.toOnlineProcess = function() {
		var store = LsUser.getStore();
		var usersToAdd = store.local.usersToAdd;
		for(var i=0; i<usersToAdd.length; i++) {
			UserManager.async_add(function(){}, usersToAdd[i]);
		}

		var users = store.users;
		var usersToRemove = store.local.usersToRemove;
		var usersToUpdate = store.local.usersToUpdate;

		for(var i=0; i<usersToRemove.length; i++) {
			var id = usersToRemove[i];
			UserManager.async_remove(function(){}, users[id]);
		}

		for(var i=0; i<usersToUpdate.length; i++) {
			var id = usersToUpdate[i];
			UserManager.async_update(function(){}, users[id]);
		}
	};

	UserManager.async_all = function(cb_function) {
		
		var cb_users = function(users) {
			cb_function(users);
		};
		
		WsUser.all(cb_users);
	};

	UserManager.all = function(cb_function) {
		var store = LsUser.getStore();
		var users = store.users;
		cb_function(users);
	};
	

	UserManager.async_allProxies = function(cb_function) {
		
		var cb_userProxies = function(userProxies) {
			LsUser.storeProxies(userProxies);
			cb_function(userProxies);
		};
		
		WsUser.allProxies(cb_userProxies);
	};

	UserManager.allProxies = function(cb_function) {
		var store = LsUser.getStore();
		var proxies = store.proxies;
		cb_function(proxies);
	};


	UserManager.async_countAll = function(cb_function) {
		
		var cb_countAllusers = function(count) {
			cb_function(count);
		};
		
		WsUser.countAllUsers(cb_countAllusers);
	};

	UserManager.countAll = function(cb_function) {
		var store = LsUser.getStore();
		var count = store.local.usersToAdd.length;
	    for(var user in store.users)
	    {
	        count++;
	    }
		cb_function(count)
	};

	
	UserManager.async_allByRows = function(cb_function, nbElemByRow, rowId) {
		
		var cb_allByRows = function(users) {
			LsUser.storeUsers(users);
			cb_function(users);
			
		};
		
		WsUser.allByRows(cb_allByRows, nbElemByRow, rowId);
	};

	UserManager.allByRows = function(cb_function, nbElemByRow, rowId) {
		var store = LsUser.getStore();
		var users = store.users;
		var usersToAdd = store.local.usersToAdd;
		
		for ( var i = 0; i < usersToAdd.length; i++) {
			users["_"+i] = usersToAdd[i];
		}

		var usersLength = 0;
	    for(var user in users) {
	    	usersLength++;
	    }
		var result = [];
		var from = Math.max(rowId*nbElemByRow, 0);
		var to = Math.min(rowId*nbElemByRow+nbElemByRow, usersLength);
		
		var i = 0;
		for(var userId in users) {
			if(i >= from && i < to){
				result.push(users[userId]);
			}
			i++;
		}
		cb_function(result);
	};
	

	UserManager.async_byId = function(cb_function, id) {
		
		var cb_user = function(user) {
			LsUser.storeUser(user);
			cb_function(user);
		};
		
		WsUser.user(cb_user, id);
	};

	UserManager.byId = function(cb_function, id) {
		/** Start of user code default byId */
		/** End of user code */
	};


	UserManager.async_stats = function(cb_function) {
		
		var cb_userStats = function(stats) {
			LsUser.storeUserStats(stats);
			cb_function(stats);
		};
		
		WsUser.stats(cb_userStats);
	};

	UserManager.stats = function(cb_function) {
		var store = LsUser.getStore();
		cb_function(store.userStats);
	};

	// REMOVE
	UserManager.async_remove = function(cb_function, user) {
		
		var cb_remove = function() {
			//LsUser.removeUser(user);
			cb_function();
		};
		var store = LsUser.getStore();
		var userStored = store.users[user.id];
		WsUser.remove(cb_remove, userStored);
	};

	UserManager.remove = function(cb_function, user) {
		LsUser.localRemoveUser(user);
		cb_function();
	};
	
	// UPDATE
	UserManager.async_update = function(cb_function, user) {
		
		var cb_update = function() {
			//LsUser.updateUser(user);
			cb_function();
		};
		//var store = LsUser.getStore();
		//var userStored = store.users[user.id];
		WsUser.update(cb_update, user);
	};

	UserManager.update = function(cb_function, user) {
		LsUser.localUpdateUser(user);
		cb_function();
	};
	
	
	// ADD
	UserManager.async_add = function(cb_function, user) {
		var cb_add = function() {
			//LsUser.storeUser(user);
			cb_function();
		};
		//var store = LsUser.getStore();
		//var userStored = store.users[user.id];
		WsUser.add(cb_add, user);
	};

	UserManager.add = function(cb_function, user) {
		LsUser.localStoreUser(user);
		cb_function();
	};
	
	/** Start of user code additional functions */
	/** End of user code */

	return UserManager;
});
