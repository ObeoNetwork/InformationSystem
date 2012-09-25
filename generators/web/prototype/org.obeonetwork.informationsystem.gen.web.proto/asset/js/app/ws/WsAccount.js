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
 * @since 0.7
 * define a webservice API for the user entity.
 * we use JQuery REST API. In consequence, we are in an asynchrone context.
 * All functions must define a call back function that will run at the end
 * of the REST query.
 */
define(["require", "app/ws/wsUtil", "app/model/Account"], function(require) {
	
	var wsUtil = require("app/ws/wsUtil");
	var Account = require("app/model/Account");
	
	var WsAccount = {};

	/*
	 * get an user model by Id
	 * @param {function(model.User)} the function throw at the end 
	 * of the asynchrone query.
	 * @param {long} the user Id.
	 * @return {model.User} the user
	 */
	WsAccount.byTokenMatch = function(cb_function, token) {

		var url = wsUtil.baseUrl() + "/account/get/" + token;
		var data = null;
		var cb_success = function(resultData) {
			var account = _json2Account(resultData);
			cb_function(account);
		};
		var cb_error = function() { 
			cb_function(null);
		};
		wsUtil.getJsonQuery(url, data, cb_success, cb_error);
	};
	
		
	/*
	 * Convert a Json Object to a model.User Object
	 * @param {Object} brut object
	 * @return the User object
	 */
	function _json2Account(json) {
		
		var account = Account.Class.create({
			id : json.id, chocoProxies : wsUtil.json2Proxies(json.chocoProxies), officeProxy : wsUtil.json2Proxy(json.officeProxy), nickname : json.nickname, shortNickname : json.shortNickname, firstName : json.firstName, lastName : json.lastName, email : json.email, level : json.level, xp : json.xp, accountType : json.accountType
		});
		return account;
	}
	
	return WsAccount;
});
