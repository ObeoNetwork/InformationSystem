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
 * @since 0.6
 */
define(["require", "app/model/Proxy", "app/security/LogManager"], function(require) {
	
	/*__ Libs __*/
	var Proxy = require("app/model/Proxy");
	var LogManager = require("app/security/LogManager");
	/*__ Libs __*/
	
	var WsUtil = {};
	
	WsUtil.baseUrl = function() {
		return "./ws";
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
		
		var proxy = Proxy.Class.create({
			id : json.id, desc : json.desc
		});
		return proxy;
	}
	
	/*
	 * Convert a Json Objects array to a model.Proxy Object array
	 * @param {Object} brut object
	 * @return Proxies objects
	 */
	WsUtil.json2Proxies = function(json) {
		
		var proxies = [];
		for (var i=0; i < json.length; i++) {
		  proxies[i] = WsUtil.json2Proxy(json[i]);
		};
		
		return proxies;
	}
	
	var _defaultError = function(request, status, errorThrown) {
		console.log("JsonQuery fail");
		console.log(request);
		console.log(status);
		console.log(errorThrown);
	};
	
	return WsUtil;
});

