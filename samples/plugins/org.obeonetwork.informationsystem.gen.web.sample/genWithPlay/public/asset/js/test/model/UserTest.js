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
define(["require", "app/model/User", "jasmine" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var User = require("app/model/User");
	// jasmine does not need to be stored in a variable.
/** End of user code */



	describe("User test", function() {
		var user;
		
		beforeEach(function() { 
			
		});

		it("test create() with no params", function() {
			user = User.Class.create({});
			expect(user).not.toBe(null);
			expect(user.id).toBe(null);
		});
		
		it("test create() with params", function() {
			var id = 1,
				nickname = "nickname",
				shortNickname = "shortNickname",
				firstName = "firstName",
				lastName = "lastName",
				chocos = [],
				office = null,
				email = "email",
				level = 1,
				xp = 1;
				
			var user = User.Class.create({
				id : id,
				nickname : nickname,
				shortNickname : shortNickname,
				firstName : firstName,
				lastName : lastName,
				chocos : chocos,
				office : office,
				email : email,
				level : level,
				xp : xp,
			});

			expect(user).not.toBe(null);

			expect(user.id).toBe(id);
			expect(user.nickname).toBe(nickname);
			expect(user.shortNickname).toBe(shortNickname);
			expect(user.firstName).toBe(firstName);
			expect(user.lastName).toBe(lastName);
			expect(user.chocos).toBe(chocos);
			expect(user.office).toBe(office);
			expect(user.email).toBe(email);
			expect(user.level).toBe(level);
			expect(user.xp).toBe(xp);
		});
	});

});
