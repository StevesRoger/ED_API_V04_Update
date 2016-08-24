package org.expertdatabase.entities.update;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateExpertContact {
	
	@JsonProperty("CONTACT ID")
	private int contact_id;
		
	@JsonProperty("EMAIL")
	private String email;
	
	@JsonProperty("PHONE")
	private String phone;
	
	@JsonProperty("LIKED IN")
	private String linkedIn;
	
	@JsonProperty("WEBSITE")
	private String website;

	public int getContact_id() {
		return contact_id;
	}

	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
