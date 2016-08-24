package org.expertdatabase.entities.temp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserKA {

	@JsonProperty("USERID")
	private int user_id;
	
	@JsonProperty("USERNAME")
	private String user_name;
	
	@JsonProperty("USERIMAGE")
	private String user_image;
	
	@JsonProperty("USEREMAIL")
	private String user_email;
	
	/*@JsonProperty("USERPASSWORD")
	private String user_password;*/

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_image() {
		return user_image;
	}

	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

/*	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
		*/
}
