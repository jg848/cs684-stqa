package com.cs684.team.minions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TeamNameController {
	@GetMapping("/displayTeamName")
	public String displayTeamName() {
		String uri = "http://localhost:8080/callExternalApi";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
}
