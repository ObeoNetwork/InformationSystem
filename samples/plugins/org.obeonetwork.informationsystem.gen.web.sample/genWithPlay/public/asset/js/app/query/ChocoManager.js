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

	ChocoManager.toOnlineProcess = function() {
		var store = LsChoco.getStore();
		var chocosToAdd = store.local.chocosToAdd;
		for(var i=0; i<chocosToAdd.length; i++) {
			ChocoManager.async_add(function(){}, chocosToAdd[i]);
		}

		var chocos = store.chocos;
		var chocosToRemove = store.local.chocosToRemove;
		var chocosToUpdate = store.local.chocosToUpdate;

		for(var i=0; i<chocosToRemove.length; i++) {
			var id = chocosToRemove[i];
			ChocoManager.async_remove(function(){}, chocos[id]);
		}

		for(var i=0; i<chocosToUpdate.length; i++) {
			var id = chocosToUpdate[i];
			ChocoManager.async_update(function(){}, chocos[id]);
		}
	};

	ChocoManager.async_all = function(cb_function) {
		
		var cb_chocos = function(chocos) {
			cb_function(chocos);
		};
		
		WsChoco.all(cb_chocos);
	};

	ChocoManager.all = function(cb_function) {
		var store = LsChoco.getStore();
		var chocos = store.chocos;
		cb_function(chocos);
	};
	

	ChocoManager.async_allProxies = function(cb_function) {
		
		var cb_chocoProxies = function(chocoProxies) {
			LsChoco.storeProxies(chocoProxies);
			cb_function(chocoProxies);
		};
		
		WsChoco.allProxies(cb_chocoProxies);
	};

	ChocoManager.allProxies = function(cb_function) {
		var store = LsChoco.getStore();
		var proxies = store.proxies;
		cb_function(proxies);
	};


	ChocoManager.async_countAll = function(cb_function) {
		
		var cb_countAllchocos = function(count) {
			cb_function(count);
		};
		
		WsChoco.countAllChocos(cb_countAllchocos);
	};

	ChocoManager.countAll = function(cb_function) {
		var store = LsChoco.getStore();
		var count = store.local.chocosToAdd.length;
	    for(var choco in store.chocos)
	    {
	        count++;
	    }
		cb_function(count)
	};

	
	ChocoManager.async_allByRows = function(cb_function, nbElemByRow, rowId) {
		
		var cb_allByRows = function(chocos) {
			LsChoco.storeChocos(chocos);
			cb_function(chocos);
			
		};
		
		WsChoco.allByRows(cb_allByRows, nbElemByRow, rowId);
	};

	ChocoManager.allByRows = function(cb_function, nbElemByRow, rowId) {
		var store = LsChoco.getStore();
		var chocos = store.chocos;
		var chocosToAdd = store.local.chocosToAdd;
		
		for ( var i = 0; i < chocosToAdd.length; i++) {
			chocos["_"+i] = chocosToAdd[i];
		}

		var chocosLength = 0;
	    for(var choco in chocos) {
	    	chocosLength++;
	    }
		var result = [];
		var from = Math.max(rowId*nbElemByRow, 0);
		var to = Math.min(rowId*nbElemByRow+nbElemByRow, chocosLength);
		
		var i = 0;
		for(var chocoId in chocos) {
			if(i >= from && i < to){
				result.push(chocos[chocoId]);
			}
			i++;
		}
		cb_function(result);
	};
	

	ChocoManager.async_byId = function(cb_function, id) {
		
		var cb_choco = function(choco) {
			LsChoco.storeChoco(choco);
			cb_function(choco);
		};
		
		WsChoco.choco(cb_choco, id);
	};

	ChocoManager.byId = function(cb_function, id) {
		/** Start of user code default byId */
		/** End of user code */
	};


	ChocoManager.async_stats = function(cb_function) {
		
		var cb_chocoStats = function(stats) {
			LsChoco.storeChocoStats(stats);
			cb_function(stats);
		};
		
		WsChoco.stats(cb_chocoStats);
	};

	ChocoManager.stats = function(cb_function) {
		var store = LsChoco.getStore();
		cb_function(store.chocoStats);
	};

	// REMOVE
	ChocoManager.async_remove = function(cb_function, choco) {
		
		var cb_remove = function() {
			//LsChoco.removeChoco(choco);
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
			//LsChoco.updateChoco(choco);
			cb_function();
		};
		//var store = LsChoco.getStore();
		//var chocoStored = store.chocos[choco.id];
		WsChoco.update(cb_update, choco);
	};

	ChocoManager.update = function(cb_function, choco) {
		LsChoco.localUpdateChoco(choco);
		cb_function();
	};
	
	
	// ADD
	ChocoManager.async_add = function(cb_function, choco) {
		var cb_add = function() {
			//LsChoco.storeChoco(choco);
			cb_function();
		};
		//var store = LsChoco.getStore();
		//var chocoStored = store.chocos[choco.id];
		WsChoco.add(cb_add, choco);
	};

	ChocoManager.add = function(cb_function, choco) {
		LsChoco.localStoreChoco(choco);
		cb_function();
	};
	
	/** Start of user code additional functions */
	/** End of user code */

	return ChocoManager;
});
