
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
define(["require", "app/App", "app/view/widget/NewChoco", "app/view/widget/Pagination", "app/view/widget/ChocoList", "ember" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var App = require("app/App"),
		NewChoco = require("app/view/widget/NewChoco"),
		Pagination = require("app/view/widget/Pagination"),
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
		var paginationChocoTop = Pagination.create();
		var chocoList = ChocoList.create();
		var paginationChocoBottom = Pagination.create();
		/** End of user code */

		var view = _Class.create({
			/** Start of user code default sub widgets */
			childViews: ['createChocoForm', 'paginationChocoTop', 'chocoList', 'paginationChocoBottom'],
			createChocoForm : createChocoForm,
			paginationChocoTop : paginationChocoTop,
			chocoList : chocoList,
			paginationChocoBottom : paginationChocoBottom,
			/** End of user code */

			didInsertElement : cb_whenInsert,
			/** Start of user code additional features */
			/** End of user code */
			paginationChange : cb_paginationChange
		});
		
		return view;
		
	};

	/*call backs*/
	var cb_whenInsert = function() {
		
		this.paginationChange();
	};
	
	var cb_paginationChange = function(pageId) {
		App.commonCtrl.loadChocosInWidget(this.chocoList, [this.paginationChocoTop, this.paginationChocoBottom], pageId);
	}
	
	/** Start of user code additional functions */
	/** End of user code */

	return ChocoVote;
});
