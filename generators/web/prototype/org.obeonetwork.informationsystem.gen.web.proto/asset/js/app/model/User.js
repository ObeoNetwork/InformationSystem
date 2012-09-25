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
 * @since 0.4
 * define the ember user model
 * @see http://emberjs.com/#toc_the-ember-object-model
 */
define(["ember"], function(/*, Em*/) {

	var user = {};

	/*
	 * The class definition
	 * @param {long} id
	 * @param {model.Proxy[]} chocoProxies
	 * @param {model.Proxy} officeProxy
	 * @param {String} nickname
	 * @param {String} shortNickname
	 * @param {String} firstName
	 * @param {String} shortNickname
	 * @param {String} lastName
	 * @param {String} email
	 * @param {int} level
	 * @param {int} xp
	 */

	user.Class = Em.Object.extend({

		id : null,
		chocoProxies : [],
		officeProxy : null,
		nickname : null,
		shortNickname : null,
		firstName : null,
		lastName : null,
		email : null,
		level : null,
		xp : null,

		// @see http://emberjs.com/#toc_computed-properties-getters
		fullName : Em.computed(function() {
			var firstName = this.get('firstName');
			var lastName = this.get('lastName');
	
			return firstName + ' ' + lastName;
		}).property('firstName', 'lastName')
	});

	return user;
});
