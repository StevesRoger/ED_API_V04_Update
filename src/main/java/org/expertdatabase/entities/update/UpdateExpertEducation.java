package org.expertdatabase.entities.update;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateExpertEducation {
	
	@JsonProperty("EDUCATION ID")
	private int education_id;
	
	@JsonProperty("STATUS")
	private String status;
	
	@JsonProperty("GRADUATED DATE")
	private Date graduatedDate;
	
	@JsonProperty("DESCRIPTION")
	private String description;

	public int getEducation_id() {
		return education_id;
	}

	public void setEducation_id(int education_id) {
		this.education_id = education_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getGraduatedDate() {
		return graduatedDate;
	}

	public void setGraduatedDate(Date graduatedDate) {
		this.graduatedDate = graduatedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
