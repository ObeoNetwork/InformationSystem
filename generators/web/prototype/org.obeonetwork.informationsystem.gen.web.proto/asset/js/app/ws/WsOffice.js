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
 * define a webservice API for the office entity.
 * we use JQuery REST API. In consequence, we are in an asynchrone context.
 * All functions must define a call back function that will run at the end
 * of the REST query.
 */
define(["require", "app/ws/WsUtil", "app/model/Office"], function(require) {

	/*__ Libs __*/
	var WsUtil = require("app/ws/WsUtil");
	var Office = require("app/model/Office");
	/*__ Libs __*/
	
	var WsOffice = {};

	/*
	 * get all offices model.
	 * @param {function(model.Office[])} the function throw at the end of 
	 * the asynchrone query.
	 * @return {model.Office[]} all offices
	 */
	WsOffice.all = function(cb_function) {

		var offices = [];

		var url = WsUtil.baseUrl() + "/office/list";
		var data = null;
		var cb_success = function(resultData) {

			for(var i = 0; i < resultData.length; i++) {
				var office = _json2Office(resultData[i]);
				offices[i] = office;
			}
			cb_function(offices);
		};
		var cb_error = function() { 
			cb_function([]);
		};
		WsUtil.getJsonQuery(url, data, cb_success, cb_error);
	};
	
	WsOffice.allProxies = function(cb_function) {

		var officeProxies = [];

		var url = WsUtil.baseUrl() + "/office/list-proxy";
		var data = null;
		var cb_success = function(resultData) {

			for(var i = 0; i < resultData.length; i++) {
				var officeProxy = WsUtil.json2Proxy(resultData[i]);
				officeProxies[i] = officeProxy;
			}
			cb_function(officeProxies);
		};
		var cb_error = function() { 
			cb_function([]);
		};
		WsUtil.getJsonQuery(url, data, cb_success, cb_error);
	};
	
	WsOffice.allByRows = function(cb_function, nbElemByRow, rowId) {

		if(nbElemByRow<0) {
			WsOffice.all(cb_function);
		} else {
			var offices = [];
	
			//TODO implement nbElemByRow in args
			var url = WsUtil.baseUrl() + "/office/rows/"+rowId;
			var data = {nbElemByRow : nbElemByRow};
			var cb_success = function(resultData) {
	
				for(var i = 0; i < resultData.length; i++) {
					var office = _json2Office(resultData[i]);
					offices[i] = office;
				}
				cb_function(offices);
			};
			var cb_error = function() { 
				cb_function([]);
			};
			WsUtil.getJsonQuery(url, data, cb_success, cb_error);
		}
	};
	
	
	WsOffice.countAllOffices = function(cb_function) {

		var count = 0;

		var url = WsUtil.baseUrl() + "/office/list-count";
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
	 * get an office model by Id
	 * @param {function(model.Office)} the function throw at the end 
	 * of the asynchrone query.
	 * @param {long} the office Id.
	 * @return {model.Office} the office
	 */
	WsOffice.office = function(cb_function, id) {

		var url = WsUtil.baseUrl() + "/office/get/" + id;
		var data = null;
		var cb_success = function(resultData) {

			var office = _json2Office(resultData);
			
			cb_function(office);
		};
		var cb_error = function() { 
			cb_function(null);
		};
		WsUtil.getJsonQuery(url, data, cb_success, cb_error);
	};

	/*
	 * Convert a Json Object to a model.Office Object
	 * @param {Object} brut object
	 * @return the Office object
	 */
	function _json2Office(json) {
		
		var office = Office.Class.create({
			id : json.id, shortDescription : json.shortDescription, description : json.description
		});
		
		return office;
	}
	
	return WsOffice;
});
