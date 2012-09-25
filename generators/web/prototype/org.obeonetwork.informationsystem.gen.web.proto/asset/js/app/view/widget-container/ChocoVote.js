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
 * @since 0.3
 */
define(["require", "app/App", "app/view/widget/other/Pagination", "app/view/widget/list/ChocoList", "app/view/widget/form/NewChoco", "ember"], function (require) {

	/*__ Libs __*/
	var App = require("app/App");
	var Pagination = require("app/view/widget/other/Pagination");
	var ChocoList = require("app/view/widget/list/ChocoList");
	var NewChoco = require("app/view/widget/form/NewChoco");
	/*__ Libs __*/

	var ChocoVote = {};

	var templateName = "choco-vote";

	var _Class = Em.ContainerView.extend({ classNames: [templateName] });

	/*
	 * create a choco vote View
	 * @return the view instance
	 */
	ChocoVote.create = function() {

		var chocoList = ChocoList.create();
		var paginationTop = Pagination.create();
		var paginationBottom = Pagination.create();

		var newChoco = NewChoco.create();

		var view = _Class.create({

			    childViews: ['newChoco', 'paginationTop', 'chocoList', 'paginationBottom'],
			    newChoco: newChoco,
			    chocoList: chocoList,
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
		
		App.homeCtrl.loadChocosInWidget(this.chocoList, [this.paginationTop, this.paginationBottom], pageId);
	}
	
	return ChocoVote;
});
