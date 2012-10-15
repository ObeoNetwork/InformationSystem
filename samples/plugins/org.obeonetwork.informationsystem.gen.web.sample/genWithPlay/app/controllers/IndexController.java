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

