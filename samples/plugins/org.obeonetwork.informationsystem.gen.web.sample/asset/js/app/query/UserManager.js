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
define(["require", "app/ws/WsUser" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var WsUser = require("app/ws/WsUser");
/** End of user code */


	var UserManager = {};

	UserManager.async_all = function(cb_function) {
		
		var cb_Users = function(Users) {
			/** Start of user code cb_Users */
			cb_function(Users);
			/** End of user code */
		};
		
		WsUser.all(cb_Users);
	};

	UserManager.all = function(cb_function) {
		/** Start of user code default all */
		/** End of user code */
	};
	

	UserManager.async_allProxies = function(cb_function) {
		
		var cb_userProxies = function(userProxies) {
			/** Start of user code cb_userProxies */
			cb_function(userProxies);
			/** End of user code */
		};
		
		WsUser.allProxies(cb_userProxies);
	};

	UserManager.allProxies = function(cb_function) {
		/** Start of user code default allProxies */
		/** End of user code */
	};


	UserManager.async_countAll = function(cb_function) {
		
		var cb_countAllUsers = function(count) {
			/** Start of user code cb_countAllUsers */
			cb_function(count);
			/** End of user code */
		};
		
		WsUser.countAllUsers(cb_countAllUsers);
	};

	UserManager.countAll = function(cb_function) {
		/** Start of user code default countAll */
		/** End of user code */
	};

	
	UserManager.async_allByRows = function(cb_function, nbElemByRow, rowId) {
		
		var cb_allByRows = function(Users) {
			/** Start of user code cb_allByRows */
			cb_function(Users);
			/** End of user code */
			
		};
		
		WsUser.allByRows(cb_allByRows, nbElemByRow, rowId);
	};

	UserManager.allByRows = function(cb_function, nbElemByRow, rowId) {
		/** Start of user code default allByRows */
		/** End of user code */
	};
	

	UserManager.async_byId = function(cb_function, id) {
		
		var cb_user = function(user) {
			/** Start of user code cb_user */
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
		
		var cb_userStats = function(Users) {
			/** Start of user code cb_userStats */
			cb_function(Users);
			/** End of user code */
		};
		
		WsUser.stats(cb_userStats);
	};

	UserManager.stats = function(cb_function) {
		/** Start of user code default stats */
		/** End of user code */
	};
	
	/** Start of user code additional functions */
	/** End of user code */

	return UserManager;
});
