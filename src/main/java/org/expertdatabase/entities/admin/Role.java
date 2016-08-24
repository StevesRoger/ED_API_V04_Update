package org.expertdatabase.entities.admin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Role {

	@JsonProperty("ROLEID")
	private int role_id; 
	
	@JsonProperty("ROLESTATUS")
	private String role_status;
	
	@JsonProperty("ROLEVALUE")
	private int role_value;
	
	@JsonProperty("ROLEDESCRIPTION")
	private String description;

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_status() {
		return role_status;
	}

	public void setRole_status(String role_status) {
		this.role_status = role_status;
	}

	public int getRole_value() {
		return role_value;
	}

	public void setRole_value(int role_value) {
		this.role_value = role_value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
