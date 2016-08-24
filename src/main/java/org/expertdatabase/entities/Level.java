package org.expertdatabase.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Level {

	@JsonProperty("LEVELID")
	private int level_id;
	
	@JsonProperty("LEVELSTATUS")
	private String level_status;
	
	@JsonProperty("LEVELRANGE")
	private int level_range;
	
	public int getLevel_id() {
		return level_id;
	}
	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}
	public String getLevel_status() {
		return level_status;
	}
	public void setLevel_status(String level_status) {
		this.level_status = level_status;
	}
	public int getLevel_range() {
		return level_range;
	}
	public void setLevel_range(int level_range) {
		this.level_range = level_range;
	}
			
}
