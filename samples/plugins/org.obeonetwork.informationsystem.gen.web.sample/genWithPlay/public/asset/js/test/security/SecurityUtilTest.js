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
 * @since 1.0.0
 * @generated
 */

/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/security/SecurityUtil", "jasmine" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var SecurityUtil = require("app/security/SecurityUtil");
	// jasmine does not need to be stored in a variable.
/** End of user code */


	describe("SecurityUtil test", function() {
		var cookieName;
		var cookieValue;

		beforeEach(function() {
			cookieName = "test";
			cookieValue = "0";
			SecurityUtil.deleteCookie(cookieName);
		});

		it("test set and get cookie", function() {
			expect(SecurityUtil.getCookie(cookieName)).toBe(null);
			SecurityUtil.setCookie(cookieName, cookieValue, 1);
			expect(SecurityUtil.getCookie(cookieName)).toBe(cookieValue);
		});

		it("test set, delete and get cookie", function() {
			expect(SecurityUtil.getCookie(cookieName)).toBe(null);
			SecurityUtil.setCookie(cookieName, cookieValue, 1);
			expect(SecurityUtil.getCookie(cookieName)).toBe(cookieValue);
			SecurityUtil.deleteCookie(cookieName);
			expect(SecurityUtil.getCookie(cookieName)).toBe(null);
		});
	});

});
