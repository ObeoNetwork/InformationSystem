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
define([], function() {

	var ProviderDelegation = {};
	
	var github = {};
	
	github.urlRedirect = "http://127.0.0.2:8080";
	github.client_id = "e6dd5bfdb28f83c2938b";
	github.client_secret = "4596dfa0ede4eaf08d3a60322230683188992c46";
	github.urlAuthorize = "https://github.com/login/oauth/authorize?client_id="+github.client_id+"&redirect_uri="+github.urlRedirect;
	github.urlAccessToken = "https://github.com/login/oauth/access_token?client_id="+github.client_id+"&client_secret="+github.client_secret;
	
	ProviderDelegation.getUrl4Login = function(args) { return github.urlAuthorize+args; }
		
		
	ProviderDelegation.getToken = function (code) {
		var token = _getToken(code, github.client_id, github.client_secret);
	}
	
	function _getToken(code, client_id, client_secret) {
		
		var ret = undefined;
		$.ajax({
				url : github.urlAccessToken + "&code="+code, type : "get", dataType : "html", context : document.body, async : false, cache : false, success : function(data) {
					ret = data.access_token;
				}
			});
		return ret;
	}

	return ProviderDelegation;
});