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
 * @since 0.8.0
 * @generated
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/ws/WsChoco" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var WsChoco = require("app/ws/WsChoco");
/** End of user code */


	var ChocoManager = {};

	ChocoManager.async_all = function(cb_function) {
		
		var cb_Chocos = function(Chocos) {
			cb_function(Chocos);
		};
		
		WsChoco.all(cb_Chocos);
	};
	
	ChocoManager.async_allProxies = function(cb_function) {
		
		var cb_chocoProxies = function(chocoProxies) {
			cb_function(chocoProxies);
		};
		
		WsChoco.allProxies(cb_chocoProxies);
	};

	ChocoManager.async_countAll = function(cb_function) {
		
		var cb_countAllChocos = function(count) {
			cb_function(count);
		};
		
		WsChoco.countAllChocos(cb_countAllChocos);
	};
	
	ChocoManager.async_allByRows = function(cb_function, nbElemByRow, rowId) {
		
		var cb_allByRows = function(Chocos) {
			cb_function(Chocos);
		};
		
		WsChoco.allByRows(cb_allByRows, nbElemByRow, rowId);
	};
	
	ChocoManager.async_byId = function(cb_function, id) {
		
		var cb_choco = function(choco) {
			cb_function(choco);
		};
		
		WsChoco.choco(cb_choco, id);
	};

	ChocoManager.async_stats = function(cb_function) {
		
		var cb_chocoStats = function(choco) {
			cb_function(choco);
		};
		
		WsChoco.stats(cb_chocoStats);
	};
	
	/** Start of user code additional functions */
	/** End of user code */

	return ChocoManager;
});
