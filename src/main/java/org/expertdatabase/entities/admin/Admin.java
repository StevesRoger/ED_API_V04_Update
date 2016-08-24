package org.expertdatabase.entities.admin;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Admin {

	@JsonProperty("ADMINID")
	private int admin_id;
	
	@JsonProperty("ADMINNAME")
	private String admin_name;
	
	@JsonProperty("ADMINPASSWORD")
	private String password;
	
	@JsonProperty("ADMINROLE")
	private Role role;
	
	@JsonProperty("ADMINIMAGE")
	private String profile_image_url;

	@JsonProperty("CONTACTS")
	private ArrayList<AdminContact> contacts;
	
	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getProfile_image_url() {
		return profile_image_url;
	}

	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}

	public ArrayList<AdminContact> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<AdminContact> contacts) {
		this.contacts = contacts;
	}
}
