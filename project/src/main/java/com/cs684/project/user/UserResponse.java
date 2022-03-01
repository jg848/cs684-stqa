package com.cs684.project.user;

public class UserResponse {
	private String message;
	private Long id;
	private String username;

	public UserResponse(String message, Long id, String username) {
		super();
		this.message = message;
		this.id = id;
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
