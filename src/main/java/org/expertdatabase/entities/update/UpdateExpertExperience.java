package org.expertdatabase.entities.update;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateExpertExperience {

	@JsonProperty("EXPERIENCE ID")
	private int experience_id;
	
	@JsonProperty("STATUS")
	private String status;
	
	@JsonProperty("YEAR")
	private String year;
	
	@JsonProperty("DESCRIPTION")
	private String description;

	public int getExperience_id() {
		return experience_id;
	}

	public void setExperience_id(int experience_id) {
		this.experience_id = experience_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
		
}
