package org.expertdatabase.entities.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddExpertAddress {
	
	@JsonProperty("COMMUNE")
	private String commune;
	
	@JsonProperty("DISTRICT")
	private String district;
	
	@JsonProperty("CITY")
	private String city;
	
	@JsonProperty("COUNTRY")
	private String country;
	
	@JsonProperty("STREET NUMBER")
	private String street;
	
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	
}
