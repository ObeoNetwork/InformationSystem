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
 * @version 0.2
 * 
 */
define(["require", "app/App", "app/ctrl/commonCtrl", "app/ctrl/homeCtrl", "bs", "ember"], function(require) {
	
	var App = require("app/App");
	var commonCtrl = require("app/ctrl/commonCtrl");
	var homeCtrl = require("app/ctrl/homeCtrl");
	
	/* Initialize all sub controllers
	 */
	function _init() {
		
		
		
		App.debug = true;
		App.commonCtrl = commonCtrl;
		App.homeCtrl = homeCtrl;
		
		App.commonCtrl.start();
		App.homeCtrl.start();

	}

	function start() {
		_init();
	}

	start();
});
