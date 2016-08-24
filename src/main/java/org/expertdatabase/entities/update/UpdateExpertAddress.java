package org.expertdatabase.entities.update;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateExpertAddress {
	
	@JsonProperty("COMMUNE")
	private String commune="PP";
	
	@JsonProperty("DISTRICT")
	private String district="PP";
	
	@JsonProperty("CITY")
	private String city="PP";
	
	@JsonProperty("COUNTRY")
	private String country="PP";

	@JsonProperty("STREET NUMBER")
	private String street;
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
