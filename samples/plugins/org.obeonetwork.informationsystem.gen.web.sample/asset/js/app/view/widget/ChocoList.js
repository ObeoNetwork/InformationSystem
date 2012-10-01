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
 * @since 0.5.0
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


	var ChocoList = {},
		templateName = "choco-list",
		_Class = Em.CollectionView.extend();

	
	
	/* events */
	var userLink = function(e){
		e.preventDefault();
		var userProxy = e.context;
		App.commonCtrl.showModalUser(userProxy.id);
	};
	
	var editAction = function(e){
		
		e.preventDefault();
		var choco = e.context;
		App.commonCtrl.editChoco(choco);
	};
	
	var removeAction = function(e){
		
		e.preventDefault();
		var choco = e.context;
		App.commonCtrl.removeChoco(choco);
		//this.remove();
	};
	
	var _ItemClass = Em.View.extend({
		templateName : templateName, 
		userLink: userLink,
		editAction: editAction,
		removeAction: removeAction,
		/** Start of user code additional item features */
		/** End of user code */
	});
	
	
	/*
	 * create a list choco widget
	 * @return the list choco widget instance
	 */
	ChocoList.create = function() {
		ViewUtil.loadWidgetTemplate("./asset/template/widget/list/choco-list");
		
		var view = _Class.create({
				
			content : [],
			itemViewClass : _ItemClass,
			
			loadContent : cb_loadChocos,
			/** Start of user code additional features */
			/** End of user code */
		});
			 
		return view;
	};

	ChocoList.getClass = function() { return _Class; };
	
	/*call backs*/
	var cb_loadChocos = function(chocos) {

		this.set('content', chocos);
	};
	
	/** Start of user code additional functions */
	/** End of user code */

	return ChocoList;
});
