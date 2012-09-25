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
define(["require", "app/model/User"], function(require) {

	/*__ Libs __*/
	var User = require("app/model/User");
	/*__ Libs __*/
	
	var account = {};

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
	 * @param {int} accountType
	 */

	account.Class = User.Class.extend({
		accountType : null
	});

	return account;
});
