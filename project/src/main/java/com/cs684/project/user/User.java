package com.cs684.project.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
public class User {
	private @Id @GeneratedValue long id;
	private @NotBlank String username;
	private @NotBlank String password;
	private boolean general;
	private boolean business;
	private boolean entertainment;
	private boolean health;
	private boolean science;
	private boolean sports;
	private boolean technology;

	public User() {
	}

	public User(@NotBlank String username, @NotBlank String password) {
		this.username = username;
		this.password = password;
		this.general = true;
		this.business = false;
		this.entertainment = false;
		this.health = false;
		this.science = false;
		this.sports = false;
		this.technology = false;
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isGeneral() {
		return general;
	}

	public void setGeneral(boolean general) {
		this.general = general;
	}

	public boolean isBusiness() {
		return business;
	}

	public void setBusiness(boolean business) {
		this.business = business;
	}

	public boolean isEntertainment() {
		return entertainment;
	}

	public void setEntertainment(boolean entertainment) {
		this.entertainment = entertainment;
	}

	public boolean isHealth() {
		return health;
	}

	public void setHealth(boolean health) {
		this.health = health;
	}

	public boolean isScience() {
		return science;
	}

	public void setScience(boolean science) {
		this.science = science;
	}

	public boolean isSports() {
		return sports;
	}

	public void setSports(boolean sports) {
		this.sports = sports;
	}

	public boolean isTechnology() {
		return technology;
	}

	public void setTechnology(boolean technology) {
		this.technology = technology;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof User))
			return false;
		User user = (User) o;
		return username.equals(user.getUsername());
	}

	@Override
	public int hashCode() {
		return Long.valueOf(id).hashCode();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", general=" + general
				+ ", business=" + business + ", entertainment=" + entertainment + ", health=" + health + ", science="
				+ science + ", sports=" + sports + ", technology=" + technology + "]";
	}

}