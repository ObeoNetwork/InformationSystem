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
	
	/*__ Libs __*/
	var App = require("app/App"),
		ViewUtil = require("app/view/ViewUtil"),
		CommonEvents = require("app/view/CommonEvents"),
		Choco = require("app/model/Choco");
	
	var NewChoco = {};
	
	var templateName = "new-choco";
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
    
    var _SelectClass = Em.Select.extend({ });
    
	/*
	 */
	NewChoco.create = function() {
		
		var view = _Class.create({
			
			TextField : _TextFieldClass,
			Select : _SelectClass,
			chocoInProgress : undefined,
			userProxies : [],
			
			showCreateForm: showCreateForm,
			validForm: validForm,
			cancelForm : cancelForm,
			loadUsers : cb_loadUsers
		});
		
		return view;
	};
	
	/* events */
	var showCreateForm = function(e) {
		
		e.preventDefault();
		App.homeCtrl.loadAllUsersInWidget(this);
		this.set('chocoInProgress', Choco.Class.create());
	}
	
	var validForm = function(e) {
		
		e.preventDefault();
		
		var result = true;
		
		if(result &= _identIsValid(this.chocoInProgress.shortDescription)) {
			// visual effect?
		} else {
			// visual effect?
		}
		
		if(result &= _identIsValid(this.chocoInProgress.description)) {
			// visual effect?
		} else {
			// visual effect?
		}
		
		if(result) {
			App.commonCtrl.addChoco(this.chocoInProgress);
			this.set('chocoInProgress', undefined);
		} else {
			App.toast.error("Please, correct error(s).");
		}
	}
	
	var cancelForm = function(e) {
		
		e.preventDefault();
		this.set('chocoInProgress', undefined);
	}
	
	/*call backs*/
	
	var cb_loadUsers = function(userProxies) {
		
		this.set('userProxies', userProxies);
	};
	
	function _identIsValid(ident) {
		return ident!=undefined && ident!=null && ident.length>3;
	}
	
	return NewChoco;
});
