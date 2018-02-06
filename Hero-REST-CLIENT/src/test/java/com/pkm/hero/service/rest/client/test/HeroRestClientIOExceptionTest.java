package com.pkm.hero.service.rest.client.test;

import static org.junit.Assert.*;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.pkm.hero.service.rest.client.HeroRestClient;
import com.pkm.hero.service.rest.client.RestClient;

@RunWith(MockitoJUnitRunner.class)
public class HeroRestClientIOExceptionTest {

	@Mock
	private CloseableHttpClient closeableHttpClient;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddHero() {
		
	}

	@Test
	public void testGetHeroes() {

//		RestClient restClient = Mockito.spy(new HeroRestClient());
//		when(restClient.createHttpClient()).thenReturn(null);
		
	}


	@Test
	public void testUpdateHero() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteHero() {
		fail("Not yet implemented");
	}

}
