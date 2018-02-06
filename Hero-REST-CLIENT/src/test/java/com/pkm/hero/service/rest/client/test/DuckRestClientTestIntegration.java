package com.pkm.hero.service.rest.client.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pkm.hero.dto.Duck;
import com.pkm.hero.dto.Hero;
import com.pkm.hero.service.rest.client.DuckRestClient;
import com.pkm.hero.service.rest.client.HeroRestClient;
import com.pkm.hero.service.rest.exception.HeroRestClientException;

public class DuckRestClientTestIntegration {

	/** Default Universe Id */
	private final static int DEFAULT_UNIVERSE_ID = 616;

	/** Bad Port to simulate error cases */
	private final static String BAD_PORT = "9080";

	/** Good Port to simulate success cases */
	private final static String GOOD_PORT = "8080";

	/** Duck object with which to test */
	private static Duck testDuck;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		long time = System.currentTimeMillis();

		testDuck = new Duck();
		testDuck.setDuckName("TestDuck_" + time);
		testDuck.setQuack("Quack Fu!");
		testDuck.setQuackedOff(true);
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
	 * Tests adding a Duck to the HeroService, which should fail
	 */
	@Test
	public void testAddDuck() {
		DuckRestClient restClient = new DuckRestClient();

		try {

			// Add the test duck, and assert that we receive a nice/proper exception
			Duck savedDuck = restClient.addDuck(testDuck);

			System.out.println(testDuck);
			System.out.println(savedDuck);

//			assertNotNull(savedHero);
//			assertTrue(savedHero instanceof Hero);
//			assertTrue(savedHero.getHeroName().equals(testHero.getHeroName()));
//			assertTrue(savedHero.getSecretIdentity().equals(testHero.getSecretIdentity()));
//			assertTrue(savedHero.getNumOthersWhoKnowSecret().equals(testHero.getNumOthersWhoKnowSecret()));
//			assertTrue(savedHero.getUniverseId().equals(testHero.getUniverseId()));
//			assertNull(savedHero.getCatchphrase());
//			assertNotNull(savedHero.getInsertTime());
//			assertNotNull(savedHero.getInsertUser());
//			assertNull(savedHero.getUpdateTime());
//			assertNull(savedHero.getUpdateUser());
//
//			// Assert that that test hero is now in the list of current heroes
//			List<Hero> heroes_post = restClient.getHeroes();
//
//			assertTrue(heroes_post.contains(savedHero));
		} catch (HeroRestClientException e) {
			e.printStackTrace();
			fail("Failed with exception: " + e);
		}
	}

	/**
	 * Test method for
	 * {@link com.pkm.hero.service.rest.client.HeroRestClient#getHeroes()}.
	 */
	@Test
	public void testGetHeroes() {
	}


	/**
	 * Test method for
	 * {@link com.pkm.hero.service.rest.client.HeroRestClient#updateHero(com.pkm.hero.dto.Hero)}
	 * .
	 */
	public void testUpdateHero() {
	}

	/**
	 * Test method for
	 * {@link com.pkm.hero.service.rest.client.HeroRestClient#deleteHero(com.pkm.hero.dto.Hero)}
	 * .
	 */
	public void testDeleteHero() {
	}
}
