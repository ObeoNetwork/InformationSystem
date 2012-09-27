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
define(["require", "app/ws/WsOffice" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var WsOffice = require("app/ws/WsOffice");
	var localStorageEnable = (typeof(Storage)!=="undefined");
/** End of user code */


	var OfficeManager = {};

	OfficeManager.async_all = function(cb_function) {
		
		var cb_Offices = function(Offices) {
			/** Start of user code cb_Offices */
			_storeOffices(Offices);
			cb_function(Offices);
			/** End of user code */
		};
		
		WsOffice.all(cb_Offices);
	};

	OfficeManager.all = function(cb_function) {
		/** Start of user code default all */
		var store = _getStore();
		var offices = store.offices;
		cb_function(offices);
		/** End of user code */
	};
	

	OfficeManager.async_allProxies = function(cb_function) {
		
		var cb_officeProxies = function(officeProxies) {
			/** Start of user code cb_officeProxies */
			_storeProxies(officeProxies);
			cb_function(officeProxies);
			/** End of user code */
		};
		
		WsOffice.allProxies(cb_officeProxies);
	};

	OfficeManager.allProxies = function(cb_function) {
		/** Start of user code default allProxies */
		var store = _getStore();
		var proxies = store.proxies;
		cb_function(proxies);
		/** End of user code */
	};


	OfficeManager.async_countAll = function(cb_function) {
		
		var cb_countAllOffices = function(count) {
			/** Start of user code cb_countAllOffices */
			cb_function(count);
			/** End of user code */
		};
		
		WsOffice.countAllOffices(cb_countAllOffices);
	};

	OfficeManager.countAll = function(cb_function) {
		/** Start of user code default countAll */
		var store = _getStore();
		var count = 0;
	    for(var office in store.offices)
	    {
	        count++;
	    }
		cb_function(count);
		/** End of user code */
	};

	
	OfficeManager.async_allByRows = function(cb_function, nbElemByRow, rowId) {
		
		var cb_allByRows = function(Offices) {
			/** Start of user code cb_allByRows */
			_storeOffices(Offices);
			cb_function(Offices);
			/** End of user code */
			
		};
		
		WsOffice.allByRows(cb_allByRows, nbElemByRow, rowId);
	};

	OfficeManager.allByRows = function(cb_function, nbElemByRow, rowId) {
		/** Start of user code default allByRows */
		var store = _getStore();
		var offices = store.offices;
		
		var officesLength = 0;
	    for(var office in offices) {
	    	officesLength++;
	    }
		var result = [];
		var from = Math.max(rowId*nbElemByRow, 0);
		var to = Math.min(rowId*nbElemByRow+nbElemByRow, officesLength);
		
		var i = 0;
		for(var officeId in offices) {
			if(i >= from && i < to){
				result.push(offices[officeId]);
			}
			i++;
		}
		cb_function(result);
		/** End of user code */
	};
	

	OfficeManager.async_byId = function(cb_function, id) {
		
		var cb_office = function(office) {
			/** Start of user code cb_office */
			_storeOffice(office);
			cb_function(office);
			/** End of user code */
		};
		
		WsOffice.office(cb_office, id);
	};

	OfficeManager.byId = function(cb_function, id) {
		/** Start of user code default byId */
		var store = _getStore();
		cb_function(store.offices[id]);
		/** End of user code */
	};


	OfficeManager.async_stats = function(cb_function) {
		
		var cb_officeStats = function(Offices) {
			/** Start of user code cb_officeStats */
			_storeOfficeStats(Offices);
			cb_function(Offices);
			/** End of user code */
		};
		
		WsOffice.stats(cb_officeStats);
	};

	OfficeManager.stats = function(cb_function) {
		/** Start of user code default stats */
		var store = _getStore();
		cb_function(store.officeStats);
		/** End of user code */
	};
	
	/** Start of user code additional functions */
	
	function _getStore() {
		var storeBrut = localStorage.getItem("OfficeManager");
		if(typeof(storeBrut)!=="undefined" ) {
			var store = JSON.parse(storeBrut);
			return store;
		} else {
			var emptyStore = {
				count : 0,
				proxies : {},
				offices : {},
				officeStats : {},
				local : {
					officesToAdd : {},
					officesToUpdate : {},
					officesToRemove : {},
				}
			};
			return emptyStore;
		}
	};
	
	function _setStore(store) {
		localStorage.setItem("OfficeManager", JSON.stringify(store));
	}
	
	function _storeOffices(offices) {
		var store = _getStore();
		for ( var i = 0; i < offices.length; i++) {
			var office = offices[i];
			store.offices[office.id] = office;
		}
		_setStore(store);
	}
	
	function _storeProxies(proxies) {
		var store = _getStore();
		for ( var i = 0; i < proxies.length; i++) {
			var proxy = proxies[i];
			store.proxies[proxy.id] = proxies;
		}
		_setStore(store);
	}
	
	function _storeOfficeStats(officeStats) {
		var store = _getStore();
		store.officeStats = officeStats;
		_setStore(store);
	}
	
	function _storeOffice(office) {
		var store = _getStore();
		store.offices[office.id] = office;
		_setStore(store);
	}
	
	function _removeOffice(office) {
		var store = _getStore();
		store.offices[office.id] = undefined;
		_setStore(store);
	}

	
	
	function _localUpdateOffice(office) {
		var store = _getStore();
		_storeOffice(office);
		store.local.officesToUpdate[office.id] = office;
		_setStore(store);
	}
	
	function _localStoreOffice(office) {
		var store = _getStore();
		_storeOffice(office);
		store.local.officesToAdd[office.id] = office;
		_setStore(store);
	}
	
	function _localRemoveOffice(office) {
		var store = _getStore();
		_removeOffice(office);
		store.local.officesToRemove[office.id] = office;
		_setStore(store);
	}
	/** End of user code */

	return OfficeManager;
});
