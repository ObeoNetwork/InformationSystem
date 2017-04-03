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

public class OfficeController extends Controller {


	public static Result serviceCount() {

		return ok(Json.toJson(OfficeServices.count()));
	}
	
	public static Result serviceRows(Integer rowId, Integer nbElemByRow) {

		List<JsonNode> offices2Json = new ArrayList();

		for(Office office: OfficeServices.rows(rowId, nbElemByRow))
			offices2Json.add(Factory.office2Json(office));

		return ok(Json.toJson(offices2Json));
	}

	public static Result serviceAllProxies() {

		List<JsonNode> jsonProxies = new ArrayList();

		for(Proxy proxy : OfficeServices.allProxies())
			jsonProxies.add(Factory.proxy2Json(proxy));

		return ok(Json.toJson(jsonProxies));
	}
	
	public static Result serviceStats() {

		List<JsonNode> jsonStats = new ArrayList();

		for(Stat stat: OfficeServices.stats())
			jsonStats.add(Factory.stat2Json(stat));

		return ok(Json.toJson(jsonStats));
	}

	public static Result serviceGet(Long id) {
		
		return ok(Json.toJson(Factory.office2Json(OfficeServices.getById(id))));
	}

	/*public static Result serviceSearch(String matcher) {

		List<JsonNode> offices2Json = new ArrayList();

		for(Office office: OfficeServices.search(matcher))
			offices2Json.add(Factory.office2Json(office));

		return ok(Json.toJson(offices2Json));
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

			return ok(Json.toJson(
						OfficeServices.create(
							new Office(id, shortDescription, description)
						)
					));
		}
	}

	public static Result serviceDelete(Long id) {
		return ok(Json.toJson(OfficeServices.delete(id)));
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

			return ok(Json.toJson(
					OfficeServices.update(
							new Office(id, shortDescription, description)
						)
					)
				);
		}
	}
}
