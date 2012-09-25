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
	
	var Pagination = {};
	
	var templateName = "pagination";
	var templatePath = "other/" + templateName;
	ViewUtil.loadWidgetTemplate(templatePath);
	
	var _Class = Em.View.extend({ templateName : templateName });
	
	/*
	 * create a Pagination widget
	 * @return the Pagination widget instance
	 */
	Pagination.create = function() {

		var view = _Class.create({
			paginationProxies : [],
			
			loadContent : cb_loadProxies,
			paginationLink: paginationLink
		});
		return view;
	};
	
	/* events */
	var paginationLink = function(e){
		e.preventDefault();
		var paginationProxy = e.context;
		this.get('parentView').paginationChange(paginationProxy.id);
	};

	/*call backs*/
	var cb_loadProxies = function(paginationProxies) {
		
		if(paginationProxies.length>1)
			this.set('paginationProxies', paginationProxies);
		else
			this.set('paginationProxies', []);
	};

	return Pagination;
});
