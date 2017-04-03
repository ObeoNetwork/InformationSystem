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

import java.util.ArrayList;
import java.util.List;
import play.mvc.BodyParser;
import play.mvc.Http.RequestBody;
import models.*;
import org.codehaus.jackson.JsonNode;
import play.Logger;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.*;
import util.Factory;

public class ChocoController extends Controller {


	public static Result serviceCount() {

		return ok(Json.toJson(ChocoServices.count()));
	}
	
	public static Result serviceRows(Integer rowId, Integer nbElemByRow) {

		List<JsonNode> chocos2Json = new ArrayList();

		for(Choco choco: ChocoServices.rows(rowId, nbElemByRow))
			chocos2Json.add(Factory.choco2Json(choco));

		return ok(Json.toJson(chocos2Json));
	}

	public static Result serviceAllProxies() {

		List<JsonNode> jsonProxies = new ArrayList();

		for(Proxy proxy : ChocoServices.allProxies())
			jsonProxies.add(Factory.proxy2Json(proxy));

		return ok(Json.toJson(jsonProxies));
	}
	
	public static Result serviceStats() {

		List<JsonNode> jsonStats = new ArrayList();

		for(Stat stat: ChocoServices.stats())
			jsonStats.add(Factory.stat2Json(stat));

		return ok(Json.toJson(jsonStats));
	}

	public static Result serviceGet(Long id) {
		
		return ok(Json.toJson(Factory.choco2Json(ChocoServices.getById(id))));
	}

	/*public static Result serviceSearch(String matcher) {

		List<JsonNode> chocos2Json = new ArrayList();

		for(Choco choco: ChocoServices.search(matcher))
			chocos2Json.add(Factory.choco2Json(choco));

		return ok(Json.toJson(chocos2Json));
	}*/

	@BodyParser.Of(BodyParser.TolerantText.class)
	public static Result serviceAdd() {

		DynamicForm filledForm = form().bindFromRequest();
		if(filledForm.hasErrors()) {
			return ok(Json.toJson(false));
		} else {
			RequestBody rb = request().body();
			String brut = rb.asText();
			Logger.debug("serviceAdd : "+brut);
			JsonNode data = Json.parse(brut);
				Long id = new Long(0);

				String shortDescription = null;
				if(data.path("shortDescription")!=null && !"null".equals(data.path("shortDescription").asText()))
					shortDescription = data.path("shortDescription").asText();

				String description = null;
				if(data.path("description")!=null && !"null".equals(data.path("description").asText()))
					description = data.path("description").asText();

				User user = null;
				if(data.path("user")!=null && !"null".equals(data.path("userProxy"))) {
					Proxy proxy = Factory.json2Proxy(data.path("userProxy"));
					user = UserServices.getById(proxy.getId());
				}

			return ok(Json.toJson(
						ChocoServices.create(
							new Choco(id, shortDescription, description, user)
						)
					));
		}
	}

	public static Result serviceDelete(Long id) {
		return ok(Json.toJson(ChocoServices.delete(id)));
	}

	@BodyParser.Of(BodyParser.TolerantText.class)
	public static Result serviceUpdate() {

		DynamicForm filledForm = form().bindFromRequest();
		if(filledForm.hasErrors()) {
			return ok(Json.toJson(false));
		} else {
			RequestBody rb = request().body();
			String brut = rb.asText();
			Logger.debug("serviceUpdate : "+brut);
			JsonNode data = Json.parse(brut);
				Long id = null;
				if(data.path("id")!=null && !"null".equals(data.path("id").asText()))
					id = new Long(data.path("id").asText());

				String shortDescription = null;
				if(data.path("shortDescription")!=null && !"null".equals(data.path("shortDescription").asText()))
					shortDescription = data.path("shortDescription").asText();

				String description = null;
				if(data.path("description")!=null && !"null".equals(data.path("description").asText()))
					description = data.path("description").asText();

				User user = null;
				if(data.path("user")!=null && !"null".equals(data.path("userProxy"))) {
					Proxy proxy = Factory.json2Proxy(data.path("userProxy"));
					user = UserServices.getById(proxy.getId());
				}

			return ok(Json.toJson(
					ChocoServices.update(
							new Choco(id, shortDescription, description, user)
						)
					)
				);
		}
	}
}
