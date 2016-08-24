package org.expertdatabase.entities.admin.input;

import java.util.ArrayList;

import org.expertdatabase.entities.admin.AdminContact;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddAdmin {
	
	@JsonIgnore
	private int id;
	
	@JsonProperty("ADMIN NAME")
	private String name;
	
	@JsonProperty("ADMIN PASSWORD")
	private String password;
	
	@JsonProperty("ROLE ID")
	private int roleId;
	
	@JsonProperty("ADMIN IMAGE")
	private String image;

	@JsonProperty("CONTACTS")
	private ArrayList<AdminContact> contacts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ArrayList<AdminContact> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<AdminContact> contacts) {
		this.contacts = contacts;
	}

	
}
