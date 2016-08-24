package org.expertdatabase.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpertExperience {

	@JsonProperty("EXPERIENCEID")
	private int experience_id;
	
	@JsonProperty("EXPERIENCE")
	private String experience_status;
	
	@JsonProperty("YEAR")
	private String experience_year;
	
	@JsonProperty("DESCRIPTION")
	private String experience_description;

	public int getExperience_id() {
		return experience_id;
	}

	public void setExperience_id(int experience_id) {
		this.experience_id = experience_id;
	}

	public String getExperience_status() {
		return experience_status;
	}

	public void setExperience_status(String experience_status) {
		this.experience_status = experience_status;
	}

	public String getExperience_year() {
		return experience_year;
	}

	public void setExperience_year(String experience_year) {
		this.experience_year = experience_year;
	}

	public String getExperience_description() {
		return experience_description;
	}

	public void setExperience_description(String experience_description) {
		this.experience_description = experience_description;
	}
	
}
