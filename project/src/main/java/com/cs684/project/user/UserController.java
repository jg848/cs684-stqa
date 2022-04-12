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
				return ResponseEntity
						.ok(new UserResponse("User is signed up and authorized. User: " + newUser.toString(), newUser));

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
			StringBuilder categories = new StringBuilder();
			if (username.isBlank() || username.isEmpty()) {
				throw new IllegalArgumentException();
			}
			Optional<User> users = userRepository.findByUsername(username);

			if (users.isPresent()) {
				if (users.get().isBusiness()) {
					if (categories.isEmpty())
						categories.append("business");
					else
						categories.append(", business");
				}
				if (users.get().isEntertainment()) {
					if (categories.isEmpty())
						categories.append("entertainment");
					else
						categories.append(", entertainment");
				}
				if (users.get().isGeneral()) {
					if (categories.isEmpty())
						categories.append("general");
					else
						categories.append(", general");
				}
				if (users.get().isHealth()) {
					if (categories.isEmpty())
						categories.append("health");
					else
						categories.append(", health");
				}
				if (users.get().isScience()) {
					if (categories.isEmpty())
						categories.append("science");
					else
						categories.append(", science");
				}
				if (users.get().isSports()) {
					if (categories.isEmpty())
						categories.append("sports");
					else
						categories.append(", sports");
				}
				if (users.get().isTechnology()) {
					if (categories.isEmpty())
						categories.append("technology");
					else
						categories.append(", technology");
				}
				return ResponseEntity.ok(new UserResponse(categories.toString(), users.get()));
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}