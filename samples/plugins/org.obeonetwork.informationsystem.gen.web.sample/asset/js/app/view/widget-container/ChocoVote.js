
 /*******************************************************************************
 * Copyright (c) 2012 Obeo.
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
define(["require", "app/App", "app/view/widget/Pagination", "app/view/widget/NewChoco", "app/view/widget/ChocoList", "ember" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var App = require("app/App"),
		Pagination = require("app/view/widget/Pagination"),
		NewChoco = require("app/view/widget/NewChoco"),
		ChocoList = require("app/view/widget/ChocoList");
	// ember does not need to be stored in a variable.
/** End of user code */

	
	var ChocoVote = {};
	
	var templateName = "choco-vote";
	
	var _Class = Em.ContainerView.extend({ classNames: [templateName] });
	
	/*
	 * create an incoming choco View
	 * @return the view instance
	 */
	ChocoVote.create = function() {
		/** Start of user code default init widgets */
		var createChocoForm = NewChoco.create();
		var chocoList = ChocoList.create();
		var chocoListPrePagination = Pagination.create(chocoList);
		chocoList.addPaginationWidget(chocoListPrePagination);

		var chocoListPostPagination = Pagination.create(chocoList);
		chocoList.addPaginationWidget(chocoListPostPagination);
		
		/** End of user code */

		var view = _Class.create({
			/** Start of user code default sub widgets */
			childViews: [
						'createChocoForm',
						'chocoListPrePagination',
						'chocoList',
						'chocoListPostPagination',
						],
			createChocoForm : createChocoForm,
			chocoListPrePagination : chocoListPrePagination,
			chocoList : chocoList,
			chocoListPostPagination : chocoListPostPagination,
			/** End of user code */

			/** Start of user code additional features */
			/** End of user code */
		});
		
		return view;
		
	};

	
	/** Start of user code additional functions */
	/** End of user code */

	return ChocoVote;
});
