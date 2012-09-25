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
 * @since 0.3
 *
 */
define(["require", "app/App", "app/security/oAuth/ProviderDelegation"], function(require) {
	
	/*__ Libs __*/
	var App = require("app/App");
	var ProviderDelegation = require("app/security/oAuth/ProviderDelegation");
	/*__ Libs __*/
	
	var CommonEvents = {};
	
	function _init() {
		_initSignIn();
		_initSignOut();
		_initSignUp();
		_initSignHmarchadour();
		_initSignModerator();
		_initSignAdmin();
	}


	CommonEvents.start = function() {
		_init();
	};

	function _initSignIn() {
		
		$("#sign-in").click(function(event) {
			App.commonCtrl.signIn();
		});
	};
	
	function _initSignHmarchadour() {
		
		$("#sign-hmarchadour").click(function(event) {
			var redirect = ProviderDelegation.getUrl4Login("?hmarchadour=true");
			$(this).attr("href", redirect);
		});
	}
	
	function _initSignModerator() {
		
		$("#sign-moderator").click(function(event) {
			var redirect = ProviderDelegation.getUrl4Login("?moderator=true");
		$(this).attr("href", redirect);
		});
	}
	
	function _initSignAdmin() {
		
		$("#sign-admin").click(function(event) {
			var redirect = ProviderDelegation.getUrl4Login("?admin=true");
		$(this).attr("href", redirect);
		});
	}
	
	function _initSignOut() {
		
		$("#sign-out").click(function(event) {
			event.preventDefault(); // prevent the standard link click
			App.commonCtrl.signOut();
		});
	};
	
	function _initSignUp() {
		$("#sign-up").click(function(event) {
			
			/*event.preventDefault(); // prevent the standard link click
			
			var state = $(this).attr("class");
			
			//TODO refactor
			if(state === "active") {
				$(this).removeClass("active");
				App.commonCtrl.hideSignUp();
			} else {
				$(this).addClass("active");
				App.commonCtrl.showSignUp();
			}*/
		});
	};
	
	return CommonEvents;
});
