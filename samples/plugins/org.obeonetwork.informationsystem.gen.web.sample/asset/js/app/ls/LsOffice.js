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
 * define a webservice API for the office entity.
 * we use JQuery REST API. In consequence, we are in an asynchrone context.
 * All functions must define a call back function that will run at the end
 * of the REST query.
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/model/Office", "app/ws/WsUtil" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var Office = require("app/model/Office"),
		WsUtil = require("app/ws/WsUtil");
/** End of user code */

	
	var LsOffice = {};

	LsOffice.getStore = function() {
		return _getStore();
	};
	
	LsOffice.setStore = function(store) {
		 _setStore(store);
	}
	
	LsOffice.storeOffices = function(offices) {
		var store = _getStore();
		for ( var i = 0; i < offices.length; i++) {
			var office = offices[i];
			office.set('localUpdate', false);
			office.set('localRemove', false);
			office.set('localAdd', false);
			store.offices[office.id] = office;
		}
		_setStore(store);
	}
	
	LsOffice.storeProxies = function(proxies) {
		var store = _getStore();
		for ( var i = 0; i < proxies.length; i++) {
			var proxy = proxies[i];
			store.proxies[i] = proxy;
		}
		_setStore(store);
	}
	
	LsOffice.storeOfficeStats = function(officeStats) {
		var store = _getStore();
		store.officeStats = officeStats;
		_setStore(store);
	}
	
	LsOffice.storeOffice = function(office) {
		var store = _getStore();
		office.set('localUpdate', false);
		office.set('localRemove', false);
		office.set('localAdd', false);
		store.offices[office.id] = office;
		_setStore(store);
	}
	
	LsOffice.removeOffice = function(office) {
		var store = _getStore();
		store.offices[office.id] = undefined;
		_setStore(store);
	}

	
	
	LsOffice.localUpdateOffice = function(office) {
		var store = _getStore();
		office.set('localUpdate', true);
		store.offices[office.id] = office;
		store.local.officesToUpdate.push(office.id);
		_setStore(store);
	}
	
	LsOffice.localStoreOffice = function(office) {
		var store = _getStore();
		office.set('localAdd', true);
		store.local.officesToAdd.push(office);
		_setStore(store);
	}
	
	LsOffice.localRemoveOffice = function(office) {
		var store = _getStore();
		office.set('localRemove', true);
		store.offices[office.id] = office;
		store.local.officesToRemove.push(office.id);
		_setStore(store);
	}
	
	function _getStore() {
		var storeBrut = localStorage.getItem("LsOffice");
		if(typeof(storeBrut)!=="undefined" && storeBrut!==null ) {
			var store = JSON.parse(storeBrut);
			var officesBrut = store.offices;
			var offices = {};
			for ( var id in officesBrut) {
				var officeBrut = officesBrut[id];
				offices[id] = _object2EmberObject(officeBrut);
			}
			store.offices = offices;
			
			for ( var i = 0; i < store.local.officesToAdd.length; i++) {
				store.local.officesToAdd[i] = _object2EmberObject(store.local.officesToAdd[i]);
			}

			//store.local.proxies = WsUtil.json2Proxies(store.local.proxies);
			//store.local.officeStats = WsUtil.json2Stats(store.local.officeStats);

			return store;
		} else {
			var emptyStore = {
				count : 0,
				offices : {},
				proxies : [],
				officeStats : [],
				local : {
					officesToAdd : [],
					officesToUpdate : [],
					officesToRemove : [],
				}
			};
			return emptyStore;
		}
	};
	
	function _setStore(store) {
		localStorage.setItem("LsOffice", JSON.stringify(store));
	}

	function _object2EmberObject(object) {
		
		var office = Office.Class.create({
									id : object.id,
									shortDescription : object.shortDescription,
									description : object.description,
									localUpdate : object.localUpdate,
									localRemove : object.localRemove,
									localAdd : object.localAdd
		});
		
		return office;
	}	
	
	/** Start of user code additional functions */
	/** End of user code */

	return LsOffice;
});
