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
package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.*;
import services.*;

import org.codehaus.jackson.JsonNode;

import play.Logger;
import play.libs.Json;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public class Factory {

	public static Choco json2Choco(JsonNode json) {

		User user = jsonToUser(json.path("userProxy"));
		return new Choco(
					json.path("id").asLong()
					,json.path("shortDescription").asText()
					,json.path("description").asText()
					,user
					
				);
	}
	public static User json2User(JsonNode json) {

		List<Choco> chocos = jsonToChocos(json.path("chocosProxies"));
		Office office = jsonToOffice(json.path("officeProxy"));
		return new User(
					json.path("id").asLong()
					,json.path("nickname").asText()
					,json.path("shortNickname").asText()
					,json.path("firstName").asText()
					,json.path("lastName").asText()
					,chocos
					
					,office
					
					,json.path("email").asText()
					,json.path("level").asInt()
					,json.path("xp").asInt()
				);
	}
	public static Office json2Office(JsonNode json) {

		return new Office(
					json.path("id").asLong()
					,json.path("shortDescription").asText()
					,json.path("description").asText()
				);
	}

	public static List<Long> jsonNode2ListOfLong(JsonNode node) {

		List<Long> listOfLong = new ArrayList<Long>();
		Iterator<JsonNode> iterJson = node.iterator();

		while(iterJson.hasNext()) {
			JsonNode itemIdNode = iterJson.next();
			listOfLong.add(itemIdNode.asLong());
		}
		return listOfLong;
	}

	public static Proxy json2Proxy(JsonNode node) {
		return new Proxy(node.path("id").asLong(),node.path("desc").asText());
	}

	public static List<Proxy> json2Proxies(JsonNode node) {
		List<Proxy> proxies = new ArrayList<Proxy>();
		Iterator<JsonNode> iterJson = node.iterator();
		while(iterJson.hasNext()) {
			JsonNode currentNode = iterJson.next();
			proxies.add(json2Proxy(currentNode));
		}
		return proxies;
	}

	public static JsonNode proxy2Json(Proxy proxy) {
		return Json.toJson(
				ImmutableMap.builder()
				.put("id", proxy.getId())
				.put("desc", proxy.getDesc())
				.build()
				);
	}

	public static JsonNode stat2Json(Stat stat) {
		return Json.toJson(
				ImmutableMap.builder()
				.put("res", stat.getRes())
				.put("desc", stat.getDesc())
				.build()
				);
	}



	public static JsonNode choco2Json(Choco choco) {

		Builder<Object, Object> builder = ImmutableMap.builder();
		if(choco.getId() != null)
			builder.put("id", choco.getId());
		if(choco.getShortDescription() != null)
			builder.put("shortDescription", choco.getShortDescription());
		if(choco.getDescription() != null)
			builder.put("description", choco.getDescription());
		if(choco.getUser() != null) {
			builder.put("userProxy", choco.getUser().toProxy());
		}
		
		return Json.toJson(builder.build());
	}
	public static JsonNode user2Json(User user) {

		Builder<Object, Object> builder = ImmutableMap.builder();
		if(user.getId() != null)
			builder.put("id", user.getId());
		if(user.getNickname() != null)
			builder.put("nickname", user.getNickname());
		if(user.getShortNickname() != null)
			builder.put("shortNickname", user.getShortNickname());
		if(user.getFirstName() != null)
			builder.put("firstName", user.getFirstName());
		if(user.getLastName() != null)
			builder.put("lastName", user.getLastName());
		if(user.getChocos() != null) {
			List<Proxy> chocoProxies = new ArrayList<Proxy>();
			for (Choco choco : user.getChocos()) {
				chocoProxies.add(choco.toProxy());
			}
			builder.put("chocoProxies", chocoProxies);
		}
		if(user.getOffice() != null) {
			builder.put("officeProxy", user.getOffice().toProxy());
		}
		if(user.getEmail() != null)
			builder.put("email", user.getEmail());
		if(user.getLevel() != null)
			builder.put("level", user.getLevel());
		if(user.getXp() != null)
			builder.put("xp", user.getXp());
		
		return Json.toJson(builder.build());
	}
	public static JsonNode office2Json(Office office) {

		Builder<Object, Object> builder = ImmutableMap.builder();
		if(office.getId() != null)
			builder.put("id", office.getId());
		if(office.getShortDescription() != null)
			builder.put("shortDescription", office.getShortDescription());
		if(office.getDescription() != null)
			builder.put("description", office.getDescription());
		
		return Json.toJson(builder.build());
	}

	public static Choco jsonToChoco(JsonNode node) {
		Proxy proxy = json2Proxy(node);
		return ChocoServices.getById(proxy.getId());
	}

	public static List<Choco> jsonToChocos(JsonNode node) {
		List<Proxy> proxies = json2Proxies(node);
		List<Long> ids = new ArrayList<Long>();
		for(Proxy proxy : proxies) {
			ids.add(proxy.getId());
		}
		return ChocoServices.getByIds(ids);
	}
	public static User jsonToUser(JsonNode node) {
		Proxy proxy = json2Proxy(node);
		return UserServices.getById(proxy.getId());
	}

	public static List<User> jsonToUsers(JsonNode node) {
		List<Proxy> proxies = json2Proxies(node);
		List<Long> ids = new ArrayList<Long>();
		for(Proxy proxy : proxies) {
			ids.add(proxy.getId());
		}
		return UserServices.getByIds(ids);
	}
	public static Office jsonToOffice(JsonNode node) {
		Proxy proxy = json2Proxy(node);
		return OfficeServices.getById(proxy.getId());
	}

	public static List<Office> jsonToOffices(JsonNode node) {
		List<Proxy> proxies = json2Proxies(node);
		List<Long> ids = new ArrayList<Long>();
		for(Proxy proxy : proxies) {
			ids.add(proxy.getId());
		}
		return OfficeServices.getByIds(ids);
	}

}
