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
 * @version 0.5
 * @since 0.5
 */
define(["require", "app/App", "app/view/ViewUtil", "app/view/CommonEvents", "ember"], function(require) {

	/*__ Libs __*/
	var App = require("app/App");
	var ViewUtil = require("app/view/ViewUtil");
	var CommonEvents = require("app/view/CommonEvents");
	/*__ Libs __*/
	
	var SignIn = {};
	
	var templateName = "sign-in";
	ViewUtil.loadWidgetTemplate(templateName);
	
	var _Class = Em.View.extend({ templateName : templateName });
	
	/*
	 */
	SignIn.create = function() {
		
		var view = _Class.create({
			
			didInsertElement : cb_whenInsert,
			click: ev_onClick
		});
		
		return view;
	};
	
	/* events */
	var ev_onClick = function(event) {
		
		event.preventDefault();
		//CommonEvents.onClickModel(event);
		//CommonEvents.closeModal(event);
	}
	
	/*call backs*/
	var cb_whenInsert = function() {
	};
	
	return SignIn;
});
