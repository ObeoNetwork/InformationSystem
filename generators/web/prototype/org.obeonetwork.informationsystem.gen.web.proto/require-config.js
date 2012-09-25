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
 */

// Configure the RequireJS paths to use an alias for the
// jQuery library.
require({
	baseUrl : './asset/js', 
	paths : {
		
		jquery : 		'lib/jquery/jquery-1.7.2',
		ember : 		'lib/ember/ember-0.9.8',
		bs : 			'lib/bootstrap/bootstrap',
		
		/*App : 			'app/App',
		ctrl : 			'app/ctrl',
		model : 		'app/model',
		view : 			'app/view',
		query : 		'app/query',
		security : 		'app/security',
		ws : 			'app/ws',
		syncService : 	'app/syncService',
		Root : 			'app/Root'*/
	}, 
	//TODO ENV.CP_DEFAULT_CACHEABLE = true
	priority : ['jquery']
}, ['app/Root']);