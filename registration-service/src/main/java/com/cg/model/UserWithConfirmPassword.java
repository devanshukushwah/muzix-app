package com.cg.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserWithConfirmPassword {

	@Email
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private String confirmPassword;

	public UserWithConfirmPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserWithConfirmPassword(String email, String password, String confirmPassword) {
		super();
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
