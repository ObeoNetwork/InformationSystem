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
 * @since 0.9.0
 * @generated
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/App", "app/view/ViewUtil", "app/view/CommonEvents", "app/model/User", "ember" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var App = require("app/App"),
		ViewUtil = require("app/view/ViewUtil"),
		CommonEvents = require("app/view/CommonEvents"),
		User = require("app/model/User");
	// ember does not need to be stored in a variable.
/** End of user code */


	var NewUser = {},
		_Class = Em.View.extend({ templateName : "new-user" });

	


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
	
	function _identIsValid(ident) {
		return ident!=undefined && ident!=null && ident.length>=3;
	}
	
	function _shortIdentIsValid(ident) {
		return ident!=undefined && ident!=null && ident.length==3;
	}
	
	function _emailIsValid(ident) {
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		return ident!=undefined && ident!=null && filter.test(ident);
	}
	
	/*
	 */
	NewUser.create = function() {
		ViewUtil.loadWidgetTemplate("./asset/template/widget/form/new-user");
		
		var view = _Class.create({
			activated : false,
			
			hideWidget : hideWidget,
			showWidget : showWidget,

			TextField : _TextFieldClass,
			EmailField : _EmailFieldClass,
			ShortTextField : _ShortTextFieldClass,
			Select : _SelectClass,
			SelectMultiple : _SelectMultipleClass,
			userInProgress : undefined,
			chocoProxies : [],
			officeProxies : [],

			createEvent : createEvent,
			closeEvent : closeEvent,
			addEvent : addEvent,

			validForm: validForm,
			/** Start of user code additional features */
			/** End of user code */
			loadChocoProxies : cb_loadChocoProxies,
			loadOfficeProxies : cb_loadOfficeProxies,
		});
		
		return view;
	};
	
	/* events */
	var createEvent = function() {
		this.showWidget();
	};
	var closeEvent = function(e) {
		e.preventDefault();
		this.hideWidget();
	};
	var addEvent = function() {
		this.hideWidget();
		this.get('parentView').addEvent(this);
	};
	
	var hideWidget = function() {
		this.set('userInProgress', undefined);
		this.set('activated', false);
	};
	
	var showWidget = function() {
		App.commonCtrl.loadAllChocosInWidget(this);
		App.commonCtrl.loadAllOfficesInWidget(this);
		this.set('userInProgress', User.Class.create({localUpdate:false, localRemove:false, localAdd:false}));
		this.set('activated', true);
	};
	
	var validForm = function(e) {
		
		e.preventDefault();
		
		var result = true;
		var errorMsg = "";
		// Nickname check (valid string)
		if(result &= _identIsValid(this.userInProgress.nickname)) {
			// ShortNickname check (valid string)
			if(result &= _identIsValid(this.userInProgress.shortNickname)) {
				// FirstName check (valid string)
				if(result &= _identIsValid(this.userInProgress.firstName)) {
					// LastName check (valid string)
					if(result &= _identIsValid(this.userInProgress.lastName)) {
						// Email check (valid string)
						if(result &= _identIsValid(this.userInProgress.email)) {
							// Level check (valid numeric)
							if(result &= true) {
								// Xp check (valid numeric)
								if(result &= true) {
									
								} else {
									errorMsg += '<p>Xp is invalid</p>';
								}
							} else {
								errorMsg += '<p>Level is invalid</p>';
							}
						} else {
							errorMsg += '<p>Email is invalid</p>';
						}
					} else {
						errorMsg += '<p>LastName is invalid</p>';
					}
				} else {
					errorMsg += '<p>FirstName is invalid</p>';
				}
			} else {
				errorMsg += '<p>ShortNickname is invalid</p>';
			}
		} else {
			errorMsg += '<p>Nickname is invalid</p>';
		}
		
		if(result) {
			App.commonCtrl.addUser(this.userInProgress);
			this.hideWidget();
		} else {
			App.toast.error(errorMsg+"Please, correct error(s).");
		}
	}
	
	/*call backs*/
	var cb_loadChocoProxies = function(chocoProxies) {
		
		this.set('chocoProxies', chocoProxies);
	};
	var cb_loadOfficeProxies = function(officeProxies) {
		
		this.set('officeProxies', officeProxies);
	};
	
	/** Start of user code additional functions */
	/** End of user code */

	return NewUser;
});
