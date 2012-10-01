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

	OfficeManager.async_all = function(cb_function) {
		
		var cb_offices = function(offices) {
			/** Start of user code cb_offices */
			cb_function(offices);
			/** End of user code */
		};
		
		WsOffice.all(cb_offices);
	};

	OfficeManager.all = function(cb_function) {
		/** Start of user code default all */
		var store = LsOffice.getStore();
		var offices = store.offices;
		cb_function(offices);
		/** End of user code */
	};
	

	OfficeManager.async_allProxies = function(cb_function) {
		
		var cb_officeProxies = function(officeProxies) {
			/** Start of user code cb_officeProxies */
			LsOffice.storeProxies(officeProxies);
			cb_function(officeProxies);
			/** End of user code */
		};
		
		WsOffice.allProxies(cb_officeProxies);
	};

	OfficeManager.allProxies = function(cb_function) {
		/** Start of user code default allProxies */
		var store = LsOffice.getStore();
		var proxies = store.proxies;
		cb_function(proxies);
		/** End of user code */
	};


	OfficeManager.async_countAll = function(cb_function) {
		
		var cb_countAlloffices = function(count) {
			/** Start of user code cb_countAlloffices */
			cb_function(count);
			/** End of user code */
		};
		
		WsOffice.countAllOffices(cb_countAlloffices);
	};

	OfficeManager.countAll = function(cb_function) {
		/** Start of user code default countAll */
		var store = LsOffice.getStore();
		var count = 0;
	    for(var loffice in store.loffices)
	    {
	        count++;
	    }
		cb_function(count)
		/** End of user code */
	};

	
	OfficeManager.async_allByRows = function(cb_function, nbElemByRow, rowId) {
		
		var cb_allByRows = function(offices) {
			/** Start of user code cb_allByRows */
			LsOffice.storeOffices(offices);
			cb_function(offices);
			/** End of user code */
			
		};
		
		WsOffice.allByRows(cb_allByRows, nbElemByRow, rowId);
	};

	OfficeManager.allByRows = function(cb_function, nbElemByRow, rowId) {
		/** Start of user code default allByRows */
		var store = LsOffice.getStore();
		var offices = store.offices;
		var officesToAdd = store.local.officesToAdd;
		
		var officesLength = officesToAdd.length;
	    for(var office in offices) {
	    	officesLength++;
	    }
		var result = [];
		var from = Math.max(rowId*nbElemByRow, 0);
		var to = Math.min(rowId*nbElemByRow+nbElemByRow, officesLength);
		
		for ( var i = 0; i < officesToAdd.length; i++) {
			result.push(officesToAdd[i]);
		}
		
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
			LsOffice.storeOffice(office);
			cb_function(office);
			/** End of user code */
		};
		
		WsOffice.office(cb_office, id);
	};

	OfficeManager.byId = function(cb_function, id) {
		/** Start of user code default byId */
		/** End of user code */
	};


	OfficeManager.async_stats = function(cb_function) {
		
		var cb_officeStats = function(offices) {
			/** Start of user code cb_officeStats */
			cb_function(offices);
			/** End of user code */
		};
		
		WsOffice.stats(cb_officeStats);
	};

	OfficeManager.stats = function(cb_function) {
		/** Start of user code default stats */
		var store = LsOffice.getStore();
		cb_function(store.officeStats);
		/** End of user code */
	};

	// REMOVE
	OfficeManager.async_remove = function(cb_function, office) {
		
		var cb_remove = function() {
			LsOffice.removeOffice(office);
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
			LsOffice.updateOffice(office);
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
		//TODO WArning bug?
		var cb_add = function() {
			LsOffice.storeOffice(office);
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
