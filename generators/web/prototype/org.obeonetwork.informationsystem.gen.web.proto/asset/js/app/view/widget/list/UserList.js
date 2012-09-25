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
 * @since 0.5
 */
define(["require", "app/App", "app/view/ViewUtil", "app/view/CommonEvents", "ember"], function(require) {

	/*__ Libs __*/
	var App = require("app/App");
	var ViewUtil = require("app/view/ViewUtil");
	var CommonEvents = require("app/view/CommonEvents");
	/*__ Libs __*/
	
	var UserList = {};
	
	var templateName = "user-list";
	var templatePath = "list/" + templateName;
	ViewUtil.loadWidgetTemplate(templatePath);
	
	var _Class = Em.CollectionView.extend();
	
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
	
	var editAction = function(e){
		
		e.preventDefault();
		var user = e.context;
		App.commonCtrl.editUser(user);
	};
	
	var removeAction = function(e){
		
		e.preventDefault();
		var user = e.context;
		App.commonCtrl.removeChoco(user);
	};
	
	var _ItemClass = Em.View.extend({
		templateName : templateName, 
		chocoLink: chocoLink,
		officeLink: officeLink,
		editAction: editAction,
		removeAction: removeAction
	});
	
	
	/*
	 * create a list user widget
	 * @return the list user widget instance
	 */
	UserList.create = function() {
		
		var view = _Class.create({
				
			content : [],
			itemViewClass : _ItemClass,
			
			loadContent : cb_loadUsers
		});
			 
		return view;
	};

	UserList.getClass = function() { return _Class; };
	
	/*call backs*/
	var cb_loadUsers = function(users) {

		this.set('content', users);
	};
	
	return UserList;
});
