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
/** End of user code */


	var OfficeManager = {};

	OfficeManager.async_all = function(cb_function) {
		
		var cb_Offices = function(Offices) {
			cb_function(Offices);
		};
		
		WsOffice.all(cb_Offices);
	};
	
	OfficeManager.async_allProxies = function(cb_function) {
		
		var cb_officeProxies = function(officeProxies) {
			cb_function(officeProxies);
		};
		
		WsOffice.allProxies(cb_officeProxies);
	};

	OfficeManager.async_countAll = function(cb_function) {
		
		var cb_countAllOffices = function(count) {
			cb_function(count);
		};
		
		WsOffice.countAllOffices(cb_countAllOffices);
	};
	
	OfficeManager.async_allByRows = function(cb_function, nbElemByRow, rowId) {
		
		var cb_allByRows = function(Offices) {
			cb_function(Offices);
		};
		
		WsOffice.allByRows(cb_allByRows, nbElemByRow, rowId);
	};
	
	OfficeManager.async_byId = function(cb_function, id) {
		
		var cb_office = function(office) {
			cb_function(office);
		};
		
		WsOffice.office(cb_office, id);
	};

	OfficeManager.async_stats = function(cb_function) {
		
		var cb_officeStats = function(office) {
			cb_function(office);
		};
		
		WsOffice.stats(cb_officeStats);
	};
	
	/** Start of user code additional functions */
	/** End of user code */

	return OfficeManager;
});
