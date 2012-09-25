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
 * @since 0.8
 */
define(["require", "app/ws/WsAccount"], function(require) {
	
	/*__ Libs __*/
	var WsAccount = require("app/ws/WsAccount");
	/*__ Libs __*/
	
	AccountsManager = {};

	AccountsManager.async_myAccount = function(cb_function, token) {
		
		var cb_account = function(account) {

			cb_function(account);
		};
		
		WsAccount.byTokenMatch(cb_account, token);
	}

	return AccountsManager;
});
