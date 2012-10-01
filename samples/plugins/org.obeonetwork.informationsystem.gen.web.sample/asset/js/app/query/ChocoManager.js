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
define(["require", "app/ws/WsChoco", "app/ls/LsChoco" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var WsChoco = require("app/ws/WsChoco"),
		LsChoco = require("app/ls/LsChoco");
/** End of user code */


	var ChocoManager = {},
		lsEnable = (typeof(Storage)!=="undefined");

	ChocoManager.async_all = function(cb_function) {
		
		var cb_chocos = function(chocos) {
			/** Start of user code cb_chocos */
			cb_function(chocos);
			/** End of user code */
		};
		
		WsChoco.all(cb_chocos);
	};

	ChocoManager.all = function(cb_function) {
		/** Start of user code default all */
		var store = LsChoco.getStore();
		var chocos = store.chocos;
		cb_function(chocos);
		/** End of user code */
	};
	

	ChocoManager.async_allProxies = function(cb_function) {
		
		var cb_chocoProxies = function(chocoProxies) {
			/** Start of user code cb_chocoProxies */
			LsChoco.storeProxies(chocoProxies);
			cb_function(chocoProxies);
			/** End of user code */
		};
		
		WsChoco.allProxies(cb_chocoProxies);
	};

	ChocoManager.allProxies = function(cb_function) {
		/** Start of user code default allProxies */
		var store = LsChoco.getStore();
		var proxies = store.proxies;
		cb_function(proxies);
		/** End of user code */
	};


	ChocoManager.async_countAll = function(cb_function) {
		
		var cb_countAllchocos = function(count) {
			/** Start of user code cb_countAllchocos */
			cb_function(count);
			/** End of user code */
		};
		
		WsChoco.countAllChocos(cb_countAllchocos);
	};

	ChocoManager.countAll = function(cb_function) {
		/** Start of user code default countAll */
		var store = LsChoco.getStore();
		var count = 0;
	    for(var lchoco in store.lchocos)
	    {
	        count++;
	    }
		cb_function(count)
		/** End of user code */
	};

	
	ChocoManager.async_allByRows = function(cb_function, nbElemByRow, rowId) {
		
		var cb_allByRows = function(chocos) {
			/** Start of user code cb_allByRows */
			LsChoco.storeChocos(chocos);
			cb_function(chocos);
			/** End of user code */
			
		};
		
		WsChoco.allByRows(cb_allByRows, nbElemByRow, rowId);
	};

	ChocoManager.allByRows = function(cb_function, nbElemByRow, rowId) {
		/** Start of user code default allByRows */
		var store = LsChoco.getStore();
		var chocos = store.chocos;
		var chocosToAdd = store.local.chocosToAdd;
		
		var chocosLength = chocosToAdd.length;
	    for(var choco in chocos) {
	    	chocosLength++;
	    }
		var result = [];
		var from = Math.max(rowId*nbElemByRow, 0);
		var to = Math.min(rowId*nbElemByRow+nbElemByRow, chocosLength);
		
		for ( var i = 0; i < chocosToAdd.length; i++) {
			result.push(chocosToAdd[i]);
		}
		
		var i = 0;
		for(var chocoId in chocos) {
			if(i >= from && i < to){
				result.push(chocos[chocoId]);
			}
			i++;
		}
		cb_function(result);
		/** End of user code */
	};
	

	ChocoManager.async_byId = function(cb_function, id) {
		
		var cb_choco = function(choco) {
			/** Start of user code cb_choco */
			LsChoco.storeChoco(choco);
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
		
		var cb_chocoStats = function(chocos) {
			/** Start of user code cb_chocoStats */
			cb_function(chocos);
			/** End of user code */
		};
		
		WsChoco.stats(cb_chocoStats);
	};

	ChocoManager.stats = function(cb_function) {
		/** Start of user code default stats */
		var store = LsChoco.getStore();
		cb_function(store.chocoStats);
		/** End of user code */
	};

	// REMOVE
	ChocoManager.async_remove = function(cb_function, choco) {
		
		var cb_remove = function() {
			LsChoco.removeChoco(choco);
			cb_function();
		};
		var store = LsChoco.getStore();
		var chocoStored = store.chocos[choco.id];
		WsChoco.remove(cb_remove, chocoStored);
	};

	ChocoManager.remove = function(cb_function, choco) {
		LsChoco.localRemoveChoco(choco);
		cb_function();
	};
	
	// UPDATE
	ChocoManager.async_update = function(cb_function, choco) {
		
		var cb_update = function() {
			LsChoco.updateChoco(choco);
			cb_function();
		};
		var store = LsChoco.getStore();
		var chocoStored = store.chocos[choco.id];
		WsChoco.update(cb_update, chocoStored);
	};

	ChocoManager.update = function(cb_function, choco) {
		LsChoco.localUpdateChoco(choco);
		cb_function();
	};
	
	
	// ADD
	ChocoManager.async_add = function(cb_function, choco) {
		//TODO WArning bug?
		var cb_add = function() {
			LsChoco.storeChoco(choco);
			cb_function();
		};
		var store = LsChoco.getStore();
		var chocoStored = store.chocos[choco.id];
		WsChoco.add(cb_add, chocoStored);
	};

	ChocoManager.add = function(cb_function, choco) {
		LsChoco.localStoreChoco(choco);
		cb_function();
	};
	
	/** Start of user code additional functions */
	/** End of user code */

	return ChocoManager;
});
