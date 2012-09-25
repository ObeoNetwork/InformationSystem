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
 * @since 0.2
 * define a webservice API for the user entity.
 * we use JQuery REST API. In consequence, we are in an asynchrone context.
 * All functions must define a call back function that will run at the end
 * of the REST query.
 */
define(["require", "app/ws/WsUtil", "app/model/User"], function(require) {
	
	/*__ Libs __*/
	var WsUtil = require("app/ws/WsUtil");
	var User = require("app/model/User");
	/*__ Libs __*/
	
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
	
			//TODO implement nbElemByRow in args
			var url = WsUtil.baseUrl() + "/user/rows/"+rowId;
			var data = {nbElemByRow : nbElemByRow};
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

			cb_function(resultData.count);
			
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
	 * @return {model.User} the user
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

	/*
	 * Convert a Json Object to a model.User Object
	 * @param {Object} brut object
	 * @return the User object
	 */
	function _json2User(json) {
		
		var user = User.Class.create({
			id : json.id, chocoProxies : WsUtil.json2Proxies(json.chocoProxies), officeProxy : WsUtil.json2Proxy(json.officeProxy), nickname : json.nickname, shortNickname : json.shortNickname, firstName : json.firstName, lastName : json.lastName, email : json.email, level : json.level, xp : json.xp
		});
		
		return user;
	}
	
	return WsUser;
});
