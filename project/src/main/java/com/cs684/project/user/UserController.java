package com.cs684.project.user;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/signup")
	public ResponseEntity<UserResponse> signUp(@Valid @RequestParam String username,
			@Valid @RequestParam String password) {
		try {
			if (username.isBlank() || username.isEmpty() || password.isBlank() || password.isEmpty()) {
				throw new IllegalArgumentException();
			}
			Optional<User> user = userRepository.findByUsername(username);
			if (user.isPresent() && user.get().getUsername().equals(username)) {
				return new ResponseEntity<>(new UserResponse("User already exists.", user.get()),
						HttpStatus.UNAUTHORIZED);
			} else {
				User newUser = new User(username, password);
				userRepository.save(newUser);
				return ResponseEntity.ok(
						new UserResponse("User is signed up and authorized. User: " + newUser.toString(),newUser));
			}
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/signin")
	public ResponseEntity<UserResponse> signIn(@Valid @RequestParam String username,
			@Valid @RequestParam String password) {
		try {
			Optional<User> user = userRepository.findByUsername(username);

			if (user.isPresent() && user.get().getUsername().equals(username)) {
				return ResponseEntity.ok(new UserResponse("", user.get()));

			} else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}

		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getUser")
	public ResponseEntity<UserResponse> getUser(@Valid @RequestParam String username) {
		try {
			if (username.isBlank() || username.isEmpty()) {
				throw new IllegalArgumentException();
			}
			Optional<User> users = userRepository.findByUsername(username);

			if (users.isPresent()) {
				return ResponseEntity
						.ok(new UserResponse("User found.", users.get()));
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}