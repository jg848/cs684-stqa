package com.cs684.project.news;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cs684.project.user.User;
import com.cs684.project.user.UserRepository;
import com.cs684.project.user.UserResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/news")
public class NewsController {

	private static String URI = "https://newsapi.org/v2/top-headlines";
	private static String COUNTRY_PARAM = "us";
	private static String CATEGORY_PARAM = "general";
	private static int PAGE_SIZE_PARAM = 100;
	private static int PAGE_PARAM = 1;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/{user}/{category}")
	public ResponseEntity<NewsResponse> getNews(@PathVariable String user, @PathVariable String category) {
		if (null == user || user.isBlank() || user.isEmpty()) {
			return new ResponseEntity<NewsResponse>(new NewsResponse("BAD_REQUEST", 0, null), HttpStatus.BAD_REQUEST);
		}
		if (null == category || category.isBlank() || category.isEmpty()) {
			return new ResponseEntity<NewsResponse>(new NewsResponse("BAD_REQUEST", 0, null), HttpStatus.BAD_REQUEST);
		}
		String[] categories = new String[] { "general", "business", "entertainment", "health", "science", "sports",
				"technology" };
		List<String> categoryList = new ArrayList<>(Arrays.asList(categories));
		if (!categoryList.contains(category)) {
			return new ResponseEntity<NewsResponse>(new NewsResponse("BAD_REQUEST", 0, null), HttpStatus.BAD_REQUEST);
		}

		Optional<User> username = userRepository.findByUsername(user);
		if (!username.isPresent()) {
			return new ResponseEntity<NewsResponse>(new NewsResponse("FORBIDDEN", 0, null), HttpStatus.FORBIDDEN);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer a2b37021ab474da6b08f09dd083c9c6b");
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<Object> entity = new HttpEntity<Object>(headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<NewsResponse> response = restTemplate.exchange(
				setURI(COUNTRY_PARAM, CATEGORY_PARAM, PAGE_SIZE_PARAM, PAGE_PARAM), HttpMethod.GET, entity,
				NewsResponse.class);

		COUNTRY_PARAM = "us";
		CATEGORY_PARAM = "general";
		PAGE_SIZE_PARAM = 100;
		PAGE_PARAM = 1;

		return response;
	}

	@GetMapping("/{user}")
	public ResponseEntity<NewsResponse> getUserNews(@PathVariable String user) {
		if (null == user || user.isBlank() || user.isEmpty()) {
			return new ResponseEntity<NewsResponse>(new NewsResponse("BAD_REQUEST", 0, null), HttpStatus.BAD_REQUEST);
		}
		List<ResponseEntity<NewsResponse>> responseList = new ArrayList<ResponseEntity<NewsResponse>>();
		if (!user.equals("defaultuser")) {
			Optional<User> username = userRepository.findByUsername(user);
			if (!username.isPresent()) {
				return new ResponseEntity<NewsResponse>(new NewsResponse("FORBIDDEN", 0, null), HttpStatus.FORBIDDEN);
			}

			if (username.get().isGeneral()) {
				CATEGORY_PARAM = "general";
				addAllArticles(responseList, user);
			}
			if (username.get().isBusiness()) {
				CATEGORY_PARAM = "business";
				addAllArticles(responseList, user);
			}
			if (username.get().isEntertainment()) {
				CATEGORY_PARAM = "entertainment";
				addAllArticles(responseList, user);
			}
			if (username.get().isHealth()) {
				CATEGORY_PARAM = "health";
				addAllArticles(responseList, user);
			}
			if (username.get().isScience()) {
				CATEGORY_PARAM = "science";
				addAllArticles(responseList, user);
			}
			if (username.get().isSports()) {
				CATEGORY_PARAM = "sports";
				addAllArticles(responseList, user);
			}
			if (username.get().isTechnology()) {
				CATEGORY_PARAM = "technology";
				addAllArticles(responseList, user);
			}

			int totalResults = 0;
			List<Article> articles = new ArrayList<Article>();
			String status = "";
			for (int i = 1; i < responseList.size(); i++) {
				if (null != responseList.get(0).getBody() && null != responseList.get(i).getBody()) {
					status = responseList.get(i).getBody().getStatus();
					totalResults += responseList.get(i).getBody().getTotalResults();
					articles.addAll(responseList.get(i).getBody().getArticles());
				}
			}

			sortList(articles);
			if (articles.size() > 250)
				articles = articles.subList(0, 250);

			return new ResponseEntity<NewsResponse>(new NewsResponse(status, totalResults, articles), HttpStatus.OK);
		} else {
			return getNews(user, "general");
		}
	}

	private void addAllArticles(List<ResponseEntity<NewsResponse>> responseList, String user) {

		ResponseEntity<NewsResponse> response = getNews(user, CATEGORY_PARAM);
		int page = 1;
		if (null != response && null != response.getBody() && response.getBody().getTotalResults() > 100) {
			for (int i = response.getBody().getTotalResults() < 250 ? response.getBody().getTotalResults() - 100
					: 150; i > 0; i = i - 100) {
				page++;
				PAGE_PARAM = page;
				ResponseEntity<NewsResponse> temp = getNews(user, CATEGORY_PARAM);
				if (null != response && null != response.getBody() && null != response.getBody().getArticles()
						&& null != temp && null != temp.getBody() && null != temp.getBody().getArticles()) {
					response.getBody().getArticles().addAll(temp.getBody().getArticles());
				}
			}
		}
		responseList.add(response);
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<NewsResponse> getCategoryNews(@PathVariable String category) {
		if (null == category || category.isBlank() || category.isEmpty()) {
			return new ResponseEntity<NewsResponse>(new NewsResponse("BAD_REQUEST", 0, null), HttpStatus.BAD_REQUEST);
		}
		CATEGORY_PARAM = category;
		return getNews("defaultuser", category);
	}

	@PostMapping("/{username}/settings")
	public ResponseEntity<UserResponse> saveSettings(@PathVariable String username, @RequestParam String categories) {
		if (null == username || username.isBlank() || username.isEmpty()) {
			return new ResponseEntity<>(new UserResponse("BAD_REQUEST", null), HttpStatus.BAD_REQUEST);
		}
		if (null == categories || categories.isBlank() || categories.isEmpty()) {
			return new ResponseEntity<>(new UserResponse("BAD_REQUEST", null), HttpStatus.BAD_REQUEST);
		}
		Optional<User> user = userRepository.findByUsername(username);

		if (user.isPresent() && user.get().getUsername().equalsIgnoreCase(username)) {
			if (categories.contains("General")) {
				user.get().setGeneral(true);
			} else {
				user.get().setGeneral(false);
			}
			if (categories.contains("Business")) {
				user.get().setBusiness(true);
			} else {
				user.get().setBusiness(false);
			}
			if (categories.contains("Entertainment")) {
				user.get().setEntertainment(true);
			} else {
				user.get().setEntertainment(false);
			}
			if (categories.contains("Health")) {
				user.get().setHealth(true);
			} else {
				user.get().setHealth(false);
			}
			if (categories.contains("Science")) {
				user.get().setScience(true);
			} else {
				user.get().setScience(false);
			}
			if (categories.contains("Sports")) {
				user.get().setSports(true);
			} else {
				user.get().setSports(false);
			}
			if (categories.contains("Technology")) {
				user.get().setTechnology(true);
			} else {
				user.get().setTechnology(false);
			}

			userRepository.save(user.get());
			return ResponseEntity.ok(new UserResponse("", user.get()));

		} else {
			return new ResponseEntity<>(new UserResponse("NOT_FOUND", null), HttpStatus.NOT_FOUND);
		}
	}

	private static String setURI(String country, String category, int pageSize, int page) {
		String uri = URI;
		if (null != country || null != category || -1 != pageSize || -1 != page) {
			uri += ("?");
			if (null != country) {
				uri += "country=" + country;
			} else {
				uri += "country=" + COUNTRY_PARAM;
			}
			if (null != category) {
				uri += "&category=" + category;
			} else {
				uri += "&category=" + CATEGORY_PARAM;
			}
			if (-1 != pageSize) {
				uri += "&pageSize=" + pageSize;
			} else {
				uri += "&pageSize=" + PAGE_SIZE_PARAM;
			}
			if (-1 != page) {
				uri += "&page=" + page;
			} else {
				uri += "&page=" + PAGE_PARAM;
			}
		}
		return uri.toString();
	}

	private void sortList(List<Article> articles) {
		Collections.sort(articles, new Comparator<Article>() {
			DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS zzz");

			@Override
			public int compare(Article o1, Article o2) {
				try {
					return f.parse(o1.getPublishedAt()).compareTo(f.parse(o2.getPublishedAt()));
				} catch (ParseException e) {
					return 0;
				}
			}
		});
	}

}
