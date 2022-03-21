package com.cs684.project.user;

public class UserResponse {
	private String message;
	private User user;

	public UserResponse(String message, User user) {
		super();
		this.message = message;
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
