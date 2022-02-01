package com.cs684.team.minions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ExternalApiCallController {
	@GetMapping("/callExternalApi")
	public String callExternalApi() {
		String uri = "https://cs684api.7g2rji63c728k.us-east-1.cs.amazonlightsail.com/hw3"+"?team=Minions";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
}
