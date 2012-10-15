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
 * define a webservice API for the choco entity.
 * we use JQuery REST API. In consequence, we are in an asynchrone context.
 * All functions must define a call back function that will run at the end
 * of the REST query.
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/ws/WsUtil", "app/model/Choco" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var WsUtil = require("app/ws/WsUtil"),
		Choco = require("app/model/Choco");
/** End of user code */

	
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

			var url = WsUtil.baseUrl() + "/choco/rows/"+rowId+"/"+nbElemByRow;
			var data = null;
			// data = {nbElemByRow : nbElemByRow};
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

			cb_function(resultData);
			
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
	 * @return {model.Choco} the object
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

	// sample of stats query
	WsChoco.stats = function(cb_function) {

		var stats = [];

		var url = WsUtil.baseUrl() + "/choco/stats";
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

	WsChoco.remove = function(cb_function, choco) {

		var url = WsUtil.baseUrl() + "/choco/remove/"+choco.id;
		var data = null;
		var cb_success = function(resultData) {

			cb_function(choco);
		};
		var cb_error = function() { 
			cb_function();
		};
		WsUtil.getJsonQuery(url, data, cb_success, cb_error);
	};
	
	WsChoco.update = function(cb_function, choco) {

		var url = WsUtil.baseUrl() + "/choco/update";
		var data = JSON.stringify(choco);
		var cb_success = function(resultData) {

			cb_function(choco);
		};
		var cb_error = function() { 
			cb_function();
		};
		WsUtil.postJsonQuery(url, data, cb_success, cb_error);
	};
	
	WsChoco.add = function(cb_function, choco) {

		var url = WsUtil.baseUrl() + "/choco/add";
		var data = JSON.stringify(choco);
		var cb_success = function(resultData) {

			cb_function(choco);
		};
		var cb_error = function() { 
			cb_function();
		};
		WsUtil.postJsonQuery(url, data, cb_success, cb_error);
	};

	/*
	 * Convert a Json Object to a model.Choco Object
	 * @param {Choco} brut object
	 * @return the Choco object
	 */
	function _json2Choco(json) {
		
		var choco = Choco.Class.create({
						id : json.id,
						shortDescription : json.shortDescription,
						description : json.description,
						userProxy : WsUtil.json2Proxy(json.userProxy),
		});
		
		return choco;
	}
	
	/** Start of user code additional functions */
	/** End of user code */

	return WsChoco;
});
