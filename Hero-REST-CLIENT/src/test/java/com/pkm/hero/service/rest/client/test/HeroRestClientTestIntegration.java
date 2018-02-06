package com.pkm.hero.service.rest.client.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pkm.hero.dto.Hero;
import com.pkm.hero.service.rest.client.HeroRestClient;
import com.pkm.hero.service.rest.exception.HeroRestClientException;

public class HeroRestClientTestIntegration {

	/** Default Universe Id */
	private final static int DEFAULT_UNIVERSE_ID = 616;

	/** Bad Port to simulate error cases */
	private final static String BAD_PORT = "9080";

	/** Good Port to simulate success cases */
	private final static String GOOD_PORT = "8080";

	/** Hero object with which to test */
	private static Hero testHero;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		long time = System.currentTimeMillis();

		testHero = new Hero();
		testHero.setHeroName("TestHero_" + time);
		testHero.setSecretIdentity("TestIdentity_" + time);
		testHero.setNumOthersWhoKnowSecret(-1);
		testHero.setUniverseId(DEFAULT_UNIVERSE_ID);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Tests all CRUD operations provided by the Hero Rest WebService
	 */
	@Test
	public void testAddUpdateDeleteHero() {

		testAddHero();
		testUpdateHero();
		testDeleteHero();
	}

	/**
	 * Test method for
	 * {@link com.pkm.hero.service.rest.client.HeroRestClient#getHeroes()}.
	 */
	@Test
	public void testGetHeroes() {
		HeroRestClient restClient = new HeroRestClient();

		List<Hero> heroes = null;

		try {

			heroes = restClient.getHeroes();

			for (Hero hero : heroes) {
				System.out.println(hero);
			}
			System.out.println();
		} catch (HeroRestClientException e) {
			e.printStackTrace();
			fail("Failed with exception: " + e);
		}

		assertNotNull(heroes);
		assertTrue(heroes instanceof List<?>);
	}

	/**
	 * Non-Happy-Path Test method for
	 * {@link com.pkm.hero.service.rest.client.HeroRestClient#getHeroes()}.
	 */
	@SuppressWarnings("unused")
	@Test(expected = HeroRestClientException.class)
	public void testGetHeroes_Fail() throws HeroRestClientException {

		HeroRestClient restClient = new HeroRestClient();
		restClient.setRequestBaseUrl(restClient.getRequestBaseUrl().replace(GOOD_PORT, BAD_PORT));

		List<Hero> heroes = restClient.getHeroes();
	}

	/**
	 * Non-Happy-Path Test method for
	 * {@link com.pkm.hero.service.rest.client.HeroRestClient#getHeroes()}.
	 */
	@SuppressWarnings("unused")
	@Test(expected = HeroRestClientException.class)
	public void testInvalidUrl() throws HeroRestClientException {

		HeroRestClient restClient = new HeroRestClient();
		restClient.setRequestBaseUrl("not-gonna-work-url");

		List<Hero> heroes = restClient.getHeroes();
	}

	/**
	 * Non-Happy-Path Test method for
	 * {@link com.pkm.hero.service.rest.client.HeroRestClient#getHeroes()}.
	 */
	@SuppressWarnings("unused")
	@Test(expected = HeroRestClientException.class)
	public void test404Url() throws HeroRestClientException {

		HeroRestClient restClient = new HeroRestClient();
		restClient.setRequestBaseUrl(restClient.getRequestBaseUrl() + "404/");

		List<Hero> heroes = restClient.getHeroes();
	}

	/**
	 * Test method for
	 * {@link com.pkm.hero.service.rest.client.HeroRestClient#addHero(com.pkm.hero.dto.Hero)}
	 * .
	 */
	public void testAddHero() {
		HeroRestClient restClient = new HeroRestClient();

		try {

			// Assert that the test hero is not in the list of current heroes
			List<Hero> heroes_pre = restClient.getHeroes();

			assertFalse(heroes_pre.contains(testHero));

			// Add the test hero, and assert that the hero returned-as-saved is
			// equivalent to the test hero
			Hero savedHero = restClient.addHero(testHero);

			System.out.println(testHero);
			System.out.println(savedHero);

			assertNotNull(savedHero);
			assertTrue(savedHero instanceof Hero);
			assertTrue(savedHero.getHeroName().equals(testHero.getHeroName()));
			assertTrue(savedHero.getSecretIdentity().equals(testHero.getSecretIdentity()));
			assertTrue(savedHero.getNumOthersWhoKnowSecret().equals(testHero.getNumOthersWhoKnowSecret()));
			assertTrue(savedHero.getUniverseId().equals(testHero.getUniverseId()));
			assertNull(savedHero.getCatchphrase());
			assertNotNull(savedHero.getInsertTime());
			assertNotNull(savedHero.getInsertUser());
			assertNull(savedHero.getUpdateTime());
			assertNull(savedHero.getUpdateUser());

			// Assert that that test hero is now in the list of current heroes
			List<Hero> heroes_post = restClient.getHeroes();

			assertTrue(heroes_post.contains(savedHero));

			// Save the savedHero in the testHero field
			testHero = savedHero;
		} catch (HeroRestClientException e) {
			e.printStackTrace();
			fail("Failed with exception: " + e);
		}
	}

	/**
	 * Non-Happy-Path Test method for
	 * {@link com.pkm.hero.service.rest.client.HeroRestClient#addHero(com.pkm.hero.dto.Hero)}
	 * .
	 */
	@SuppressWarnings("unused")
	@Test(expected = HeroRestClientException.class)
	public void testAddHero_Fail() throws HeroRestClientException {
		HeroRestClient restClient = new HeroRestClient();
		restClient.setRequestBaseUrl(restClient.getRequestBaseUrl().replace(GOOD_PORT, BAD_PORT));

		Hero savedHero = restClient.addHero(testHero);
	}

	/**
	 * Test method for
	 * {@link com.pkm.hero.service.rest.client.HeroRestClient#updateHero(com.pkm.hero.dto.Hero)}
	 * .
	 */
	public void testUpdateHero() {
		HeroRestClient restClient = new HeroRestClient();

		try {

			// Assert that the test hero is in the list of current heroes
			List<Hero> heroes_pre = restClient.getHeroes();

			assertTrue(heroes_pre.contains(testHero));

			// Update the test hero with a new catchphrase
			testHero.setCatchphrase("My Test Catchphrase!");

			Hero updatedHero = restClient.updateHero(testHero);

			assertNotNull(updatedHero);
			assertTrue(updatedHero instanceof Hero);
			assertTrue(updatedHero.getHeroName().equals(testHero.getHeroName()));
			assertTrue(updatedHero.getSecretIdentity().equals(testHero.getSecretIdentity()));
			assertTrue(updatedHero.getNumOthersWhoKnowSecret().equals(testHero.getNumOthersWhoKnowSecret()));
			assertTrue(updatedHero.getUniverseId().equals(testHero.getUniverseId()));
			assertNotNull(updatedHero.getInsertTime());
			assertNotNull(updatedHero.getInsertUser());
			assertNotNull(updatedHero.getUpdateTime());
			assertNotNull(updatedHero.getUpdateUser());

			// Assert the new Catchphrase
			assertNotNull(updatedHero.getCatchphrase());
			assertEquals(updatedHero.getCatchphrase(), testHero.getCatchphrase());

			// Assert that that test hero is now in the list of current heroes
			List<Hero> heroes_post = restClient.getHeroes();

			assertTrue(heroes_post.contains(updatedHero));

			// Save the updatedHero in the testHero field
			testHero = updatedHero;
		} catch (HeroRestClientException e) {
			e.printStackTrace();
			fail("Failed with exception: " + e);
		}
	}

	/**
	 * Non-Happy-Path Test method for
	 * {@link com.pkm.hero.service.rest.client.HeroRestClient#updateHero(com.pkm.hero.dto.Hero)}
	 * .
	 */
	@SuppressWarnings("unused")
	@Test(expected = HeroRestClientException.class)
	public void testUpdateHero_Fail() throws HeroRestClientException {
		HeroRestClient restClient = new HeroRestClient();
		restClient.setRequestBaseUrl(restClient.getRequestBaseUrl().replace(GOOD_PORT, BAD_PORT));

		Hero savedHero = restClient.updateHero(testHero);
	}

	/**
	 * Test method for
	 * {@link com.pkm.hero.service.rest.client.HeroRestClient#deleteHero(com.pkm.hero.dto.Hero)}
	 * .
	 */
	public void testDeleteHero() {
		HeroRestClient restClient = new HeroRestClient();

		try {

			// Assert that the test hero is in the list of current heroes
			List<Hero> heroes_pre = restClient.getHeroes();

			assertTrue(heroes_pre.contains(testHero));

			// Remove the test hero
			restClient.deleteHero(testHero);

			// Assert that that test hero is now in the list of current heroes
			List<Hero> heroes_post = restClient.getHeroes();

			assertFalse(heroes_post.contains(testHero));
		} catch (HeroRestClientException e) {
			e.printStackTrace();
			fail("Failed with exception: " + e);
		}
	}

	/**
	 * Non-Happy-Path Test method for
	 * {@link com.pkm.hero.service.rest.client.HeroRestClient#deleteHero(com.pkm.hero.dto.Hero)}
	 * .
	 */
	@SuppressWarnings("unused")
	@Test(expected = HeroRestClientException.class)
	public void testDeleteHero_Fail() throws HeroRestClientException {
		HeroRestClient restClient = new HeroRestClient();
		restClient.setRequestBaseUrl(restClient.getRequestBaseUrl().replace(GOOD_PORT, BAD_PORT));

		Hero savedHero = restClient.deleteHero(testHero);
	}

}
