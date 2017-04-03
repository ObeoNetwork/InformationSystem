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
 * @since 1.0.0
 * @generated
 */

/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/security/ProviderDelegation", "jasmine" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var ProviderDelegation = require("app/security/ProviderDelegation");
	// jasmine does not need to be stored in a variable.
/** End of user code */


	describe("ProviderDelegation test", function() {
		it("Github config enable", function() {
			expect(ProviderDelegation.github.urlRedirect.length).toBeGreaterThan(1);
			expect(ProviderDelegation.github.client_id.length).toBeGreaterThan(1);
			expect(ProviderDelegation.github.client_secret.length).toBeGreaterThan(1);
			expect(ProviderDelegation.github.urlAuthorize.length).toBeGreaterThan(1);
			expect(ProviderDelegation.github.urlAccessToken.length).toBeGreaterThan(1);
		});

		it("GetToken return null with a wrong code", function() {
			expect(ProviderDelegation.getToken("0")).toBe(null);
		});
	});
});
