package com.pkm.hero.service.rest.client;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pkm.hero.dto.Hero;
import com.pkm.hero.service.rest.exception.HeroRestClientException;

/**
 * @author patrick
 * 
 */
public class HeroRestClient extends RestClient {

	private String requestBaseUrl = "http://localhost:8080/HeroService-WAR/rest/HeroReference";

	/**
	 * Default Constructor
	 */
	public HeroRestClient() {
		super();
	}

	/**
	 * Adds a Hero
	 * 
	 * @return
	 * @throws HeroRestClientException
	 */
	public Hero addHero(Hero hero) throws HeroRestClientException {

		logger.debug("Adding a new Hero:  " + hero);

		// Determine the Target URL
		String requestTargetUrl = "/AddHero";

		// Concatenate the Base URL with the Target URL
		String url = this.requestBaseUrl + requestTargetUrl;

		Gson gson = getGson();

		String jsonHero = gson.toJson(hero);

		// Retrieve a JSON String from the HTTP-POST
		String jsonString = httpPostString(url, APP_JSON, jsonHero);

		// Turn the JSON String into a Hero object
		Hero newHero = gson.fromJson(jsonString, Hero.class);

		logger.debug("Hero added!");

		// Return the added Hero
		return newHero;
	}

	/**
	 * Returns the list of Hero DTOs
	 * 
	 * @return
	 * @throws HeroRestClientException
	 */
	public List<Hero> getHeroes() throws HeroRestClientException {

		logger.debug("Retrieving all Heroes!");

		// Determine the Target URL
		String requestTargetUrl = "/Heroes";

		// Concatenate the Base URL with the Target URL
		String url = this.requestBaseUrl + requestTargetUrl;

		// Because we are retrieving a list of Heroes, need to give a list-type
		Type listType = new TypeToken<ArrayList<Hero>>() {
		}.getType();

		// Retrieve a JSON String from the HTTP-GET
		String jsonString = httpGetString(url, APP_JSON);

		// Turn the JSON String into a List of Hero objects
		List<Hero> heroes = getGson().fromJson(jsonString, listType);

		logger.debug("All Heroes retrieved!");

		// Return the list of Heroes
		return heroes;
	}

	/**
	 * Updates a Hero
	 * 
	 * @return
	 * @throws HeroRestClientException
	 */
	public Hero updateHero(Hero hero) throws HeroRestClientException {

		logger.debug("Updating an existing Hero called " + hero.getHeroName() + "!");

		// Determine the Target URL
		String requestTargetUrl = "/UpdateHero";

		// Concatenate the Base URL with the Target URL
		String url = this.requestBaseUrl + requestTargetUrl;

		Gson gson = getGson();

		String jsonHero = gson.toJson(hero);

		// Retrieve a JSON String from the HTTP-PUT
		String jsonString = httpPutString(url, APP_JSON, jsonHero);

		// Turn the JSON String into a Hero object
		Hero newHero = gson.fromJson(jsonString, Hero.class);

		logger.debug("Hero updated!");

		// Return the updated Hero
		return newHero;
	}

	/**
	 * Deletes a Hero
	 * 
	 * @return
	 * @throws HeroRestClientException
	 */
	public Hero deleteHero(Hero hero) throws HeroRestClientException {

		logger.debug("Deleting an existing Hero called " + hero.getHeroName() + "!");

		// Determine the Target URL
		String requestTargetUrl = "/RemoveHeroById/" + hero.getHeroId();

		// Concatenate the Base URL with the Target URL
		String url = this.requestBaseUrl + requestTargetUrl;

		Gson gson = getGson();

		// Retrieve a JSON String from the HTTP-GET
		String jsonString = httpDeleteString(url, APP_JSON, "");

		// Turn the JSON String into a Hero object
		Hero deletedHero = gson.fromJson(jsonString, Hero.class);

		logger.debug("Hero deleted!");

		// Return the deleted Hero
		return deletedHero;
	}

	/**
	 * @return the requestBaseUrl
	 */
	public String getRequestBaseUrl() {
		return requestBaseUrl;
	}

	/**
	 * @param requestBaseUrl the requestBaseUrl to set
	 */
	public void setRequestBaseUrl(String requestBaseUrl) {
		this.requestBaseUrl = requestBaseUrl;
	}
}
