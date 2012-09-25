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
 * @version 0.9.1
 * @since 0.4
 */
define(["require", "app/App", "app/view/ViewUtil", "app/view/CommonEvents", "ember"], function(require) {

	/*__ Libs __*/
	var App = require("app/App");
	var ViewUtil = require("app/view/ViewUtil");
	var CommonEvents = require("app/view/CommonEvents");
	/*__ Libs __*/
	
	var OfficeList = {};
	
	var templateName = "office-list";
	var templatePath = "list/" + templateName;
	ViewUtil.loadWidgetTemplate(templatePath);
	
	var _Class = Em.CollectionView.extend();
	
	/* events */
	var editAction = function(e){
		
		e.preventDefault();
		var office = e.context;
		App.commonCtrl.editOffice(office);
	};
	
	var removeAction = function(e){
		
		e.preventDefault();
		var office = e.context;
		App.commonCtrl.removeChoco(office);
	};
	
	var _ItemClass = Em.View.extend({ 
		templateName : templateName,
		
		editAction: editAction,
		removeAction: removeAction
	});
	
	/*
	 * create a list office widget
	 * @return the list office widget instance
	 */
	OfficeList.create = function() {
		
		var view = _Class.create({
			
				content : [],
				itemViewClass : _ItemClass,
				
				loadContent : cb_loadOffices
		});
			 
		return view;
	};
	
	OfficeList.getClass = function() { return _Class; };
	
	/*call backs*/
	var cb_loadOffices = function(offices) {

		this.set('content', offices);
	};
	
	return OfficeList;
});
