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

	UserManager.async_all = function(cb_function) {
		
		var cb_users = function(users) {
			/** Start of user code cb_users */
			cb_function(users);
			/** End of user code */
		};
		
		WsUser.all(cb_users);
	};

	UserManager.all = function(cb_function) {
		/** Start of user code default all */
		var store = LsUser.getStore();
		var users = store.users;
		cb_function(users);
		/** End of user code */
	};
	

	UserManager.async_allProxies = function(cb_function) {
		
		var cb_userProxies = function(userProxies) {
			/** Start of user code cb_userProxies */
			LsUser.storeProxies(userProxies);
			cb_function(userProxies);
			/** End of user code */
		};
		
		WsUser.allProxies(cb_userProxies);
	};

	UserManager.allProxies = function(cb_function) {
		/** Start of user code default allProxies */
		var store = LsUser.getStore();
		var proxies = store.proxies;
		cb_function(proxies);
		/** End of user code */
	};


	UserManager.async_countAll = function(cb_function) {
		
		var cb_countAllusers = function(count) {
			/** Start of user code cb_countAllusers */
			cb_function(count);
			/** End of user code */
		};
		
		WsUser.countAllUsers(cb_countAllusers);
	};

	UserManager.countAll = function(cb_function) {
		/** Start of user code default countAll */
		var store = LsUser.getStore();
		var count = 0;
	    for(var luser in store.lusers)
	    {
	        count++;
	    }
		cb_function(count)
		/** End of user code */
	};

	
	UserManager.async_allByRows = function(cb_function, nbElemByRow, rowId) {
		
		var cb_allByRows = function(users) {
			/** Start of user code cb_allByRows */
			LsUser.storeUsers(users);
			cb_function(users);
			/** End of user code */
			
		};
		
		WsUser.allByRows(cb_allByRows, nbElemByRow, rowId);
	};

	UserManager.allByRows = function(cb_function, nbElemByRow, rowId) {
		/** Start of user code default allByRows */
		var store = LsUser.getStore();
		var users = store.users;
		var usersToAdd = store.local.usersToAdd;
		
		var usersLength = usersToAdd.length;
	    for(var user in users) {
	    	usersLength++;
	    }
		var result = [];
		var from = Math.max(rowId*nbElemByRow, 0);
		var to = Math.min(rowId*nbElemByRow+nbElemByRow, usersLength);
		
		for ( var i = 0; i < usersToAdd.length; i++) {
			result.push(usersToAdd[i]);
		}
		
		var i = 0;
		for(var userId in users) {
			if(i >= from && i < to){
				result.push(users[userId]);
			}
			i++;
		}
		cb_function(result);
		/** End of user code */
	};
	

	UserManager.async_byId = function(cb_function, id) {
		
		var cb_user = function(user) {
			/** Start of user code cb_user */
			LsUser.storeUser(user);
			cb_function(user);
			/** End of user code */
		};
		
		WsUser.user(cb_user, id);
	};

	UserManager.byId = function(cb_function, id) {
		/** Start of user code default byId */
		/** End of user code */
	};


	UserManager.async_stats = function(cb_function) {
		
		var cb_userStats = function(users) {
			/** Start of user code cb_userStats */
			cb_function(users);
			/** End of user code */
		};
		
		WsUser.stats(cb_userStats);
	};

	UserManager.stats = function(cb_function) {
		/** Start of user code default stats */
		var store = LsUser.getStore();
		cb_function(store.userStats);
		/** End of user code */
	};

	// REMOVE
	UserManager.async_remove = function(cb_function, user) {
		
		var cb_remove = function() {
			LsUser.removeUser(user);
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
			LsUser.updateUser(user);
			cb_function();
		};
		var store = LsUser.getStore();
		var userStored = store.users[user.id];
		WsUser.update(cb_update, userStored);
	};

	UserManager.update = function(cb_function, user) {
		LsUser.localUpdateUser(user);
		cb_function();
	};
	
	
	// ADD
	UserManager.async_add = function(cb_function, user) {
		//TODO WArning bug?
		var cb_add = function() {
			LsUser.storeUser(user);
			cb_function();
		};
		var store = LsUser.getStore();
		var userStored = store.users[user.id];
		WsUser.add(cb_add, userStored);
	};

	UserManager.add = function(cb_function, user) {
		LsUser.localStoreUser(user);
		cb_function();
	};
	
	/** Start of user code additional functions */
	/** End of user code */

	return UserManager;
});
