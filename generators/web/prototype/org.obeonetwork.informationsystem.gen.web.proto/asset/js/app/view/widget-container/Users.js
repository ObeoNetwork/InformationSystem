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
define(["require", "app/App", "app/view/widget/list/UserList", "app/view/widget/form/NewUser", "app/view/widget/other/Pagination", "ember"], function(require) {
	
	/*__ Libs __*/
	var App = require("app/App");
	var Pagination = require("app/view/widget/other/Pagination");
	var UserList = require("app/view/widget/list/UserList");
	var NewUser = require("app/view/widget/form/NewUser");
	/*__ Libs __*/
	
	var Users = {};
	
	var templateName = "users";
	
	var _Class = Em.ContainerView.extend({ classNames: [templateName] });
	
	/*
	 * create an incoming choco View
	 * @return the view instance
	 */
	Users.create = function(users) {
		
		var userList = UserList.create();
		var paginationTop = Pagination.create();
		var paginationBottom = Pagination.create();
		
		var newUser = NewUser.create();
		
		var view = _Class.create({
			    
			    childViews: ['newUser', 'paginationTop', 'userList', 'paginationBottom'],
			    newUser: newUser,
			    userList: userList,
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
		
		App.homeCtrl.loadUsersInWidget(this.userList, [this.paginationTop, this.paginationBottom], pageId);
	}
	
	return Users;
});
