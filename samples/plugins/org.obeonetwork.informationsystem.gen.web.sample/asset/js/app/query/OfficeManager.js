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
define(["require", "app/ws/WsOffice", "app/ls/LsOffice" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var WsOffice = require("app/ws/WsOffice"),
		LsOffice = require("app/ls/LsOffice");
/** End of user code */


	var OfficeManager = {},
		lsEnable = (typeof(Storage)!=="undefined");

	OfficeManager.toOnlineProcess = function() {
		var store = LsOffice.getStore();
		var officesToAdd = store.local.officesToAdd;
		for(var i=0; i<officesToAdd.length; i++) {
			OfficeManager.async_add(function(){}, officesToAdd[i]);
		}

		var offices = store.offices;
		var officesToRemove = store.local.officesToRemove;
		var officesToUpdate = store.local.officesToUpdate;

		for(var i=0; i<officesToRemove.length; i++) {
			var id = officesToRemove[i];
			OfficeManager.async_remove(function(){}, offices[id]);
		}

		for(var i=0; i<officesToUpdate.length; i++) {
			var id = officesToUpdate[i];
			OfficeManager.async_update(function(){}, offices[id]);
		}
	};

	OfficeManager.async_all = function(cb_function) {
		
		var cb_offices = function(offices) {
			cb_function(offices);
		};
		
		WsOffice.all(cb_offices);
	};

	OfficeManager.all = function(cb_function) {
		var store = LsOffice.getStore();
		var offices = store.offices;
		cb_function(offices);
	};
	

	OfficeManager.async_allProxies = function(cb_function) {
		
		var cb_officeProxies = function(officeProxies) {
			LsOffice.storeProxies(officeProxies);
			cb_function(officeProxies);
		};
		
		WsOffice.allProxies(cb_officeProxies);
	};

	OfficeManager.allProxies = function(cb_function) {
		var store = LsOffice.getStore();
		var proxies = store.proxies;
		cb_function(proxies);
	};


	OfficeManager.async_countAll = function(cb_function) {
		
		var cb_countAlloffices = function(count) {
			cb_function(count);
		};
		
		WsOffice.countAllOffices(cb_countAlloffices);
	};

	OfficeManager.countAll = function(cb_function) {
		var store = LsOffice.getStore();
		var count = store.local.officesToAdd.length;
	    for(var office in store.offices)
	    {
	        count++;
	    }
		cb_function(count)
	};

	
	OfficeManager.async_allByRows = function(cb_function, nbElemByRow, rowId) {
		
		var cb_allByRows = function(offices) {
			LsOffice.storeOffices(offices);
			cb_function(offices);
			
		};
		
		WsOffice.allByRows(cb_allByRows, nbElemByRow, rowId);
	};

	OfficeManager.allByRows = function(cb_function, nbElemByRow, rowId) {
		var store = LsOffice.getStore();
		var offices = store.offices;
		var officesToAdd = store.local.officesToAdd;
		
		for ( var i = 0; i < officesToAdd.length; i++) {
			offices["_"+i] = officesToAdd[i];
		}

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
	};
	

	OfficeManager.async_byId = function(cb_function, id) {
		
		var cb_office = function(office) {
			LsOffice.storeOffice(office);
			cb_function(office);
		};
		
		WsOffice.office(cb_office, id);
	};

	OfficeManager.byId = function(cb_function, id) {
		/** Start of user code default byId */
		/** End of user code */
	};


	OfficeManager.async_stats = function(cb_function) {
		
		var cb_officeStats = function(stats) {
			LsOffice.storeOfficeStats(stats);
			cb_function(stats);
		};
		
		WsOffice.stats(cb_officeStats);
	};

	OfficeManager.stats = function(cb_function) {
		var store = LsOffice.getStore();
		cb_function(store.officeStats);
	};

	// REMOVE
	OfficeManager.async_remove = function(cb_function, office) {
		
		var cb_remove = function() {
			//LsOffice.removeOffice(office);
			cb_function();
		};
		var store = LsOffice.getStore();
		var officeStored = store.offices[office.id];
		WsOffice.remove(cb_remove, officeStored);
	};

	OfficeManager.remove = function(cb_function, office) {
		LsOffice.localRemoveOffice(office);
		cb_function();
	};
	
	// UPDATE
	OfficeManager.async_update = function(cb_function, office) {
		
		var cb_update = function() {
			//LsOffice.updateOffice(office);
			cb_function();
		};
		var store = LsOffice.getStore();
		var officeStored = store.offices[office.id];
		WsOffice.update(cb_update, officeStored);
	};

	OfficeManager.update = function(cb_function, office) {
		LsOffice.localUpdateOffice(office);
		cb_function();
	};
	
	
	// ADD
	OfficeManager.async_add = function(cb_function, office) {
		var cb_add = function() {
			//LsOffice.storeOffice(office);
			cb_function();
		};
		var store = LsOffice.getStore();
		var officeStored = store.offices[office.id];
		WsOffice.add(cb_add, officeStored);
	};

	OfficeManager.add = function(cb_function, office) {
		LsOffice.localStoreOffice(office);
		cb_function();
	};
	
	/** Start of user code additional functions */
	/** End of user code */

	return OfficeManager;
});
