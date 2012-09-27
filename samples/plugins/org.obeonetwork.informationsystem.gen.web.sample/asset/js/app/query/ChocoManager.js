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
	var localStorageEnable = (typeof(Storage)!=="undefined");
/** End of user code */


	var ChocoManager = {};

	ChocoManager.async_all = function(cb_function) {
		
		var cb_Chocos = function(Chocos) {
			/** Start of user code cb_Chocos */
			cb_function(Chocos);
			/** End of user code */
		};
		
		WsChoco.all(cb_Chocos);
	};

	ChocoManager.all = function(cb_function) {
		/** Start of user code default all */
		/** End of user code */
	};
	

	ChocoManager.async_allProxies = function(cb_function) {
		
		var cb_chocoProxies = function(chocoProxies) {
			/** Start of user code cb_chocoProxies */
			cb_function(chocoProxies);
			/** End of user code */
		};
		
		WsChoco.allProxies(cb_chocoProxies);
	};

	ChocoManager.allProxies = function(cb_function) {
		/** Start of user code default allProxies */
		/** End of user code */
	};


	ChocoManager.async_countAll = function(cb_function) {
		
		var cb_countAllChocos = function(count) {
			/** Start of user code cb_countAllChocos */
			cb_function(count);
			/** End of user code */
		};
		
		WsChoco.countAllChocos(cb_countAllChocos);
	};

	ChocoManager.countAll = function(cb_function) {
		/** Start of user code default countAll */
		/** End of user code */
	};

	
	ChocoManager.async_allByRows = function(cb_function, nbElemByRow, rowId) {
		
		var cb_allByRows = function(Chocos) {
			/** Start of user code cb_allByRows */
			cb_function(Chocos);
			/** End of user code */
			
		};
		
		WsChoco.allByRows(cb_allByRows, nbElemByRow, rowId);
	};

	ChocoManager.allByRows = function(cb_function, nbElemByRow, rowId) {
		/** Start of user code default allByRows */
		/** End of user code */
	};
	

	ChocoManager.async_byId = function(cb_function, id) {
		
		var cb_choco = function(choco) {
			/** Start of user code cb_choco */
			cb_function(choco);
			/** End of user code */
		};
		
		WsChoco.choco(cb_choco, id);
	};

	ChocoManager.byId = function(cb_function, id) {
		/** Start of user code default byId */
		/** End of user code */
	};


	ChocoManager.async_stats = function(cb_function) {
		
		var cb_chocoStats = function(Chocos) {
			/** Start of user code cb_chocoStats */
			cb_function(Chocos);
			/** End of user code */
		};
		
		WsChoco.stats(cb_chocoStats);
	};

	ChocoManager.stats = function(cb_function) {
		/** Start of user code default stats */
		/** End of user code */
	};
	
	/** Start of user code additional functions */
	function _storeChocos(chocos) {
		//TODO
	}
	
	function _storeChoco(choco) {
		//TODO
	}
	
	function _removeChoco(choco) {
		//TODO
	}
	/** End of user code */

	return ChocoManager;
});
