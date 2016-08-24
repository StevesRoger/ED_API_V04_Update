package org.expertdatabase.entities.admin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminContact {

	@JsonProperty("EMAIL")
	private String email;
	
	@JsonProperty("PHONE")
	private String phone_number;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}	
}
