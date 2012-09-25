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
 * define a webservice API for the choco entity.
 * we use JQuery REST API. In consequence, we are in an asynchrone context.
 * All functions must define a call back function that will run at the end
 * of the REST query.
 */
// TODO use $.getJSON

define(["require", "app/ws/WsUtil", "app/model/Choco"], function(require) {
	
	/*__ Libs __*/
	var WsUtil = require("app/ws/WsUtil");
	var Choco = require("app/model/Choco");
	/*__ Libs __*/
	
	var WsChoco = {};

	/*
	 * get all chocos model.
	 * @param {function(model.Choco[])} the function throw at the end of 
	 * the asynchrone query.
	 * @return {model.Choco[]} all chocos
	 */
	WsChoco.all = function(cb_function) {

		var chocos = [];

		var url = WsUtil.baseUrl() + "/choco/list";
		var data = null;
		var cb_success = function(resultData) {

			for(var i = 0; i < resultData.length; i++) {
				var choco = _json2Choco(resultData[i]);
				chocos[i] = choco;
			}
			cb_function(chocos);
		};
		var cb_error = function() { 
			cb_function([]);
		};
		WsUtil.getJsonQuery(url, data, cb_success, cb_error);
	};
	
	WsChoco.allProxies = function(cb_function) {

		var chocoProxies = [];

		var url = WsUtil.baseUrl() + "/choco/list-proxy";
		var data = null;
		var cb_success = function(resultData) {

			for(var i = 0; i < resultData.length; i++) {
				var chocoProxy = WsUtil.json2Proxy(resultData[i]);
				chocoProxies[i] = chocoProxy;
			}
			cb_function(chocoProxies);
		};
		var cb_error = function() { 
			cb_function([]);
		};
		WsUtil.getJsonQuery(url, data, cb_success, cb_error);
	};

	WsChoco.allByRows = function(cb_function, nbElemByRow, rowId) {

		if(nbElemByRow<0) {
			WsChoco.all(cb_function);
		} else {
			var chocos = [];
	
			//TODO implement nbElemByRow in args
			var url = WsUtil.baseUrl() + "/choco/rows/"+rowId;
			var data = {nbElemByRow : nbElemByRow};
			var cb_success = function(resultData) {
	
				for(var i = 0; i < resultData.length; i++) {
					var choco = _json2Choco(resultData[i]);
					chocos[i] = choco;
				}
				cb_function(chocos);
			};
			var cb_error = function() { 
				cb_function([]);
			};
			WsUtil.getJsonQuery(url, data, cb_success, cb_error);
		}
	};
	
	
	WsChoco.countAllChocos = function(cb_function) {

		var count = 0;

		var url = WsUtil.baseUrl() + "/choco/list-count";
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
	 * get an choco model by Id
	 * @param {function(model.Choco)} the function throw at the end 
	 * of the asynchrone query.
	 * @param {long} the choco Id.
	 * @return {model.Choco} the choco
	 */
	WsChoco.choco = function(cb_function, id) {
		
		var url = WsUtil.baseUrl() + "/choco/get/" + id;
		var data = null;
		var cb_success = function(resultData) {
			var choco = _json2Choco(resultData);
			
			cb_function(choco);
		};
		var cb_error = function() { 
			cb_function(null);
		};
		WsUtil.getJsonQuery(url, data, cb_success, cb_error);
	};

	/*
	 * Convert a Json Object to a model.Choco Object
	 * @param {Object} brut object
	 * @return the Choco object
	 */
	function _json2Choco(json) {
		
		var choco = Choco.Class.create({
			id : json.id, userProxy : WsUtil.json2Proxy(json.userProxy), shortDescription : json.shortDescription, description : json.description, status : json.status
		});
		return choco;
	}
	
	return WsChoco;
});
