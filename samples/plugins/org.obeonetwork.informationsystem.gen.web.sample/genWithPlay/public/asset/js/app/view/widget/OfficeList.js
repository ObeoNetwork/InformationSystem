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


	var OfficeList = {},
		templateName = "office-list",
		_Class = Em.CollectionView.extend();

	
	
	/* events */
	
	var editAction = function(e){
		
		e.preventDefault();
		var office = e.context;
		App.commonCtrl.editOffice(office);
	};
	
	var removeAction = function(e){
		
		e.preventDefault();
		var office = e.context;
		App.commonCtrl.removeOffice(office);
		//this.remove();
	};
	
	var _ItemClass = Em.View.extend({
		templateName : templateName, 
		editAction: editAction,
		removeAction: removeAction,
		/** Start of user code additional item features */
		/** End of user code */
	});
	
	
	/*
	 * create a list office widget
	 * @return the list office widget instance
	 */
	OfficeList.create = function() {
		ViewUtil.loadWidgetTemplate("./asset/template/widget/list/office-list");
		
		var view = _Class.create({
				
			content : [],
			paginationProxies : [],
			itemViewClass : _ItemClass,
			paginationWidgets : [],
			addPaginationWidget : function(paginationWidget) {
				this.paginationWidgets.push(paginationWidget);
			},
			loadContent : cb_loadOffices,
			//loadPagination : cb_loadProxies,
			paginationLink: paginationLink,
			didInsertElement : cb_whenInsert,
			paginationChange : cb_paginationChange,
			/** Start of user code additional features */
			/** End of user code */
		});
			 
		return view;
	};

	OfficeList.getClass = function() { return _Class; };
	
	/* events */
	var paginationLink = function(e){
		e.preventDefault();
		var paginationProxy = e.context;
		this.get('parentView').paginationChange(paginationProxy.id);
	};

	/*call backs*/
	var cb_whenInsert = function() {
		this.paginationChange(0);
	};

	var cb_paginationChange = function(pageId) {
		App.commonCtrl.loadOfficesInWidget(this, pageId);
	}

	var cb_loadOffices = function(offices) {

		this.set('content', offices);
	};

	/*var cb_loadProxies = function(paginationProxies) {
		
		if(paginationProxies.length>1)
			this.set('paginationProxies', paginationProxies);
		else
			this.set('paginationProxies', []);
	};*/
	
	/** Start of user code additional functions */
	/** End of user code */

	return OfficeList;
});
