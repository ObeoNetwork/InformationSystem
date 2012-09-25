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
 * @since 1.0
 */
define(["require", "app/App", "app/view/ViewUtil", "app/view/CommonEvents", "app/model/User", "ember"], function(require) {
	"use strict";

	/*__ Libs __*/
	var App = require("app/App"),
		ViewUtil = require("app/view/ViewUtil"),
		CommonEvents = require("app/view/CommonEvents"),
		User = require("app/model/User");
	/*__ Libs __*/

	var EditUserPopup = {},
		templateName = "edit-user-popup",
		templatePath = "popup/" + templateName;
	ViewUtil.loadWidgetTemplate(templatePath);

	var _Class = Em.View.extend({ templateName : templateName });


	var _TextFieldClass = Em.TextField.extend({
		keyUp : function(e) {
			if (_identIsValid($(e.target).val())) {
				$(e.target).parent().parent().removeClass("error");
				$(e.target).next().hide();
			} else {
				$(e.target).parent().parent().addClass("error");
				$(e.target).next().show();
			}
		}

	});

	var _EmailFieldClass = Em.TextField.extend({
		keyUp : function(e) {
			if (_emailIsValid($(e.target).val())) {
				$(e.target).parent().parent().removeClass("error");
				$(e.target).next().hide();
			} else {
				$(e.target).parent().parent().addClass("error");
				$(e.target).next().show();
			}
		}

	});

	var _ShortTextFieldClass = Em.TextField.extend({
		keyUp : function(e) {
			if (_shortIdentIsValid($(e.target).val())) {
				$(e.target).parent().parent().removeClass("error");
				$(e.target).next().hide();
			} else {
				$(e.target).parent().parent().addClass("error");
				$(e.target).next().show();
			}
		}

	});

	var _SelectClass = Em.Select.extend({ });

	var _SelectMultipleClass = Em.Select.extend({
		multiple : "true"
	}); 

    
	/*
	 */
	EditUserPopup.create = function(user, chocoProxies, officeProxies) {
		
		var view = _Class.create({
			
			TextField : _TextFieldClass,
			EmailField : _EmailFieldClass,
			ShortTextField : _ShortTextFieldClass,
			Select : _SelectClass,
			SelectMultiple : _SelectMultipleClass,
			user : user,
			chocoProxies : chocoProxies,
			officeProxies : officeProxies,
			
			validForm: validForm,
			cancelForm : cancelForm
		});
		
		return view;
	};
	
	/* events */
	
	var validForm = function(e) {
		
		e.preventDefault();
		
		var result = true;
		
		if(result &= _identIsValid(this.userInProgress.firstName)) {
			// visual effect?
		} else {
			// visual effect?
		}
		
		if(result &= _identIsValid(this.userInProgress.lastName)) {
			// visual effect?
		} else {
			// visual effect?
		}
		
		if(result &= _identIsValid(this.userInProgress.nickname)) {
			// visual effect?
		} else {
			// visual effect?
		}
		
		if(result &= _shortIdentIsValid(this.userInProgress.shortNickname)) {
			// visual effect?
		} else {
			// visual effect?
		}
		
		if(result &= _emailIsValid(this.userInProgress.email)) {
			// visual effect?
		} else {
			// visual effect?
		}
		
		if(result) {
			App.commonCtrl.updateUser(this.user);
			App.commonCtrl.hideModal();
		} else {
			// visual effect?
		}
	}
	
	var cancelForm = function(e) {
		
		e.preventDefault();
		App.commonCtrl.hideModal();
	}
	
	/*call backs*/
	
	function _identIsValid(ident) {
		return ident!=undefined && ident!=null && ident.length>3;
	}
	
	function _shortIdentIsValid(ident) {
		return ident!=undefined && ident!=null && ident.length==3;
	}
	
	function _emailIsValid(ident) {
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		return ident!=undefined && ident!=null && filter.test(ident);
	}
	
	return EditUserPopup;
});
