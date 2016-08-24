package org.expertdatabase.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

	@JsonProperty("LOCATIONID")
	private int location_id;

	@JsonProperty("LOCATIONSTATUS")
	private String location_status;

	@JsonProperty("LOCATIONDESCRIPTION")
	private String location_description;

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getLocation_status() {
		return location_status;
	}

	public void setLocation_status(String location_status) {
		this.location_status = location_status;
	}

	public String getLocation_description() {
		return location_description;
	}

	public void setLocation_description(String location_description) {
		this.location_description = location_description;
	}
	
}
