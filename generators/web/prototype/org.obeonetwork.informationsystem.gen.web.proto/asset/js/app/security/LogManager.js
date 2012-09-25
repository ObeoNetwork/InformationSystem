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
 */
define(["require", "app/security/SecurityUtil", "app/security/oAuth/ProviderDelegation"], function(require) {
	
	/*__ Libs __*/
	var SecurityUtil = require("app/security/SecurityUtil");
	var ProviderDelegation = require("app/security/oAuth/ProviderDelegation");
	/*__ Libs __*/
	
	var LogManager = {};

	LogManager.logOff = function() {
		SecurityUtil.deleteCookie("token");
	};
	
	LogManager.isLogged = function() {
		
		var token = SecurityUtil.getCookie("token");
		return token != undefined;
	};
	
	LogManager.tokenizeThisUrl = function(url) {
		
		//TODO to secure with oAuth
		if(LogManager.isLogged())
			return url;
		else {
			return url+"WRONG!";
		}
	};
	
	//TODO modify this
	LogManager.isAdmin = function() {
		
		var token = SecurityUtil.getCookie("token");
		return token === "3333333333333333333333333333333333333333";
	};
	
	//TODO modify this
	LogManager.isModerator = function() {
		
		var token = SecurityUtil.getCookie("token");
		return token === "2222222222222222222222222222222222222222";
	};
	
	LogManager.getToken = function() {
		return SecurityUtil.getCookie("token");
	}
	
	function _inHackMode() {
		
		return SecurityUtil.urlParams["hmarchadour"]||SecurityUtil.urlParams["moderator"]||SecurityUtil.urlParams["admin"];
	}
	
	LogManager.inLoginProcess = function() {
		
		var code = SecurityUtil.urlParams["code"];
		return code != undefined;
	};
	
	LogManager.tokenQuery = function() {
		
		var token = undefined;
		
		if(_inHackMode()) {
			if(SecurityUtil.urlParams["hmarchadour"]) {
				console.log("login hack hmarchadour");
				token = "1111111111111111111111111111111111111111";
			} else if(SecurityUtil.urlParams["moderator"]) {
				console.log("login hack moderator");
				token = "2222222222222222222222222222222222222222";	
			} else if(SecurityUtil.urlParams["admin"]) {
				console.log("login hack admin");
				token = "3333333333333333333333333333333333333333";
			} else {
				console.log("login hack failed");
			}
			
		} else {
			token = ProviderDelegation.getToken(App.urlParams["code"]);
		}
		if(token!=undefined)
			SecurityUtil.setCookie("token", token, 1);
	}

	return LogManager;
});