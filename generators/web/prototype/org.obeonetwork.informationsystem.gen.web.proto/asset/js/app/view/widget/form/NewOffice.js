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
 * @since 0.9
 */
define(["require", "app/App", "app/view/ViewUtil", "app/view/CommonEvents", "app/model/Office", "ember"], function(require) {
	
	/*__ Libs __*/
	var App = require("app/App"),
		ViewUtil = require("app/view/ViewUtil"),
		CommonEvents = require("app/view/CommonEvents"),
		Office = require("app/model/Office");
	
	var NewOffice = {};
	
	var templateName = "new-office";
	var templatePath = "form/" + templateName;
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
	NewOffice.create = function() {
		
		var view = _Class.create({
			
			TextField : _TextFieldClass,
			officeInProgress : undefined,
			userProxies : [],
			
			showCreateForm: showCreateForm,
			validForm: validForm,
			cancelForm : cancelForm
		});
		
		return view;
	};
	
	/* events */
	var showCreateForm = function(e) {
		
		e.preventDefault();
		this.set('officeInProgress', Office.Class.create());
	}
	
	var validForm = function(e) {
		
		e.preventDefault();
		
		var result = true;
		
		if(result &= _identIsValid(this.officeInProgress.shortDescription)) {
			// visual effect?
		} else {
			// visual effect?
		}
		
		if(result &= _identIsValid(this.officeInProgress.description)) {
			// visual effect?
		} else {
			// visual effect?
		}
		
		if(result) {
			App.commonCtrl.addOffice(this.officeInProgress);
			this.set('officeInProgress', undefined);
		} else {
			App.toast.error("Please, correct error(s).");
		}
	}
	
	var cancelForm = function(e) {
		
		e.preventDefault();
		this.set('officeInProgress', undefined);
	}
	
	/*call backs*/
	
	function _identIsValid(ident) {
		return ident!=undefined && ident!=null && ident.length>3;
	}
	
	return NewOffice;
});
