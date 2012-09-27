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
			cb_function(Users);
		};
		
		WsUser.all(cb_Users);
	};
	
	UserManager.async_allProxies = function(cb_function) {
		
		var cb_userProxies = function(userProxies) {
			cb_function(userProxies);
		};
		
		WsUser.allProxies(cb_userProxies);
	};

	UserManager.async_countAll = function(cb_function) {
		
		var cb_countAllUsers = function(count) {
			cb_function(count);
		};
		
		WsUser.countAllUsers(cb_countAllUsers);
	};
	
	UserManager.async_allByRows = function(cb_function, nbElemByRow, rowId) {
		
		var cb_allByRows = function(Users) {
			cb_function(Users);
		};
		
		WsUser.allByRows(cb_allByRows, nbElemByRow, rowId);
	};
	
	UserManager.async_byId = function(cb_function, id) {
		
		var cb_user = function(user) {
			cb_function(user);
		};
		
		WsUser.user(cb_user, id);
	};

	UserManager.async_stats = function(cb_function) {
		
		var cb_userStats = function(user) {
			cb_function(user);
		};
		
		WsUser.stats(cb_userStats);
	};
	
	/** Start of user code additional functions */
	/** End of user code */

	return UserManager;
});
