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
 * @since 0.7.0
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
define(["require", "app/ws/WsUtil", "app/model/Account" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var WsUtil = require("app/ws/WsUtil"),
		Account = require("app/model/Account");
/** End of user code */

	
	var WsAccount = {};

	/*
	 * get an user model by Id
	 * @param {function(model.User)} the function throw at the end 
	 * of the asynchrone query.
	 * @param {long} the user Id.
	 * @return {model.Account} the account
	 */
	WsAccount.byTokenMatch = function(cb_function, token) {

		var url = WsUtil.baseUrl() + "/account/get/" + token;
		var data = null;
		var cb_success = function(resultData) {
			var account = _json2Account(resultData);
			cb_function(account);
		};
		var cb_error = function() { 
			cb_function(null);
		};
		WsUtil.getJsonQuery(url, data, cb_success, cb_error);
	};
	
		
	/*
	 * Convert a Json Object to a model.Account Object
	 * @param {Object} brut object
	 * @return the Account object
	 */
	function _json2Account(json) {
		
		var account = Account.Class.create({
			id : json.id, nickname : json.nickname, shortNickname : json.shortNickname
		});
		return account;
	}
	
	/** Start of user code additional functions */
	/** End of user code */

	return WsAccount;
});
