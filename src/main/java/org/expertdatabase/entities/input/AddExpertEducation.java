package org.expertdatabase.entities.input;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddExpertEducation {
	
	@JsonProperty("STATUS")
	private String status;
	
	@JsonProperty("GRADUATED DATE")
	private Date graduatedDate;
	
	@JsonProperty("DESCRIPTION")
	private String description;

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
