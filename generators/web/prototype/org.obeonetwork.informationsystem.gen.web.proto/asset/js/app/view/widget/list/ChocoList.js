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
	
	var ChocoList = {};

	var templateName = "choco-list";
	var templatePath = "list/" + templateName;
	ViewUtil.loadWidgetTemplate(templatePath);
	
	var _Class = Em.CollectionView.extend();
	
	/* events */
	var userLink = function(e){
		e.preventDefault();
		var userProxy = e.context;
		App.commonCtrl.showModalUser(userProxy.id);
	};
	
	var plusAction = function(e){
		
		e.preventDefault();
		App.toast.warning("Server not implemented yet. Sorry!");
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
	};
	
	var _ItemClass = Em.View.extend({
		templateName : templateName,
		
		userLink: userLink,
		plusAction: plusAction,
		editAction: editAction,
		removeAction: removeAction
	});
	
	/*
	 * create a list choco widget
	 * @return the list choco widget instance
	 */
	ChocoList.create = function() {
		
		var view = _Class.create({
			
				content : [],
				itemViewClass : _ItemClass,
				
				loadContent : cb_loadChocos
		});
			 
		return view;
	};

	ChocoList.getClass = function() { return _Class; };
	
	/*call backs*/
	var cb_loadChocos = function(chocos) {
		
		this.set('content', chocos);
	};
	
	return ChocoList;
});