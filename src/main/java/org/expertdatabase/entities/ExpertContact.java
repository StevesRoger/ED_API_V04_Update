package org.expertdatabase.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpertContact {
	
	@JsonProperty("CONTACTID")
	private int contact_id;
	
	@JsonProperty("EMAIL")
	private String expert_email;
	
	@JsonProperty("PHONE")
	private String expert_phone;
	
	@JsonProperty("LIKEDIN")
	private String expert_linked_in;
	
	@JsonProperty("WEBSITE")
	private String expert_website;

	public int getContact_id() {
		return contact_id;
	}

	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}

	public String getExpert_email() {
		return expert_email;
	}

	public void setExpert_email(String expert_email) {
		this.expert_email = expert_email;
	}

	public String getExpert_phone() {
		return expert_phone;
	}

	public void setExpert_phone(String expert_phone) {
		this.expert_phone = expert_phone;
	}

	public String getExpert_linked_in() {
		return expert_linked_in;
	}

	public void setExpert_linked_in(String expert_linked_in) {
		this.expert_linked_in = expert_linked_in;
	}

	public String getExpert_website() {
		return expert_website;
	}

	public void setExpert_website(String expert_website) {
		this.expert_website = expert_website;
	}
	
}
