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
 * @since 0.8.0
 * @generated
 */
/*
 * define the ember stat model
 * @see http://emberjs.com/#toc_the-ember-object-model
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "ember" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	// ember does not need to be stored in a variable.
/** End of user code */


	var Stat = {};

	/*
	 * The class definition
	 * @param {long} result
	 * @param {String} description

	*/
	Stat.Class = Em.Object.extend({
		res : null, 
		desc : null,
		localUpdate : false,
		localRemove : false,
		localAdd : false,
		local : function() {
			return this.get('localUpdate') || this.get('localRemove') || this.get('localAdd'); 
		}.property('localUpdate', 'localRemove', 'localAdd'),
		/** Start of user code additional attributes */
		/** End of user code */
	});
	
	/** Start of user code additional functions */
	/** End of user code */

	return Stat;
});
