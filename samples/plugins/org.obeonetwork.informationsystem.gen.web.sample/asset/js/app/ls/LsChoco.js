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
 * @since 0.2.0
 * @generated
 */
 /**
 * define a webservice API for the choco entity.
 * we use JQuery REST API. In consequence, we are in an asynchrone context.
 * All functions must define a call back function that will run at the end
 * of the REST query.
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/model/Choco", "app/ws/WsUtil" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var Choco = require("app/model/Choco"),
		WsUtil = require("app/ws/WsUtil");
/** End of user code */

	
	var LsChoco = {};

	LsChoco.getStore = function() {
		return _getStore();
	};
	
	LsChoco.setStore = function(store) {
		 _setStore(store);
	}
	
	LsChoco.storeChocos = function(chocos) {
		var store = _getStore();
		for ( var i = 0; i < chocos.length; i++) {
			var choco = chocos[i];
			choco.set('localUpdate', false);
			choco.set('localRemove', false);
			choco.set('localAdd', false);
			store.chocos[choco.id] = choco;
		}
		_setStore(store);
	}
	
	LsChoco.storeProxies = function(proxies) {
		var store = _getStore();
		for ( var i = 0; i < proxies.length; i++) {
			var proxy = proxies[i];
			store.proxies[i] = proxy;
		}
		_setStore(store);
	}
	
	LsChoco.storeChocoStats = function(chocoStats) {
		var store = _getStore();
		store.chocoStats = chocoStats;
		_setStore(store);
	}
	
	LsChoco.storeChoco = function(choco) {
		var store = _getStore();
		choco.set('localUpdate', false);
		choco.set('localRemove', false);
		choco.set('localAdd', false);
		store.chocos[choco.id] = choco;
		_setStore(store);
	}
	
	LsChoco.removeChoco = function(choco) {
		var store = _getStore();
		store.chocos[choco.id] = undefined;
		_setStore(store);
	}

	
	
	LsChoco.localUpdateChoco = function(choco) {
		var store = _getStore();
		choco.set('localUpdate', true);
		store.chocos[choco.id] = choco;
		store.local.chocosToUpdate.push(choco.id);
		_setStore(store);
	}
	
	LsChoco.localStoreChoco = function(choco) {
		var store = _getStore();
		choco.set('localAdd', true);
		store.local.chocosToAdd.push(choco);
		_setStore(store);
	}
	
	LsChoco.localRemoveChoco = function(choco) {
		var store = _getStore();
		choco.set('localRemove', true);
		store.chocos[choco.id] = choco;
		store.local.chocosToRemove.push(choco.id);
		_setStore(store);
	}
	
	function _getStore() {
		var storeBrut = localStorage.getItem("LsChoco");
		if(typeof(storeBrut)!=="undefined" && storeBrut!==null ) {
			var store = JSON.parse(storeBrut);
			var chocosBrut = store.chocos;
			var chocos = {};
			for ( var id in chocosBrut) {
				var chocoBrut = chocosBrut[id];
				chocos[id] = _object2EmberObject(chocoBrut);
			}
			store.chocos = chocos;
			
			for ( var i = 0; i < store.local.chocosToAdd.length; i++) {
				store.local.chocosToAdd[i] = _object2EmberObject(store.local.chocosToAdd[i]);
			}

			//store.local.proxies = WsUtil.json2Proxies(store.local.proxies);
			//store.local.chocoStats = WsUtil.json2Stats(store.local.chocoStats);

			return store;
		} else {
			var emptyStore = {
				count : 0,
				chocos : {},
				proxies : [],
				chocoStats : [],
				local : {
					chocosToAdd : [],
					chocosToUpdate : [],
					chocosToRemove : [],
				}
			};
			return emptyStore;
		}
	};
	
	function _setStore(store) {
		localStorage.setItem("LsChoco", JSON.stringify(store));
	}

	function _object2EmberObject(object) {
		
		var choco = Choco.Class.create({
									id : object.id,
									shortDescription : object.shortDescription,
									description : object.description,
									userProxy : object.userProxy,
									status : object.status,
									localUpdate : object.localUpdate,
									localRemove : object.localRemove,
									localAdd : object.localAdd
		});
		
		return choco;
	}	
	
	/** Start of user code additional functions */
	/** End of user code */

	return LsChoco;
});
