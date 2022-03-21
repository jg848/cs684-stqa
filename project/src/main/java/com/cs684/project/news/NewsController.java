package com.cs684.project.news;

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

	@Autowired
	UserRepository userRepository;

	@GetMapping("{user}/{category}")
	public ResponseEntity<NewsResponse> getNews(@PathVariable String user, @PathVariable String category) {
		if (null == category || category.isBlank() || category.isEmpty()) {
			return new ResponseEntity<NewsResponse>(new NewsResponse(), HttpStatus.BAD_REQUEST);
		}
		if (null == user || user.isBlank() || user.isEmpty()) {
			return new ResponseEntity<NewsResponse>(new NewsResponse(), HttpStatus.BAD_REQUEST);
		}

		Optional<User> username = userRepository.findByUsername(user);
		if (!username.isPresent()) {
			return new ResponseEntity<NewsResponse>(new NewsResponse(), HttpStatus.FORBIDDEN);
		}

		String uri = "https://newsapi.org/v2/top-headlines?category=" + category + "&country=us";

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer a2b37021ab474da6b08f09dd083c9c6b");
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<Object> entity = new HttpEntity<Object>(headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<NewsResponse> response = restTemplate.exchange(uri, HttpMethod.GET, entity, NewsResponse.class);

		System.out.println(response.getBody().toString());
		return response;
	}

	@PostMapping("{username}/settings")
	public ResponseEntity<UserResponse> saveSettings(@PathVariable String username, @RequestParam String categories) {
		if (null == username || username.isBlank() || username.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (null == categories || categories.isBlank() || categories.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
