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
 * @since 1.0
 * @generated
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "test/view/ViewUtilTest", "test/security/SecurityUtilTest", "test/security/LogManagerTest", "test/security/ProviderDelegationTest", "test/model/ChocoTest", "test/model/UserTest", "test/model/OfficeTest", "jasmine", "jasminehtml" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	// jasmine does not need to be stored in a variable.
	// jasminehtml does not need to be stored in a variable.
/** End of user code */

	var jasmineEnv = jasmine.getEnv();
	jasmineEnv.updateInterval = 1000;

	var htmlReporter = new jasmine.HtmlReporter();
	
	jasmineEnv.addReporter(htmlReporter);
	
	jasmineEnv.specFilter = function(spec) {
		return htmlReporter.specFilter(spec);
	};

	var currentWindowOnload = window.onload;

	window.onload = function() {
		if (currentWindowOnload) {
			currentWindowOnload();
		}
		execJasmine();
	};

	function execJasmine() {
		jasmineEnv.execute();
	}

});
