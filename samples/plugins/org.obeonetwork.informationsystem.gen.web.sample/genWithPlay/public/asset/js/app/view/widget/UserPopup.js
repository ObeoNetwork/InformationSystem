 /*******************************************************************************
 * Copyright (c) 2012, 2016 Obeo.
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
 * @since 0.9.0
 * @generated
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/App", "app/view/ViewUtil", "app/view/CommonEvents", "ember" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var App = require("app/App"),
		ViewUtil = require("app/view/ViewUtil"),
		CommonEvents = require("app/view/CommonEvents");
	// ember does not need to be stored in a variable.
/** End of user code */


	var UserPopup = {},
		_Class = Em.View.extend({ templateName : "user-popup" });

	
	
	/*
	 */
	UserPopup.create = function(user) {
		ViewUtil.loadWidgetTemplate("./asset/template/widget/popup/user-popup");
		
		var view = _Class.create({
			user : user,
			chocoLink: chocoLink,
			officeLink: officeLink,
			closeLink: closeLink,
			/** Start of user code additional features */
			/** End of user code */
		});
		
		return view;
	};

	/* events */
	var chocoLink = function(e){
		
		e.preventDefault();
		var chocoProxy = e.context;
		App.commonCtrl.showModalChoco(chocoProxy.id);
	};
	var officeLink = function(e){
		
		e.preventDefault();
		var officeProxy = e.context;
		App.commonCtrl.showModalOffice(officeProxy.id);
	};
	
	var closeLink = function(e){
		
		e.preventDefault();
		App.commonCtrl.hideModal();
	};
	
	/** Start of user code additional functions */
	/** End of user code */

	return UserPopup;
});
