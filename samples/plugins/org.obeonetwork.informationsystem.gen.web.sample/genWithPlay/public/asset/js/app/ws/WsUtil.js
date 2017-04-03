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
 * @since 0.6.0
 * @generated
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/model/Proxy", "app/security/LogManager", "app/model/Stat" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var Proxy = require("app/model/Proxy"),
		LogManager = require("app/security/LogManager"),
		Stat = require("app/model/Stat");
/** End of user code */

	
	var WsUtil = {};
	
	WsUtil.baseUrl = function() {
			return ".";
	}

	WsUtil.getJsonQuery = function(url, data, cb_success, cb_error) {

		$.ajax({
			type : "GET", 
			url : LogManager.tokenizeThisUrl(url), 
			data : data,
			dataType: "json",
			success : function(result) {
				cb_success(result);
			}, 
			error : function(request, status, errorThrown) {
				if(cb_error!=undefined)
					cb_error(request, status, errorThrown);
				else
					_defaultError(request, status, errorThrown);
					
			}
		}); 

	}
	
	/*
	 * Convert a Json Object to a model.Proxy Object
	 * @param {Object} brut object
	 * @return the Proxy object
	 */
	WsUtil.json2Proxy = function(json) {
		var proxy = null;
		if(json != undefined) {
			proxy = Proxy.Class.create({
				id : json.id, desc : json.desc
			});
		}
		return proxy;
	}
	
	/*
	 * Convert a Json Objects array to a model.Proxy Object array
	 * @param {Object} brut object
	 * @return Proxies objects
	 */
	WsUtil.json2Proxies = function(json) {
		
		var proxies = [];
		if(json != undefined) {
			for (var i=0; i < json.length; i++) {
			  proxies[i] = WsUtil.json2Proxy(json[i]);
			};
		}
		return proxies;
	}

	/*
	 * Convert a Json Object to a model.Stat Object
	 * @param {Object} brut object
	 * @return the Stat object
	 */
	WsUtil.json2Stat = function(json) {
		var stat = null;
		if(json != undefined) {
			var stat = Stat.Class.create({
				res : json.res, desc : json.desc
			});
		}
		return stat;
	}
	
	/*
	 * Convert a Json Objects array to a model.Stat Object array
	 * @param {Object} brut object
	 * @return Stats objects
	 */
	WsUtil.json2Stats = function(json) {
		
		var stats = [];
		if(json != undefined) {
			for (var i=0; i < json.length; i++) {
			  stats[i] = WsUtil.json2Stat(json[i]);
			};
		}

		return stats;
	}
	
	WsUtil.postJsonQuery = function(url, data, cb_success, cb_error) {
		//TODO to remove

		$.ajax({
			type : "POST",
			url : LogManager.tokenizeThisUrl(url), 
			data : data,
			dataType: "text",
			success : function(result) {
				cb_success(result);
			}, 
			error : function(request, status, errorThrown) {
				if(cb_error!=undefined)
					cb_error(request, status, errorThrown);
				else
					_defaultError(request, status, errorThrown);
					
			}
		});

	}

	WsUtil.updateJsonQuery = function(url, data, cb_success, cb_error) {
		//TODO to remove

		$.ajax({
			type : "PUT",
			url : LogManager.tokenizeThisUrl(url), 
			data : data,
			dataType: "text",
			success : function(result) {
				cb_success(result);
			}, 
			error : function(request, status, errorThrown) {
				if(cb_error!=undefined)
					cb_error(request, status, errorThrown);
				else
					_defaultError(request, status, errorThrown);
					
			}
		});

	}

	WsUtil.updateJsonQuery = function(url, data, cb_success, cb_error) {
		//TODO to remove

		$.ajax({
			type : "UPDATE",
			url : LogManager.tokenizeThisUrl(url), 
			data : data,
			dataType: "text",
			success : function(result) {
				cb_success(result);
			}, 
			error : function(request, status, errorThrown) {
				if(cb_error!=undefined)
					cb_error(request, status, errorThrown);
				else
					_defaultError(request, status, errorThrown);
					
			}
		});

	}

	var _defaultError = function(request, status, errorThrown) {
		console.log("JsonQuery fail");
		console.log(request);
		console.log(status);
		console.log(errorThrown);
	};
	
	/** Start of user code additional functions */
	/** End of user code */

	return WsUtil;
});
