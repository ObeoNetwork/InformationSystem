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
define(["require", "app/App", "app/view/ViewUtil", "app/view/CommonEvents", "app/model/Office", "ember" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var App = require("app/App"),
		ViewUtil = require("app/view/ViewUtil"),
		CommonEvents = require("app/view/CommonEvents"),
		Office = require("app/model/Office");
	// ember does not need to be stored in a variable.
/** End of user code */


	var NewOffice = {},
		_Class = Em.View.extend({ templateName : "new-office" });

	


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
	NewOffice.create = function() {
		ViewUtil.loadWidgetTemplate("./asset/template/widget/form/new-office");
		
		var view = _Class.create({
			activated : false,
			
			hideWidget : hideWidget,
			showWidget : showWidget,

			TextField : _TextFieldClass,
			EmailField : _EmailFieldClass,
			ShortTextField : _ShortTextFieldClass,
			Select : _SelectClass,
			SelectMultiple : _SelectMultipleClass,
			officeInProgress : undefined,

			createEvent : createEvent,
			closeEvent : closeEvent,

			validForm: validForm,
			/** Start of user code additional features */
			/** End of user code */
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
	
	var hideWidget = function() {
		this.set('officeInProgress', undefined);
		this.set('activated', false);
	};
	
	var showWidget = function() {
		this.set('officeInProgress', Office.Class.create({localUpdate:false, localRemove:false, localAdd:false}));
		this.set('activated', true);
	};
	
	var validForm = function(e) {
		
		e.preventDefault();
		
		var result = true;
		var errorMsg = "";
		// ShortDescription check (valid string)
		if(result &= _identIsValid(this.officeInProgress.shortDescription)) {
			// Description check (valid string)
			if(result &= _identIsValid(this.officeInProgress.description)) {
				
			} else {
				errorMsg += '<p>Description is invalid</p>';
			}
		} else {
			errorMsg += '<p>ShortDescription is invalid</p>';
		}
		
		if(result) {
			App.commonCtrl.addOffice(this.officeInProgress);
			this.hideWidget();
		} else {
			App.toast.error(errorMsg+"Please, correct error(s).");
		}
	}
	
	/*call backs*/
	
	/** Start of user code additional functions */
	/** End of user code */

	return NewOffice;
});
