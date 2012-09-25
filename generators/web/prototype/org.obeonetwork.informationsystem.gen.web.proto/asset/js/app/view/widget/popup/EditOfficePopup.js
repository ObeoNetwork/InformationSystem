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
define(["require", "app/App", "app/view/ViewUtil", "app/view/CommonEvents", "app/model/Office", "ember"], function(require) {
	"use strict";

	/*__ Libs __*/
	var App = require("app/App"),
		ViewUtil = require("app/view/ViewUtil"),
		CommonEvents = require("app/view/CommonEvents"),
		Office = require("app/model/Office");
	/*__ Libs __*/

	var EditOfficePopup = {},
		templateName = "edit-office-popup",
		templatePath = "popup/" + templateName;
	ViewUtil.loadWidgetTemplate(templatePath);

	var _Class = Em.View.extend({ templateName : templateName });


	var _TextFieldClass = Em.TextField.extend({ 
		keyUp: function(e) {
			if(_identIsValid($(e.target).val())) {
				$(e.target).parent().parent().removeClass("error");
				$(e.target).next().hide();
			} else {
				$(e.target).parent().parent().addClass("error");
				$(e.target).next().show();
			}
    	}
    });
    
	/*
	 */
	EditOfficePopup.create = function(office) {
		
		var view = _Class.create({
			
			TextField : _TextFieldClass,
			office : office,
			
			validForm: validForm,
			cancelForm : cancelForm
		});
		
		return view;
	};
	
	/* events */
	
	var validForm = function(e) {
		
		e.preventDefault();
		
		var result = true;
		
		if(result &= _identIsValid(this.office.shortDescription)) {
			// visual effect?
		} else {
			// visual effect?
		}
		
		if(result &= _identIsValid(this.office.description)) {
			// visual effect?
		} else {
			// visual effect?
		}
		
		if(result) {
			App.commonCtrl.updateOffice(this.office);
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
	
	return EditOfficePopup;
});
