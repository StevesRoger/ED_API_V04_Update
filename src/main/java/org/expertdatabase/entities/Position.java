package org.expertdatabase.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Position {

	@JsonProperty("POSITIONID")
	private int position_id;
	
	@JsonProperty("POSITION")
	private String position_status;

	public int getPosition_id() {
		return position_id;
	}

	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}

	public String getPosition_status() {
		return position_status;
	}

	public void setPosition_status(String position_status) {
		this.position_status = position_status;
	}

}
