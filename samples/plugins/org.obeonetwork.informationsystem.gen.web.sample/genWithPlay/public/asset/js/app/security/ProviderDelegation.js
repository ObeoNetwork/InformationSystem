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

/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require" ], function(require) {
	"use strict";

/** End of user code */


	var ProviderDelegation = {};

	ProviderDelegation.github = {};
	ProviderDelegation.github.urlRedirect = "http://127.0.0.3:8080";
	ProviderDelegation.github.client_id = "45b8cfde41e16ddd8119";
	ProviderDelegation.github.client_secret = "e6e6b93f2209411b14c82b1adff66fbfb91a11e1";
	ProviderDelegation.github.urlAuthorize = "https://github.com/login/oauth/authorize?client_id="+ProviderDelegation.github.client_id+"&redirect_uri="+ProviderDelegation.github.urlRedirect;
	ProviderDelegation.github.urlAccessToken = "https://github.com/login/oauth/access_token?client_id="+ProviderDelegation.github.client_id+"&client_secret="+ProviderDelegation.github.client_secret;
	
	ProviderDelegation.getUrl4Login = function(args) { return ProviderDelegation.github.urlAuthorize+args; }
		
		
	ProviderDelegation.getToken = function (code) {
		var token = ProviderDelegation._getToken(code, ProviderDelegation.github.client_id, ProviderDelegation.github.client_secret);
		return token;
	}
	
	ProviderDelegation._getToken = function (code, client_id, client_secret) {
		
		var ret = null;
		$.ajax({
				url : ProviderDelegation.github.urlAccessToken + "&code="+code, type : "get", dataType : "html", context : document.body, async : false, cache : false, success : function(data) {
					ret = data.access_token;
				}
			});
		return ret;
	}
	
	/** Start of user code additional functions */
	/** End of user code */

	return ProviderDelegation;
});
