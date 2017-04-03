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
 * @since 0.3.0
 * @generated
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "ember" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	// ember does not need to be stored in a variable.
/** End of user code */


	var ViewUtil = {};

	/*
	 * Load the ember template (if it is not already loaded)
	 * @param {String} templateName
	 */
	ViewUtil.loadWidgetTemplate = function(templatePath) {
		_loadTemplate(ViewUtil._extractTemplateName(templatePath), templatePath);
	}
	
	function _loadTemplate(templateName, templatePath) {
		
		if(Em.TEMPLATES[templateName] == undefined) {
			$.ajax({
				url : templatePath+".tmpl", type : "get", dataType : "html", context : document.body, async : false, cache : true, success : function(data) {
					$(data).filter('script[type="text/x-handlebars"]').each(function() {
						
						var templateNameFounded = $(this).attr('data-template-name');
						Em.TEMPLATES[templateNameFounded] = Ember.Handlebars.compile($(this).html());
					});
				}

			});
		}
	}

	ViewUtil._extractTemplateName = function (filePath) {
		var fileNameIndex = filePath.lastIndexOf("/") + 1;
		var filename = filePath.substr(fileNameIndex);
		return filename;
	}
	
	/** Start of user code additional functions */
	/** End of user code */

	return ViewUtil;
});
