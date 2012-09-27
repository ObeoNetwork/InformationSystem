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
define(["require", "app/model/Choco", "jasmine" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var Choco = require("app/model/Choco");
	// jasmine does not need to be stored in a variable.
/** End of user code */



	describe("Choco test", function() {
		var choco;
		
		beforeEach(function() { 
			
		});

		it("test create() with no params", function() {
			choco = Choco.Class.create({});
			expect(choco).not.toBe(null);
			expect(choco.id).toBe(null);
		});
		
		it("test create() with params", function() {
			var id = 1,
				shortDescription = "shortDescription",
				description = "description",
				user = null,
				status = [];
				
			var choco = Choco.Class.create({
				id : id,
				shortDescription : shortDescription,
				description : description,
				user : user,
				status : status,
			});

			expect(choco).not.toBe(null);

			expect(choco.id).toBe(id);
			expect(choco.shortDescription).toBe(shortDescription);
			expect(choco.description).toBe(description);
			expect(choco.user).toBe(user);
			expect(choco.status).toBe(status);
		});
	});

});
