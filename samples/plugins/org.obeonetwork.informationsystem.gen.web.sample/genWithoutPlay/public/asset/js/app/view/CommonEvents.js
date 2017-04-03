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
 * @since 0.3.0
 * @generated
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/App", "app/security/ProviderDelegation" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var App = require("app/App"),
		ProviderDelegation = require("app/security/ProviderDelegation");
/** End of user code */


	var CommonEvents = {};
	
	function _init() {
		/** Start of user code default _init */
		_initSignOut();
		_initSignUp();
		_initSignIn();
		_initConnectionStatus();
		/** End of user code */
	}


	CommonEvents.start = function() {
		_init();
	};
	
	function _initSignIn() {
		/** Start of user code default _initSignIn */
		$("#github-login").click(function(event) {
			var redirect = ProviderDelegation.getUrl4Login("?github=true");
			$(this).attr("href", redirect);
		});
		/** End of user code */
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
			
			if(state === "active") {
				$(this).removeClass("active");
				App.commonCtrl.hideSignUp();
			} else {
				$(this).addClass("active");
				App.commonCtrl.showSignUp();
			}*/
		});
	};

	function _initConnectionStatus() {
		require(["app/view/H5utils"], function(H5utils) {
			H5utils.addEvent(window, 'online', cb_toOnline);
			H5utils.addEvent(window, 'offline', cb_toOffline);
		});
	}
	
	/*call backs*/
	var cb_toOnline = function() {
		App.commonCtrl.toOnline();
	};
	
	var cb_toOffline = function() {
		App.commonCtrl.toOffline();
	};
	
	/** Start of user code additional functions */
	/** End of user code */

	return CommonEvents;
});
