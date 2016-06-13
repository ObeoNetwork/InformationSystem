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
define(["require", "app/ws/WsUtil", "app/model/User" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var WsUtil = require("app/ws/WsUtil"),
		User = require("app/model/User");
/** End of user code */

	
	var WsUser = {};

	/*
	 * get all users model.
	 * @param {function(model.User[])} the function throw at the end of 
	 * the asynchrone query.
	 * @return {model.User[]} all users
	 */
	WsUser.all = function(cb_function) {

		var users = [];
		
		var url = WsUtil.baseUrl() + "/user/list";
		var data = null;
		var cb_success = function(resultData) {

			for(var i = 0; i < resultData.length; i++) {
				var user = _json2User(resultData[i]);
				users[i] = user;
			}
			cb_function(users);
		};
		var cb_error = function() { 
			cb_function([]);
		};
		WsUtil.getJsonQuery(url, data, cb_success, cb_error);
	};

	WsUser.allProxies = function(cb_function) {

		var userProxies = [];

		var url = WsUtil.baseUrl() + "/user/list-proxy";
		var data = null;
		var cb_success = function(resultData) {

			for(var i = 0; i < resultData.length; i++) {
				var userProxy = WsUtil.json2Proxy(resultData[i]);
				userProxies[i] = userProxy;
			}
			cb_function(userProxies);
		};
		var cb_error = function() { 
			cb_function([]);
		};
		WsUtil.getJsonQuery(url, data, cb_success, cb_error);
	};
	
	WsUser.allByRows = function(cb_function, nbElemByRow, rowId) {

		if(nbElemByRow<0) {
			WsUser.all(cb_function);
		} else {
			var users = [];

			var url = WsUtil.baseUrl() + "/user/rows/"+rowId+"/"+nbElemByRow;
			var data = null;
			// data = {nbElemByRow : nbElemByRow};
			var cb_success = function(resultData) {
				for(var i = 0; i < resultData.length; i++) {
					var user = _json2User(resultData[i]);
					users[i] = user;
				}
				cb_function(users);
			};
			var cb_error = function() { 
				cb_function([]);
			};
			WsUtil.getJsonQuery(url, data, cb_success, cb_error);
		}
	};
	
	
	WsUser.countAllUsers = function(cb_function) {

		var count = 0;

		var url = WsUtil.baseUrl() + "/user/list-count";
		var data = null;
		var cb_success = function(resultData) {

			cb_function(resultData);
			
		};
		var cb_error = function() { 
			cb_function(0);
		};
		WsUtil.getJsonQuery(url, data, cb_success, cb_error);
	};
	
	/*
	 * get an user model by Id
	 * @param {function(model.User)} the function throw at the end 
	 * of the asynchrone query.
	 * @param {long} the user Id.
	 * @return {model.User} the object
	 */
	WsUser.user = function(cb_function, id) {

		var url = WsUtil.baseUrl() + "/user/get/" + id;
		var data = null;
		var cb_success = function(resultData) {

			var user = _json2User(resultData);
			cb_function(user);
		};
		var cb_error = function() { 
			cb_function(null);
		};
		WsUtil.getJsonQuery(url, data, cb_success, cb_error);
	};

	// sample of stats query
	WsUser.stats = function(cb_function) {

		var stats = [];

		var url = WsUtil.baseUrl() + "/user/stats";
		var data = null;
		var cb_success = function(resultData) {

			for(var i = 0; i < resultData.length; i++) {
				var stat = WsUtil.json2Stat(resultData[i]);
				stats[i] = stat;
			}
			cb_function(stats);
		};
		var cb_error = function() { 
			cb_function([]);
		};
		WsUtil.getJsonQuery(url, data, cb_success, cb_error);
	};

	WsUser.remove = function(cb_function, user) {

		var url = WsUtil.baseUrl() + "/user/remove/"+user.id;
		var data = null;
		var cb_success = function(resultData) {

			cb_function(user);
		};
		var cb_error = function() { 
			cb_function();
		};
		WsUtil.getJsonQuery(url, data, cb_success, cb_error);
	};
	
	WsUser.update = function(cb_function, user) {

		var url = WsUtil.baseUrl() + "/user/update";
		var data = JSON.stringify(user);
		var cb_success = function(resultData) {

			cb_function(user);
		};
		var cb_error = function() { 
			cb_function();
		};
		WsUtil.postJsonQuery(url, data, cb_success, cb_error);
	};
	
	WsUser.add = function(cb_function, user) {

		var url = WsUtil.baseUrl() + "/user/add";
		var data = JSON.stringify(user);
		var cb_success = function(resultData) {

			cb_function(user);
		};
		var cb_error = function() { 
			cb_function();
		};
		WsUtil.postJsonQuery(url, data, cb_success, cb_error);
	};

	/*
	 * Convert a Json Object to a model.User Object
	 * @param {User} brut object
	 * @return the User object
	 */
	function _json2User(json) {
		
		var user = User.Class.create({
						id : json.id,
						nickname : json.nickname,
						shortNickname : json.shortNickname,
						firstName : json.firstName,
						lastName : json.lastName,
						chocoProxies : WsUtil.json2Proxies(json.chocoProxies),
						officeProxy : WsUtil.json2Proxy(json.officeProxy),
						email : json.email,
						level : json.level,
						xp : json.xp,
		});
		
		return user;
	}
	
	/** Start of user code additional functions */
	/** End of user code */

	return WsUser;
});
