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
define(["require", "app/model/Office", "jasmine" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var Office = require("app/model/Office");
	// jasmine does not need to be stored in a variable.
/** End of user code */



	describe("Office test", function() {
		var office;
		
		beforeEach(function() { 
			
		});

		it("test create() with no params", function() {
			office = Office.Class.create({});
			expect(office).not.toBe(null);
			expect(office.id).toBe(null);
		});
		
		it("test create() with params", function() {
			var id = 1,
				shortDescription = "shortDescription",
				description = "description";
				
			var office = Office.Class.create({
				id : id,
				shortDescription : shortDescription,
				description : description,
			});

			expect(office).not.toBe(null);

			expect(office.id).toBe(id);
			expect(office.shortDescription).toBe(shortDescription);
			expect(office.description).toBe(description);
		});
	});

});
