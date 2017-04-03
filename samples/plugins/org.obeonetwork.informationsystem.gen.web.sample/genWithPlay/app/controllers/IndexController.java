/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package controllers;

import play.mvc.*;
import play.api.templates.Html;
import views.html.*;

public class IndexController extends Controller {

	public static Result index() {
		Status status = ok(views.html.index.render("title"));
		return status;
	}
}

