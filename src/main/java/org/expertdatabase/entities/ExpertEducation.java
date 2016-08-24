package org.expertdatabase.entities;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpertEducation {

	@JsonProperty("EDUCATIONID")
	private int education_id;
	
	@JsonProperty("EDUCATION")
	private String graduate_status;
	
	@JsonProperty("EDUCATEDDATE")
	private Date graduated_date;
	
	@JsonProperty("DESCRIPTION")
	private String education_description;


	public int getEducation_id() {
		return education_id;
	}

	public void setEducation_id(int education_id) {
		this.education_id = education_id;
	}

	public String getGraduate_status() {
		return graduate_status;
	}

	public void setGraduate_status(String graduate_status) {
		this.graduate_status = graduate_status;
	}

	public Date getGraduated_date() {
		return graduated_date;
	}

	public void setGraduated_date(Date graduated_date) {
		this.graduated_date = graduated_date;
	}

	public String getEducation_description() {
		return education_description;
	}

	public void setEducation_description(String education_description) {
		this.education_description = education_description;
	}	
	
}
