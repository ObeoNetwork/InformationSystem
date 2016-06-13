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

public class UserController extends Controller {


	public static Result serviceCount() {

		return ok(Json.toJson(UserServices.count()));
	}
	
	public static Result serviceRows(Integer rowId, Integer nbElemByRow) {

		List<JsonNode> users2Json = new ArrayList();

		for(User user: UserServices.rows(rowId, nbElemByRow))
			users2Json.add(Factory.user2Json(user));

		return ok(Json.toJson(users2Json));
	}

	public static Result serviceAllProxies() {

		List<JsonNode> jsonProxies = new ArrayList();

		for(Proxy proxy : UserServices.allProxies())
			jsonProxies.add(Factory.proxy2Json(proxy));

		return ok(Json.toJson(jsonProxies));
	}
	
	public static Result serviceStats() {

		List<JsonNode> jsonStats = new ArrayList();

		for(Stat stat: UserServices.stats())
			jsonStats.add(Factory.stat2Json(stat));

		return ok(Json.toJson(jsonStats));
	}

	public static Result serviceGet(Long id) {
		
		return ok(Json.toJson(Factory.user2Json(UserServices.getById(id))));
	}

	/*public static Result serviceSearch(String matcher) {

		List<JsonNode> users2Json = new ArrayList();

		for(User user: UserServices.search(matcher))
			users2Json.add(Factory.user2Json(user));

		return ok(Json.toJson(users2Json));
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

				String nickname = null;
				if(data.path("nickname")!=null && !"null".equals(data.path("nickname").asText()))
					nickname = data.path("nickname").asText();

				String shortNickname = null;
				if(data.path("shortNickname")!=null && !"null".equals(data.path("shortNickname").asText()))
					shortNickname = data.path("shortNickname").asText();

				String firstName = null;
				if(data.path("firstName")!=null && !"null".equals(data.path("firstName").asText()))
					firstName = data.path("firstName").asText();

				String lastName = null;
				if(data.path("lastName")!=null && !"null".equals(data.path("lastName").asText()))
					lastName = data.path("lastName").asText();

				List<Choco> chocos = new ArrayList<Choco>();	
				if(data.path("chocoProxies")!=null && !"null".equals(data.path("chocoProxies"))) {
					chocos = Factory.jsonToChocos(data.path("chocoProxies"));
				}				

				Office office = null;
				if(data.path("office")!=null && !"null".equals(data.path("officeProxy"))) {
					Proxy proxy = Factory.json2Proxy(data.path("officeProxy"));
					office = OfficeServices.getById(proxy.getId());
				}

				String email = null;
				if(data.path("email")!=null && !"null".equals(data.path("email").asText()))
					email = data.path("email").asText();

				Integer level = null;
				if(data.path("level")!=null && !"null".equals(data.path("level").asText()))
					level = new Integer(data.path("level").asText());

				Integer xp = null;
				if(data.path("xp")!=null && !"null".equals(data.path("xp").asText()))
					xp = new Integer(data.path("xp").asText());

			return ok(Json.toJson(
						UserServices.create(
							new User(id, nickname, shortNickname, firstName, lastName, chocos, office, email, level, xp)
						)
					));
		}
	}

	public static Result serviceDelete(Long id) {
		return ok(Json.toJson(UserServices.delete(id)));
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

				String nickname = null;
				if(data.path("nickname")!=null && !"null".equals(data.path("nickname").asText()))
					nickname = data.path("nickname").asText();

				String shortNickname = null;
				if(data.path("shortNickname")!=null && !"null".equals(data.path("shortNickname").asText()))
					shortNickname = data.path("shortNickname").asText();

				String firstName = null;
				if(data.path("firstName")!=null && !"null".equals(data.path("firstName").asText()))
					firstName = data.path("firstName").asText();

				String lastName = null;
				if(data.path("lastName")!=null && !"null".equals(data.path("lastName").asText()))
					lastName = data.path("lastName").asText();

				List<Choco> chocos = new ArrayList<Choco>();	
				if(data.path("chocoProxies")!=null && !"null".equals(data.path("chocoProxies"))) {
					chocos = Factory.jsonToChocos(data.path("chocoProxies"));
				}					

				Office office = null;
				if(data.path("office")!=null && !"null".equals(data.path("officeProxy"))) {
					Proxy proxy = Factory.json2Proxy(data.path("officeProxy"));
					office = OfficeServices.getById(proxy.getId());
				}

				String email = null;
				if(data.path("email")!=null && !"null".equals(data.path("email").asText()))
					email = data.path("email").asText();

				Integer level = null;
				if(data.path("level")!=null && !"null".equals(data.path("level").asText()))
					level = new Integer(data.path("level").asText());

				Integer xp = null;
				if(data.path("xp")!=null && !"null".equals(data.path("xp").asText()))
					xp = new Integer(data.path("xp").asText());

			return ok(Json.toJson(
					UserServices.update(
							new User(id, nickname, shortNickname, firstName, lastName, chocos, office, email, level, xp)
						)
					)
				);
		}
	}
}
