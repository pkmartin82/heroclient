package com.pkm.hero.service.rest.client;

import com.google.gson.Gson;
import com.pkm.hero.dto.Duck;
import com.pkm.hero.service.rest.exception.HeroRestClientException;

public class DuckRestClient extends RestClient {

	private String requestBaseUrl = "http://localhost:8080/heroservice/rest/HeroReference";

	public DuckRestClient() {
		super();
	}

	public Duck addDuck(Duck duck) throws HeroRestClientException {

		logger.debug("Adding a new Duck:  " + duck);

		// Determine the Target URL
		String requestTargetUrl = "/AddHero";

		// Concatenate the Base URL with the Target URL
		String url = this.requestBaseUrl + requestTargetUrl;

		Gson gson = getGson();

		String jsonDuck = gson.toJson(duck);

		// Retrieve a JSON String from the HTTP-POST
		String jsonString = httpPostString(url, APP_JSON, jsonDuck);

		// Turn the JSON String into a Hero object
		Duck newDuck = gson.fromJson(jsonString, Duck.class);

		logger.debug("Duck added!");

		// Return the added Hero
		return newDuck;
	}
}
