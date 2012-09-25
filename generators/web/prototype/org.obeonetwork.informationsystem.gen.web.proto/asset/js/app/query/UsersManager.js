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
 * @since 0.8
 */
define(["require", "app/ws/WsUser"], function(require) {
	
	/*__ Libs __*/
	var WsUser = require("app/ws/WsUser");
	/*__ Libs __*/
	
	UsersManager = {};

	UsersManager.async_all = function(cb_function) {
		
		var cb_users = function(users) {
			cb_function(users);
		};
		
		WsUser.all(cb_users);
	}
	
	UsersManager.async_allProxies = function(cb_function) {
		
		var cb_userProxies = function(userProxies) {
			cb_function(userProxies);
		};
		
		WsUser.allProxies(cb_userProxies);
	}

	UsersManager.async_countAll = function(cb_function) {
		
		var cb_countAllusers = function(count) {
			cb_function(count);
		};
		
		WsUser.countAllUsers(cb_countAllusers);
	}
	
	UsersManager.async_allByRows = function(cb_function, nbElemByRow, rowId) {
		
		var cb_allByRows = function(users) {
			cb_function(users);
		};
		
		WsUser.allByRows(cb_allByRows, nbElemByRow, rowId);
	}
	
	UsersManager.async_byId = function(cb_function, id) {
		
		var cb_user = function(user) {
			cb_function(user);
		};
		
		WsUser.user(cb_user, id);
	}
	
	return UsersManager;
});
