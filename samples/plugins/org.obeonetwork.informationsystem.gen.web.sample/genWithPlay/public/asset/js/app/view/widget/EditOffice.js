 /*******************************************************************************
 * Copyright (c) 2012, 2016 Obeo.
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
 * @since 1.0.0
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


	var EditOffice = {},
		_Class = Em.View.extend({ templateName : "edit-office-popup" });



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
	EditOffice.create = function(office) {
		ViewUtil.loadWidgetTemplate("./asset/template/widget/popup/edit-office-popup");
		
		var view = _Class.create({
			
			TextField : _TextFieldClass,
			EmailField : _EmailFieldClass,
			ShortTextField : _ShortTextFieldClass,
			Select : _SelectClass,
			SelectMultiple : _SelectMultipleClass,
			office : office,
			
			validForm: validForm,
			cancelForm : cancelForm,
			/** Start of user code additional features */
			/** End of user code */
		});
		
		return view;
	};
	
	/* events */
	var validForm = function(e) {
		
		e.preventDefault();
		
		var result = true;
		var errorMsg = "";
		// ShortDescription check (valid string)
		if(result &= _identIsValid(this.office.shortDescription)) {
			// Description check (valid string)
			if(result &= _identIsValid(this.office.description)) {
				
			} else {
				errorMsg += '<p>Description is invalid</p>';
			}
		} else {
			errorMsg += '<p>ShortDescription is invalid</p>';
		}
		
		if(result) {
			App.commonCtrl.updateOffice(this.office);
			App.commonCtrl.hideModal();
		} else {
			App.toast.error(errorMsg+"Please, correct error(s).");
		}
	}
	
	var cancelForm = function(e) {
		
		e.preventDefault();
		App.commonCtrl.hideModal();
	}
	
	/** Start of user code additional functions */
	/** End of user code */

	return EditOffice;
});
