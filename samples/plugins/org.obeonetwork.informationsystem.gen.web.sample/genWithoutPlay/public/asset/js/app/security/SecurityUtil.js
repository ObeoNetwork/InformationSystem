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


	var SecurityUtil = {};

	
	SecurityUtil.setCookie = function(c_name, value, exdays) {
		var exdate = new Date();
		exdate.setDate(exdate.getDate() + exdays);
		var c_value = escape(value) + ((exdays == null) ? "" : "; expires=" + exdate.toUTCString());
		document.cookie = c_name + "=" + c_value;
	};

	SecurityUtil.getCookie = function(c_name) {
		var i, x, y, ARRcookies = document.cookie.split(";");
		for( i = 0; i < ARRcookies.length; i++) {
			x = ARRcookies[i].substr(0, ARRcookies[i].indexOf("="));
			y = ARRcookies[i].substr(ARRcookies[i].indexOf("=") + 1);
			x = x.replace(/^\s+|\s+$/g, "");
			if(x == c_name) {
				return unescape(y);
			}
		}
		return null;
	};

	SecurityUtil.deleteCookie = function(c_name) {
    	SecurityUtil.setCookie(c_name,"",-1);
	};
	
	SecurityUtil.checkCookie = function() {
		var username = getCookie("username");
		if(username != null && username != "") {
			alert("Welcome again " + username);
		} else {
			username = prompt("Please enter your name:", "");
			if(username != null && username != "") {
				setCookie("username", username, 365);
			}
		}
	};

	SecurityUtil.urlParams = {};
	(function () {
	    var e,
	        a = /\+/g,  // Regex for replacing addition symbol with a space
	        r = /([^&=]+)=?([^&]*)/g,
	        d = function (s) { return decodeURIComponent(s.replace(a, " ")); },
	        q = window.location.search.substring(1);
	
	    while (e = r.exec(q))
	       SecurityUtil.urlParams[d(e[1])] = d(e[2]);
	})();
	
	/** Start of user code additional functions */
	/** End of user code */

	return SecurityUtil;
});
