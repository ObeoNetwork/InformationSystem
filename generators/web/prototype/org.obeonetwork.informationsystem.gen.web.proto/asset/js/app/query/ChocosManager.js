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
define(["require", "app/ws/WsChoco"], function(require) {
	
	/*__ Libs __*/
	var WsChoco = require("app/ws/WsChoco");
	/*__ Libs __*/
	
	ChocosManager = {};

	ChocosManager.async_all = function(cb_function) {
		
		var cb_chocos = function(chocos) {
			cb_function(chocos);
		};
		
		WsChoco.all(cb_chocos);
	}
	
	ChocosManager.async_allProxies = function(cb_function) {
		
		var cb_chocoProxies = function(chocoProxies) {
			cb_function(chocoProxies);
		};
		
		WsChoco.allProxies(cb_chocoProxies);
	}

	ChocosManager.async_countAll = function(cb_function) {
		
		var cb_countAllChocos = function(count) {
			cb_function(count);
		};
		
		WsChoco.countAllChocos(cb_countAllChocos);
	}
	
	ChocosManager.async_allByRows = function(cb_function, nbElemByRow, rowId) {
		
		var cb_allByRows = function(chocos) {
			cb_function(chocos);
		};
		
		WsChoco.allByRows(cb_allByRows, nbElemByRow, rowId);
	}
	
	ChocosManager.async_byId = function(cb_function, id) {
		
		var cb_choco = function(choco) {
			cb_function(choco);
		};
		
		WsChoco.choco(cb_choco, id);
	}
	
	return ChocosManager;
});
