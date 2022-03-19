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

	/**
	 * Test method for failing to get news due to empty category parameter.
	 */
	@Test(expected = HttpClientErrorException.class)
	public final void testGetNewsEmptyCategory() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/bob12345/", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("BAD-REQUEST"));
	}

	/**
	 * Test method for failing to get news due to empty category parameter.
	 */
	@Test(expected = HttpClientErrorException.class)
	public final void testGetNewsBlankCategory() {
		NewsResponse result = restTemplate.getForObject(uri + "/news/bob12345/ ", NewsResponse.class);
		assertTrue(result.getStatus().equalsIgnoreCase("BAD-REQUEST"));
	}

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
		NewsResponse result = restTemplate.getForObject(uri + "news/bob12345/settings?category=general",
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

}
