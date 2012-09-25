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
 * @version 0.9
 * @since 0.3
 */
define(["ember"], function() {

	var ViewUtil = {};

	/*
	 * Load the ember template (if it is not already loaded)
	 * @param {String} templateName
	 */
	ViewUtil.loadPageTemplate = function(templateName) {
		//TODO refactor templateName sem
		_loadTemplate(templateName, _getTemplatePagePath(templateName));
	}

	/*
	 * Load the ember template (if it is not already loaded)
	 * @param {String} templateName
	 */
	ViewUtil.loadWidgetTemplate = function(templateName) {
		_loadTemplate(templateName, _getTemplateWidgetPath(templateName));
	}
	
	function _loadTemplate(templateName, templatePath) {
		
		if(Em.TEMPLATES[templateName] == undefined) {
			$.ajax({
				url : templatePath, type : "get", dataType : "html", context : document.body, async : false, cache : true, success : function(data) {
					$(data).filter('script[type="text/x-handlebars"]').each(function() {
						
						var templateNameFounded = $(this).attr('data-template-name');
						console.log("template "+templateNameFounded);
						Em.TEMPLATES[templateNameFounded] = Ember.Handlebars.compile($(this).html());
					});
				}

			});
		}
	}
	
	/*
	 * Load a css or js resource in the html header
	 * @param {String} file path
	 * @param {String} filetype (js or css)
	 */
	ViewUtil.loadResource = function(filePath, filetype) {
		if(filetype == "js") {//if filename is a external JavaScript file
			var fileref = document.createElement('script')
			fileref.setAttribute("type", "text/javascript")
			fileref.setAttribute("src", filePath)
		} else if(filetype == "css") {//if filename is an external CSS file
			var fileref = document.createElement("link")
			fileref.setAttribute("rel", "stylesheet")
			fileref.setAttribute("type", "text/css")
			fileref.setAttribute("href", filePath)
		}
		if( typeof fileref != "undefined")
			document.getElementsByTagName("head")[0].appendChild(fileref)
	}

	function _getTemplatePagePath(folderName) {

		return "./asset/template/view/" + folderName + ".tmpl";
	}

	function _getTemplateWidgetPath(folderName) {
		
		return "./asset/template/widget/" + folderName + ".tmpl";
	}

	return ViewUtil;
});

