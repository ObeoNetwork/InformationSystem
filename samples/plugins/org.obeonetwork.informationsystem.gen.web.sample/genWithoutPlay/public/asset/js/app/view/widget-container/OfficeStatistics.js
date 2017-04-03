
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
 * @since 0.4.0
 * @generated
 */

/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/App", "app/view/widget/Pagination", "app/view/widget/NewOffice", "app/view/widget/OfficeList", "ember" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var App = require("app/App"),
		Pagination = require("app/view/widget/Pagination"),
		NewOffice = require("app/view/widget/NewOffice"),
		OfficeList = require("app/view/widget/OfficeList");
	// ember does not need to be stored in a variable.
/** End of user code */

	
	var OfficeStatistics = {};
	
	var templateName = "office-statistics";
	
	var _Class = Em.ContainerView.extend({ classNames: [templateName] });
	
	/*
	 * create an incoming choco View
	 * @return the view instance
	 */
	OfficeStatistics.create = function() {
		/** Start of user code default init widgets */
		var createOfficeForm = NewOffice.create();
		var officeList = OfficeList.create();
		var officeListPrePagination = Pagination.create(officeList);
		officeList.addPaginationWidget(officeListPrePagination);

		var officeListPostPagination = Pagination.create(officeList);
		officeList.addPaginationWidget(officeListPostPagination);
		
		/** End of user code */

		var view = _Class.create({
			/** Start of user code default sub widgets */
			childViews: [
						'createOfficeForm',
						'officeListPrePagination',
						'officeList',
						'officeListPostPagination',
						],
			createOfficeForm : createOfficeForm,
			officeListPrePagination : officeListPrePagination,
			officeList : officeList,
			officeListPostPagination : officeListPostPagination,
			/** End of user code */

			/** Start of user code additional features */
			/** End of user code */
		});
		
		return view;
		
	};

	
	/** Start of user code additional functions */
	/** End of user code */

	return OfficeStatistics;
});
