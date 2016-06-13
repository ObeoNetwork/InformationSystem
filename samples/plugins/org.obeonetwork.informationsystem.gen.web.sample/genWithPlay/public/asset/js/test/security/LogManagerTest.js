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
define(["require", "app/security/LogManager", "jasmine" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var LogManager = require("app/security/LogManager");
	// jasmine does not need to be stored in a variable.
/** End of user code */

	LogManager.logOff();

	describe("LogManager test", function() {

		beforeEach(function() {
		});

		it("isLogged without login", function() {
			expect(LogManager.isLogged()).toBe(false);
		});
		it("isAdmin without login", function() {
			expect(LogManager.isAdmin()).toBe(false);
		});
		it("isModerator without login", function() {
			expect(LogManager.isModerator()).toBe(false);
		});

		it("inLoginProcess without login", function() {
			expect(LogManager.inLoginProcess()).toBe(false);
		});
	});

});
