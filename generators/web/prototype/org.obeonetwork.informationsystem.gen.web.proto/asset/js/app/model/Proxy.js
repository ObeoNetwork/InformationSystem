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
 * @since 0.8
 * define the ember proxy model
 * @see http://emberjs.com/#toc_the-ember-object-model
 */
define(["ember"], function(/*Em*/) {

	var proxy = {};

	/*
	 * The class definition
	 * @param {long} id
	 * @param {String} description

	*/
	proxy.Class = Em.Object.extend({
		id : null, 
		desc : null
	});

	return proxy;

});
