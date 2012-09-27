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
define(["require", "app/App", "app/view/CommonEvents", "app/view/widget/AccountNav", "app/security/LogManager", "app/view/widget/EditChoco", "app/view/widget/EditUser", "app/view/widget/EditOffice", "app/view/widget/ChocoPopup", "app/view/widget/UserPopup", "app/view/widget/OfficePopup" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var App = require("app/App"),
		CommonEvents = require("app/view/CommonEvents"),
		AccountNav = require("app/view/widget/AccountNav"),
		LogManager = require("app/security/LogManager"),
		EditChoco = require("app/view/widget/EditChoco"),
		EditUser = require("app/view/widget/EditUser"),
		EditOffice = require("app/view/widget/EditOffice"),
		ChocoPopup = require("app/view/widget/ChocoPopup"),
		UserPopup = require("app/view/widget/UserPopup"),
		OfficePopup = require("app/view/widget/OfficePopup");
/** End of user code */


	
	var CommonPage = {};
	var oldView = undefined;
	var viewAccountNav = undefined;
	
	/**/
	function _init() {
		
		CommonEvents.start();
	}

	/**/
	CommonPage.start = function() {
		
		_init();
	};
	
	/**/
	CommonPage.renderDefault = function() {
		
		$(".page").attr('id', 'default');
		_renderDefault();
		_renderLoaded();
	};
	
	/**/
	CommonPage.renderUserFeatures = function() {
		
		$(".page").attr('id', 'sign-in');
		_renderUserFeatures();
		_renderLoaded();
	};
	
	/**/
	CommonPage.renderModeratorFeatures = function() {
		
		$(".page").attr('id', 'moderator');
		_renderModeratorFeatures();
		_renderLoaded();
	};
	
	/**/
	CommonPage.renderAdminFeatures = function() {
		
		$(".page").attr('id', 'admin');
		_renderAdminFeatures();
		_renderLoaded();
	};
	
	function _clean() {
		if(viewAccountNav!=undefined) {
			viewAccountNav.remove();
		}
	}

	//
	function _renderDefault() {
		_clean();
		App.toast.warning("You need to sign in.");
	}
	
	//
	function _renderUserFeatures() {
		
		/*App.AccountManager.async_myAccount(function(account) {
			$(".account .caret").before(" "+account.nickname);
			viewAccountNav = AccountNav.create();
			viewAccountNav.appendTo("ul.account");
		}, LogManager.getToken());*/
		
	}
	
	//
	function _renderModeratorFeatures() {
		
		_renderUserFeatures();
	}
	
	//
	function _renderAdminFeatures(){
		
		_renderModeratorFeatures();
	}
	
	/* Modal */

	CommonPage.showEditModalChoco = function(choco, userProxies) {
		_insertView(EditChoco.create(choco, userProxies));
	};

	CommonPage.showModalChoco = function(choco) {
		_insertView(ChocoPopup.create(choco));
	};

	CommonPage.showEditModalUser = function(user, chocoProxies, officeProxies) {
		_insertView(EditUser.create(user, chocoProxies, officeProxies));
	};

	CommonPage.showModalUser = function(user) {
		_insertView(UserPopup.create(user));
	};

	CommonPage.showEditModalOffice = function(office) {
		_insertView(EditOffice.create(office));
	};

	CommonPage.showModalOffice = function(office) {
		_insertView(OfficePopup.create(office));
	};
	
	/**/
	CommonPage.hideModal = function() {
		
		_cleanView();
	};
	
	//
	function _renderLoaded() {
		$("body").addClass("loaded");
	}
	
	//
	function _insertView(view) {
		
		_cleanView();
		oldView = view;
		view.appendTo("body");
	}
	
	//
	function _cleanView() {
		
		if(oldView != undefined) {
			oldView.remove();
		}
	}
	
	/** Start of user code additional functions */
	CommonPage.renderOnline = function() {
		$("#status").removeClass('offline');
		$("#status").addClass('online');
		$("#status").text('online');
	};
	
	CommonPage.renderOffline = function() {
		$("#status").removeClass('online');
		$("#status").addClass('offline');
		$("#status").text('offline');
	};
	/** End of user code */

	return CommonPage;
});
