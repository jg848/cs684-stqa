package com.cs684.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;

	@PostMapping("/users/signup")
	public ResponseEntity<String> signUp(@Valid @RequestParam String username, @Valid @RequestParam String password) {
		User newUser = new User(username, password);
		List<User> users = userRepository.findAll();
		for (User user : users) {
			if (user.equals(newUser)) {
				return new ResponseEntity<String>("Access denial due to duplicate username.", HttpStatus.UNAUTHORIZED);
			}
		}
		userRepository.save(newUser);
		return new ResponseEntity<String>("User is signed up and authorized.", HttpStatus.OK);
	}

	@PostMapping("/users/signin")
	public ResponseEntity<String> signIn(@Valid @RequestParam String username, @Valid @RequestParam String password) {
		User user = new User(username, password);
		List<User> users = userRepository.findAll();
		for (User other : users) {
			if (other.equals(user)) {
				userRepository.save(user);
				return new ResponseEntity<String>("User is authorized.", HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>("User is not authorized.", HttpStatus.UNAUTHORIZED);
	}

	@PostMapping("/users/signout")
	public ResponseEntity<String> signOut(@Valid @RequestParam String username, @Valid @RequestParam String password) {
		User user = new User(username, password);
		List<User> users = userRepository.findAll();
		for (User other : users) {
			if (other.equals(user)) {
				userRepository.save(user);
				return new ResponseEntity<String>("User is signed out.", HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>("User is not signed out.", HttpStatus.NOT_FOUND);
	}
}