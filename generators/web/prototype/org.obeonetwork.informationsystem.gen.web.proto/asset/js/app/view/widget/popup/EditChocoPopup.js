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
define(["require", "app/App", "app/view/ViewUtil", "app/view/CommonEvents", "app/model/Choco", "ember"], function(require) {
	"use strict";

	/*__ Libs __*/
	var App = require("app/App"),
		ViewUtil = require("app/view/ViewUtil"),
		CommonEvents = require("app/view/CommonEvents"),
		Choco = require("app/model/Choco");
	/*__ Libs __*/

	var EditChocoPopup = {},
		templateName = "edit-choco-popup",
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
    
    var _SelectClass = Em.Select.extend({ });
    
	/*
	 */
	EditChocoPopup.create = function(choco, userProxies) {
		
		var view = _Class.create({
			
			TextField : _TextFieldClass,
			Select : _SelectClass,
			choco : choco,
			userProxies : userProxies,
			
			validForm: validForm,
			cancelForm : cancelForm
		});
		
		return view;
	};
	
	/* events */
	
	var validForm = function(e) {
		
		e.preventDefault();
		
		var result = true;
		
		if(result &= _identIsValid(this.choco.shortDescription)) {
			// visual effect?
		} else {
			// visual effect?
		}
		
		if(result &= _identIsValid(this.choco.description)) {
			// visual effect?
		} else {
			// visual effect?
		}
		
		if(result) {
			App.commonCtrl.updateChoco(this.choco);
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
	
	return EditChocoPopup;
});
