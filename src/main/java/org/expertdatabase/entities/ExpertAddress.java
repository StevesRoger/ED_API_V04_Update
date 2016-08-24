package org.expertdatabase.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpertAddress {

	@JsonProperty("ADDRESSID")
	private int expert_id;
	
	@JsonProperty("COMMUNE")
	private String expert_commune;
	
	@JsonProperty("DISTRICT")
	private String expert_district;
		
	@JsonProperty("CITY")
	private String expert_city;
	
	@JsonProperty("COUNTRY")
	private String expert_country;

	@JsonProperty("STREET")
	private String expert_street;
	
	public int getExpert_id() {
		return expert_id;
	}

	public void setExpert_id(int expert_id) {
		this.expert_id = expert_id;
	}

	public String getExpert_commune() {
		return expert_commune;
	}

	public void setExpert_commune(String expert_commune) {
		this.expert_commune = expert_commune;
	}

	public String getExpert_district() {
		return expert_district;
	}

	public void setExpert_district(String expert_district) {
		this.expert_district = expert_district;
	}

	public String getExpert_city() {
		return expert_city;
	}

	public void setExpert_city(String expert_city) {
		this.expert_city = expert_city;
	}

	public String getExpert_country() {
		return expert_country;
	}

	public void setExpert_country(String expert_country) {
		this.expert_country = expert_country;
	}

	public String getExpert_street() {
		return expert_street;
	}

	public void setExpert_street(String expert_street) {
		this.expert_street = expert_street;
	}

}
