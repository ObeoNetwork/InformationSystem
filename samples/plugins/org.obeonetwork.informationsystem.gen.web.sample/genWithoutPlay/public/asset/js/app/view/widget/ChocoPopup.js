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


	var ChocoPopup = {},
		_Class = Em.View.extend({ templateName : "choco-popup" });

	
	
	/*
	 */
	ChocoPopup.create = function(choco) {
		ViewUtil.loadWidgetTemplate("./asset/template/widget/popup/choco-popup");
		
		var view = _Class.create({
			choco : choco,
			userLink: userLink,
			closeLink: closeLink,
			/** Start of user code additional features */
			/** End of user code */
		});
		
		return view;
	};

	/* events */
	var userLink = function(e){
		
		e.preventDefault();
		var userProxy = e.context;
		App.commonCtrl.showModalUser(userProxy.id);
	};
	
	var closeLink = function(e){
		
		e.preventDefault();
		App.commonCtrl.hideModal();
	};
	
	/** Start of user code additional functions */
	/** End of user code */

	return ChocoPopup;
});
