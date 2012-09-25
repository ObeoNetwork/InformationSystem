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
	
	var NavAccount = {};
	
	var templateName = "account-nav";
	var templatePath = "other/" + templateName;
	ViewUtil.loadWidgetTemplate(templatePath);
	
	var _Class = Em.View.extend({ templateName : templateName });
	
	/*
	 */
	NavAccount.create = function() {

		var view = _Class.create({
			
			account : undefined,
			
			didInsertElement : cb_whenInsert,
			loadContent : cb_loadAccount
		});
		
		return view;
	};
	
	NavAccount.getClass = function() { return _Class; };
	
	/*call backs*/
	var cb_loadAccount = function(account) {

		this.set('account', account);
	};

	var cb_whenInsert = function() {
		
	};
	
	return NavAccount;
});
