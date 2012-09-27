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
 * @since 0.8.0
 * @generated
 */
/** Start of user code default require function */
/* Define function is an AMD feature. For more information, @see http://requirejs.org. */
define(["require", "app/ws/WsAccount" ], function(require) {
	"use strict";

	
	/* Get all required AMD modules in vars */
	var WsAccount = require("app/ws/WsAccount");
/** End of user code */


	var AccountManager = {};

	AccountManager.async_myAccount = function(cb_function, token) {
		
		var cb_account = function(account) {

			cb_function(account);
		};
		
		WsAccount.byTokenMatch(cb_account, token);
	}
	
	/** Start of user code additional functions */
	/** End of user code */

	return AccountManager;
});
