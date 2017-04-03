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
define(["require", "app/view/ViewUtil", "jasmine", "ember" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var ViewUtil = require("app/view/ViewUtil");
	// jasmine does not need to be stored in a variable.
	// ember does not need to be stored in a variable.
/** End of user code */


	describe("ViewUtil test", function() {

		beforeEach(function() {

		});

		describe("_extractTemplateName(path)", function() {
			it("works with a relative path", function() {
				var name = 'sample';
				var path = 'samplePath/' + name;
				expect(ViewUtil._extractTemplateName(path)).toBe(name);
			});
	
			it("works with an absolute path", function() {
				var name = 'sample';
				var path = '/samplePath/' + name;
				expect(ViewUtil._extractTemplateName(path)).toBe(name);
			});
	
			it("works with a small path", function() {
				var name = 'sample';
				var path = '' + name;
				expect(ViewUtil._extractTemplateName(path)).toBe(name);
			});
		});

		describe("loadWidgetTemplate(path)", function() {

			it("does not store anything with a wrong path", function() {
				var name = 'wrongName';
				var path = 'wrongPath/' + name;
				ViewUtil.loadWidgetTemplate(path);
				expect(Em.TEMPLATES[name]).toBeUndefined();
			});
	
			it("stores asset/template/widget/other/stats template", function() {
				var path = 'asset/template/widget/other/stats';
				var name = ViewUtil._extractTemplateName(path);
				expect(Em.TEMPLATES[name]).toBeUndefined();
				ViewUtil.loadWidgetTemplate(path);
				expect(Em.TEMPLATES[name]).toBeDefined();
			});

			it("stores asset/template/widget/list/choco-list template", function() {
				var path = 'asset/template/widget/list/choco-list';
				var name = ViewUtil._extractTemplateName(path);
				expect(Em.TEMPLATES[name]).toBeUndefined();
				ViewUtil.loadWidgetTemplate(path);
				expect(Em.TEMPLATES[name]).toBeDefined();
			});

			it("stores asset/template/widget/form/new-office template", function() {
				var path = 'asset/template/widget/form/new-office';
				var name = ViewUtil._extractTemplateName(path);
				expect(Em.TEMPLATES[name]).toBeUndefined();
				ViewUtil.loadWidgetTemplate(path);
				expect(Em.TEMPLATES[name]).toBeDefined();
			});

			it("stores asset/template/widget/popup/edit-choco-popup template", function() {
				var path = 'asset/template/widget/popup/edit-choco-popup';
				var name = ViewUtil._extractTemplateName(path);
				expect(Em.TEMPLATES[name]).toBeUndefined();
				ViewUtil.loadWidgetTemplate(path);
				expect(Em.TEMPLATES[name]).toBeDefined();
			});

			it("stores asset/template/widget/popup/user-popup template", function() {
				var path = 'asset/template/widget/popup/user-popup';
				var name = ViewUtil._extractTemplateName(path);
				expect(Em.TEMPLATES[name]).toBeUndefined();
				ViewUtil.loadWidgetTemplate(path);
				expect(Em.TEMPLATES[name]).toBeDefined();
			});

			it("stores asset/template/widget/popup/edit-office-popup template", function() {
				var path = 'asset/template/widget/popup/edit-office-popup';
				var name = ViewUtil._extractTemplateName(path);
				expect(Em.TEMPLATES[name]).toBeUndefined();
				ViewUtil.loadWidgetTemplate(path);
				expect(Em.TEMPLATES[name]).toBeDefined();
			});

			it("stores asset/template/widget/popup/choco-popup template", function() {
				var path = 'asset/template/widget/popup/choco-popup';
				var name = ViewUtil._extractTemplateName(path);
				expect(Em.TEMPLATES[name]).toBeUndefined();
				ViewUtil.loadWidgetTemplate(path);
				expect(Em.TEMPLATES[name]).toBeDefined();
			});

			it("stores asset/template/widget/popup/edit-user-popup template", function() {
				var path = 'asset/template/widget/popup/edit-user-popup';
				var name = ViewUtil._extractTemplateName(path);
				expect(Em.TEMPLATES[name]).toBeUndefined();
				ViewUtil.loadWidgetTemplate(path);
				expect(Em.TEMPLATES[name]).toBeDefined();
			});

			it("stores asset/template/widget/form/new-user template", function() {
				var path = 'asset/template/widget/form/new-user';
				var name = ViewUtil._extractTemplateName(path);
				expect(Em.TEMPLATES[name]).toBeUndefined();
				ViewUtil.loadWidgetTemplate(path);
				expect(Em.TEMPLATES[name]).toBeDefined();
			});

			it("stores asset/template/widget/list/user-list template", function() {
				var path = 'asset/template/widget/list/user-list';
				var name = ViewUtil._extractTemplateName(path);
				expect(Em.TEMPLATES[name]).toBeUndefined();
				ViewUtil.loadWidgetTemplate(path);
				expect(Em.TEMPLATES[name]).toBeDefined();
			});

			it("stores asset/template/widget/other/pagination template", function() {
				var path = 'asset/template/widget/other/pagination';
				var name = ViewUtil._extractTemplateName(path);
				expect(Em.TEMPLATES[name]).toBeUndefined();
				ViewUtil.loadWidgetTemplate(path);
				expect(Em.TEMPLATES[name]).toBeDefined();
			});

			it("stores asset/template/widget/other/account-nav template", function() {
				var path = 'asset/template/widget/other/account-nav';
				var name = ViewUtil._extractTemplateName(path);
				expect(Em.TEMPLATES[name]).toBeUndefined();
				ViewUtil.loadWidgetTemplate(path);
				expect(Em.TEMPLATES[name]).toBeDefined();
			});

			it("stores asset/template/widget/popup/office-popup template", function() {
				var path = 'asset/template/widget/popup/office-popup';
				var name = ViewUtil._extractTemplateName(path);
				expect(Em.TEMPLATES[name]).toBeUndefined();
				ViewUtil.loadWidgetTemplate(path);
				expect(Em.TEMPLATES[name]).toBeDefined();
			});

			it("stores asset/template/widget/list/office-list template", function() {
				var path = 'asset/template/widget/list/office-list';
				var name = ViewUtil._extractTemplateName(path);
				expect(Em.TEMPLATES[name]).toBeUndefined();
				ViewUtil.loadWidgetTemplate(path);
				expect(Em.TEMPLATES[name]).toBeDefined();
			});

			it("stores asset/template/widget/form/new-choco template", function() {
				var path = 'asset/template/widget/form/new-choco';
				var name = ViewUtil._extractTemplateName(path);
				expect(Em.TEMPLATES[name]).toBeUndefined();
				ViewUtil.loadWidgetTemplate(path);
				expect(Em.TEMPLATES[name]).toBeDefined();
			});

		});
	});

});
