package org.expertdatabase.entities.temp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountAll {

	@JsonProperty("COUNTEXPERT")
	private int countExpert;
	
	@JsonProperty("COUNTSKILL")
	private int countSkill;
	
	@JsonProperty("COUNTLANGUAGE")
	private int countLanguage;
	
	@JsonProperty("COUNTCATEGORY")
	private int countCategory;
	
	@JsonProperty("COUNTPOSITION")
	private int countPosition;
	
	@JsonProperty("COUNTLOCATION")
	private int countLocation;

	public int getCountExpert() {
		return countExpert;
	}

	public void setCountExpert(int countExpert) {
		this.countExpert = countExpert;
	}

	public int getCountSkill() {
		return countSkill;
	}

	public void setCountSkill(int countSkill) {
		this.countSkill = countSkill;
	}

	public int getCountLanguage() {
		return countLanguage;
	}

	public void setCountLanguage(int countLanguage) {
		this.countLanguage = countLanguage;
	}

	public int getCountCategory() {
		return countCategory;
	}

	public void setCountCategory(int countCategory) {
		this.countCategory = countCategory;
	}

	public int getCountPosition() {
		return countPosition;
	}

	public void setCountPosition(int countPosition) {
		this.countPosition = countPosition;
	}

	public int getCountLocation() {
		return countLocation;
	}

	public void setCountLocation(int countLocation) {
		this.countLocation = countLocation;
	}
	

}
