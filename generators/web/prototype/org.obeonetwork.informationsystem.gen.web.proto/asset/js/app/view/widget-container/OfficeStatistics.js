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
 * @version 1.0
 * @since 0.4
 */
define(["require", "app/App", "app/view/widget/list/OfficeList", "app/view/widget/form/NewOffice", "app/view/widget/other/Pagination", "ember"], function(require) {
	
	/*__ Libs __*/
	var App = require("app/App");
	var Pagination = require("app/view/widget/other/Pagination");
	var OfficeList = require("app/view/widget/list/OfficeList");
	var NewOffice = require("app/view/widget/form/NewOffice");
	/*__ Libs __*/
	
	var OfficeStatistics = {};
	
	var templateName = "office-statistics";
	
	var _Class = Em.ContainerView.extend({ classNames: [templateName] });
	
	/*
	 * create a statistics View
	 * @return the view instance
	 */
	OfficeStatistics.create = function() {
		
		var officeList = OfficeList.create();
		var paginationTop = Pagination.create();
		var paginationBottom = Pagination.create();
		
		var newOffice = NewOffice.create();
		
		var view = _Class.create({
			    
			    childViews: ['newOffice', 'paginationTop', 'officeList', 'paginationBottom'],
			  	newOffice: newOffice,
			    officeList: officeList,
			    paginationTop: paginationTop,
			    paginationBottom: paginationBottom,
			    
			    didInsertElement : cb_whenInsert,
			    paginationChange : cb_paginationChange
		});
		
		return view;
	};
	
	
	/*call backs*/
	var cb_whenInsert = function() {
		
		this.paginationChange();
	};
	
	var cb_paginationChange = function(pageId) {
		
		App.homeCtrl.loadOfficesInWidget(this.officeList, [this.paginationTop, this.paginationBottom], pageId);
	}
	
	return OfficeStatistics;
});
