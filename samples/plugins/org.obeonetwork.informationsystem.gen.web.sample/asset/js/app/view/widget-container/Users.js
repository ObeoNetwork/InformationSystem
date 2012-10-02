
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
define(["require", "app/App", "app/view/widget/Pagination", "app/view/widget/NewUser", "app/view/widget/UserStats", "app/view/widget/UserList", "ember" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var App = require("app/App"),
		Pagination = require("app/view/widget/Pagination"),
		NewUser = require("app/view/widget/NewUser"),
		UserStats = require("app/view/widget/UserStats"),
		UserList = require("app/view/widget/UserList");
	// ember does not need to be stored in a variable.
/** End of user code */

	
	var Users = {};
	
	var templateName = "users";
	
	var _Class = Em.ContainerView.extend({ classNames: [templateName] });
	
	/*
	 * create an incoming choco View
	 * @return the view instance
	 */
	Users.create = function() {
		/** Start of user code default init widgets */
		var createUserForm = NewUser.create();
		var usersByOffice = UserStats.create();
		var userList = UserList.create();
		var userListPrePagination = Pagination.create(userList);
		userList.addPaginationWidget(userListPrePagination);

		var userListPostPagination = Pagination.create(userList);
		userList.addPaginationWidget(userListPostPagination);
		
		/** End of user code */

		var view = _Class.create({
			/** Start of user code default sub widgets */
			childViews: [
						'createUserForm',
						'usersByOffice',
						'userListPrePagination',
						'userList',
						'userListPostPagination',
						],
			createUserForm : createUserForm,
			usersByOffice : usersByOffice,
			userListPrePagination : userListPrePagination,
			userList : userList,
			userListPostPagination : userListPostPagination,
			/** End of user code */

			/** Start of user code additional features */
			/** End of user code */
		});
		
		return view;
		
	};

	
	/** Start of user code additional functions */
	/** End of user code */

	return Users;
});
