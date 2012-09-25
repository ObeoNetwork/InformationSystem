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
 * @version 0.8
 * @since 0.4
 */
define(["require", "app/App", "app/view/CommonEvents", "app/view/widget/other/AccountNav", "app/security/LogManager",
"app/view/widget/popup/EditChocoPopup", "app/view/widget/popup/ChocoPopup", 
"app/view/widget/popup/EditOfficePopup", "app/view/widget/popup/OfficePopup", 
"app/view/widget/popup/EditUserPopup", "app/view/widget/popup/UserPopup"], function(require) {

	/*__ Libs __*/
	var App = require("app/App"),
		CommonEvents = require("app/view/CommonEvents"),
		AccountNav = require("app/view/widget/other/AccountNav"),
		EditChocoPopup = require("app/view/widget/popup/EditChocoPopup"),
		EditUserPopup = require("app/view/widget/popup/EditUserPopup"),
		EditOfficePopup = require("app/view/widget/popup/EditOfficePopup"),
		ChocoPopup = require("app/view/widget/popup/ChocoPopup"),
		UserPopup = require("app/view/widget/popup/UserPopup"),
		OfficePopup = require("app/view/widget/popup/OfficePopup"),
		LogManager = require("app/security/LogManager");
	
	
	var CommonPage = {};
	var oldView = undefined;
	var viewNavAccount = undefined;
	
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
	
	//
	function _renderDefault() {
		
		App.toast.warning("You need to sign in.");
	}
	
	//
	function _renderUserFeatures() {
		
		/*App.account.async_myAccount(function(account) {
			$(".account .caret").before(" "+account.nickname);
			var viewNavAccount = AccountNav.create();
			viewNavAccount.appendTo("ul.nav-list");
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
		
		_insertView(EditChocoPopup.create(choco, userProxies));

	};
	CommonPage.showModalChoco = function(choco) {
		
		_insertView(ChocoPopup.create(choco));

	};
	/**/
	CommonPage.showEditModalUser = function(user, chocoProxies, officeProxies) {
		
		_insertView(EditUserPopup.create(user, chocoProxies, officeProxies));

	};
	CommonPage.showModalUser = function(user) {
		
		_insertView(UserPopup.create(user));
	};
	
	/**/
	CommonPage.showEditModalOffice = function(office) {
		
		_insertView(EditOfficePopup.create(office));

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
	
	return CommonPage;
});
