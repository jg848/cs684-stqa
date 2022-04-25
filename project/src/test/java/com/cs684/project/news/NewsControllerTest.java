package com.cs684.project.news;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author Jaswin
 *
 */
public class NewsControllerTest {

	String uri;
	RestTemplate restTemplate;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		uri = "http://localhost:8080/";
		restTemplate = new RestTemplate();
	}

	/**
	 * Test method for successfully getting news.
	 */
	@Test
	public final void testGetNewsSuccess() {
		NewsResponse result = restTemplate.getForObject(uri + "news/bob12345/general", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("OK"));
	}

	/**
	 * Test method for failing to get news due to empty user parameter.
	 */
	@Test(expected = HttpClientErrorException.class)
	public final void testGetNewsEmptyUser() {
		NewsResponse result = restTemplate.getForObject(uri + "/news//general", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("BAD-REQUEST"));
	}

	/**
	 * Test method for failing to get news due to empty user parameter.
	 */
	@Test(expected = HttpClientErrorException.class)
	public final void testGetNewsBlankUser() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/ /general", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("BAD-REQUEST"));
	}

	// Below tests removed due to addition of news/{user} endpoint
	/**
	 * Test method for failing to get news due to empty category parameter.
	 */
	/*
	 * @Test(expected = HttpClientErrorException.class) public final void
	 * testGetNewsEmptyCategory() { NewsResponse result =
	 * restTemplate.getForObject(uri + "/news/bob12345/", NewsResponse.class);
	 * assertTrue(result.getStatus().equalsIgnoreCase("BAD-REQUEST")); }
	 * 
	 *//**
		 * Test method for failing to get news due to empty category parameter.
		 *//*
			 * @Test(expected = HttpClientErrorException.class) public final void
			 * testGetNewsBlankCategory() { NewsResponse result =
			 * restTemplate.getForObject(uri + "/news/bob12345/ ", NewsResponse.class);
			 * assertTrue(result.getStatus().equalsIgnoreCase("BAD-REQUEST")); }
			 */

	/**
	 * Test method for failing to get news due to invalid user parameter.
	 */
	@Test(expected = HttpClientErrorException.class)
	public final void testGetNewsInvalidUser() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/user/general", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("FORBIDDEN"));
	}

	/**
	 * Test method for saving user settings successfully.
	 */
	@Test
	public final void testSaveSettingsSuccess() {
		NewsResponse result = restTemplate.getForObject(uri + "news/bob12345/settings?category=General",
				NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("OK"));
	}

	/**
	 * Test method for saving user settings with empty username.
	 */
	@Test(expected = HttpClientErrorException.class)
	public final void testSaveSettingsEmptyUser() {
		NewsResponse result = restTemplate.getForObject(uri + "news//settings?category=general", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("BAD-REQUEST"));
	}

	/**
	 * Test method for saving user settings with invalid username.
	 */
	@Test(expected = HttpClientErrorException.class)
	public final void testSaveSettingsInvalidUsername() {
		NewsResponse result = restTemplate.getForObject(uri + "news/user/settings?category=general",
				NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("NOT_FOUND"));
	}

	/**
	 * Test method for saving user settings with invalid username.
	 */
	@Test(expected = HttpClientErrorException.class)
	public final void testSaveSettingsEmptyCategory() {
		NewsResponse result = restTemplate.getForObject(uri + "news/user/settings?category=", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("NOT_FOUND"));
	}

	/**
	 * Test method for successfully getting category news.
	 */
	@Test
	public final void testGetCategoryNewsSuccess() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/category/general", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("OK"));
	}

	/**
	 * Test method for failing to get news due to empty category parameter.
	 */
	@Test(expected = HttpClientErrorException.class)
	public final void testGetCategoryNewsEmptyCategory() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/category/", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("BAD-REQUEST"));
	}

	/**
	 * Test method for failing to get news due to empty category parameter.
	 */
	@Test(expected = HttpClientErrorException.class)
	public final void testGetCategoryNewsBlankCategory() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/category/ ", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("BAD-REQUEST"));
	}

	/**
	 * Test method for failing to get news due to invalid category parameter.
	 */
	@Test(expected = HttpClientErrorException.class)
	public final void testGetNewsInvalidCategory() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/defaultuser/general1", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("FORBIDDEN"));
	}

	/**
	 * Test method for successfully getting User news.
	 */
	@Test
	public final void testGetUserNewsSuccess() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/bob12345", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("OK"));
	}

	/**
	 * Test method for failing to get User news due to empty user parameter.
	 */
	@Test(expected = HttpClientErrorException.class)
	public final void testGetUserNewsEmptyUser() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("BAD-REQUEST"));
	}

	/**
	 * Test method for failing to get User news due to blank user parameter.
	 */
	@Test(expected = HttpClientErrorException.class)
	public final void testGetUserNewsBlankUser() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/ ", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("BAD-REQUEST"));
	}

	/**
	 * Test method for failing to get User news due to invalid user parameter.
	 */
	@Test(expected = HttpClientErrorException.class)
	public final void testGetUserNewsInvalidUser() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/user", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("FORBIDDEN"));
	}

	/**
	 * Test method for successfully getting search news.
	 */
	@Test
	public final void testGetSearchNewsSuccess() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/search/njit", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("OK"));
	}

	/**
	 * Test method for failing to get search news due to empty search terms
	 * parameter.
	 */
	@Test(expected = HttpClientErrorException.class)
	public final void testGetSearchNewsEmptySearchTerms() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/search/", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("BAD-REQUEST"));
	}

	/**
	 * Test method for failing to get search news due to blank search terms
	 * parameter.
	 */
	@Test(expected = HttpClientErrorException.class)
	public final void testGetSearchNewsBlankSearchTerms() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/search/ ", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("BAD-REQUEST"));
	}
	
	/**
	 * Test method for successfully getting search news.
	 */
	@Test
	public final void testGetAdvancedSearchNewsORSuccess() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/search/njit OR nyu", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("OK"));
	}
	
	/**
	 * Test method for successfully getting search news.
	 */
	@Test
	public final void testGetAdvancedSearchNewsANDSuccess() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/search/njit AND nyu", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("OK"));
	}
	
	/**
	 * Test method for successfully getting search news.
	 */
	@Test
	public final void testGetAdvancedSearchNewsParanthesesSuccess() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/search/(njit OR nyu) AND computer science", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("OK"));
	}

}
