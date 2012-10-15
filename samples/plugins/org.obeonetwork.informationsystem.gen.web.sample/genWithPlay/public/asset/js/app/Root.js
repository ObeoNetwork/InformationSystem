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
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/App", "app/ctrl/CommonCtrl", "app/ctrl/HomeCtrl", "app/ctrl/AdminCtrl", "bs", "ember" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var App = require("app/App"),
		CommonCtrl = require("app/ctrl/CommonCtrl"),
		HomeCtrl = require("app/ctrl/HomeCtrl"),
		AdminCtrl = require("app/ctrl/AdminCtrl");
	// bs does not need to be stored in a variable.
	// ember does not need to be stored in a variable.
/** End of user code */


	/* Initialize all sub controllers
	 */
	function _init() {

		App.commonCtrl = CommonCtrl;
		App.commonCtrl.start();
		
		App.ctrl = HomeCtrl;
		App.ctrl.start();

		/** Start of user code default ctrl event */
		$(".nav a.home").click(function(event) {
			event.preventDefault(); // prevent the standard link click
			if(!$(this).parent().hasClass('active')) {
				_changeActiveMenu('home');
				App.ctrl.stop();
				App.ctrl = HomeCtrl;
				App.ctrl.start();
			}
		});

		$(".nav a.admin").click(function(event) {
			event.preventDefault(); // prevent the standard link click
			if(!$(this).parent().hasClass('active')) {
				_changeActiveMenu('admin');
				App.ctrl.stop();
				App.ctrl = AdminCtrl;
				App.ctrl.start();
			}
		});

		/** End of user code */
	}

	function _changeActiveMenu(cssClass) {
	/** Start of user code default _changeActiveMenu */
		var node = $(".nav a."+cssClass);
		$(".nav li").removeClass("active");
		$(node).parent("li").addClass("active");
	/** End of user code */
	}

	function start() {
	/** Start of user code default start */
		_init();
	/** End of user code */
	}

	start();
});
