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

	var PopupUser = {};
	
	var templateName = "user-popup";
	var templatePath = "popup/" + templateName;
	ViewUtil.loadWidgetTemplate(templatePath);
	
	var _Class = Em.View.extend({ templateName : templateName });
	
	/*
	 */
	PopupUser.create = function(user) {
		
		var view = _Class.create({
			user : user, 
			chocoLink: chocoLink,
			officeLink: officeLink,
			closeLink: closeLink
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

	return PopupUser;
});
