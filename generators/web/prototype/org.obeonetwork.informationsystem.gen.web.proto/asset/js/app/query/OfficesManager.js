/*******************************************************************************
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

/*
 * @autor hugo.marchadour@obeo.fr
 * @version 0.9
 * @since 0.8
 */
define(["require", "app/ws/WsOffice"], function(require) {
	
	/*__ Libs __*/
	var WsOffice = require("app/ws/WsOffice");
	/*__ Libs __*/
	
	OfficesManager = {};

	OfficesManager.async_all = function(cb_function) {
		
		var cb_offices = function(offices) {
			cb_function(offices);
		};
		
		WsOffice.all(cb_offices);
	}
	
	OfficesManager.async_allProxies = function(cb_function) {
		
		var cb_officeProxies = function(officeProxies) {
			cb_function(officeProxies);
		};
		
		WsOffice.allProxies(cb_officeProxies);
	}
	
	OfficesManager.async_countAll = function(cb_function) {
		
		var cb_countAllOffices = function(count) {
			cb_function(count);
		};
		
		WsOffice.countAllOffices(cb_countAllOffices);
	}
	
	OfficesManager.async_allByRows = function(cb_function, nbElemByRow, rowId) {
		
		var cb_allByRows = function(offices) {
			cb_function(offices);
		};
		
		WsOffice.allByRows(cb_allByRows, nbElemByRow, rowId);
	}
	
	OfficesManager.async_byId = function(cb_function, id) {
		
		var cb_office = function(office) {
			cb_function(office);
		};
		
		WsOffice.office(cb_office, id);
	}

	return OfficesManager;
});
