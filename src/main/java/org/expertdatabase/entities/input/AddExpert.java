package org.expertdatabase.entities.input;

import java.sql.Date;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddExpert {
		
	@JsonIgnore
	private int expertId;
	
	@JsonProperty("FULL NAME")
	private String expFullName;
	
	@JsonProperty("GENDER")
	private String expGender;
	
	@JsonProperty("DATE OF BIRTH")
	private Date expDob;
	
	@JsonProperty("CURRENT WORK")
	private String expCurrentWork;

	@JsonProperty("SALARY")
	private float expSalary;
	
	@JsonProperty("INTEREST")
	private String expInterest;
	
	@JsonProperty("YEAR EXPERIENCE")
	private short expYearExperience;
	
	@JsonProperty("IMAGE URL")
	private String expImageURL;
		
	@JsonProperty("LOCATION ID")
	private int locationId;
	
	@JsonProperty("ADDRESS")
	private AddExpertAddress address;
	
	@JsonProperty("CONTACTS")
	private ArrayList<AddExpertContact>contacts;
	
	@JsonProperty("EDUCATIONS")
	private ArrayList<AddExpertEducation>educations;
	
	@JsonProperty("DOCUMENTS")
	private ArrayList<AddExpertDocument>documents;
	
	@JsonProperty("EXPERIENCES")
	private ArrayList<AddExpertExperience>experiences;
	
	@JsonProperty("LANGUAGES")
	private ArrayList<AddExpertLanguage>languages;
	
	@JsonProperty("SKILLS")
	private ArrayList<AddExpertSkill>skills;
	
	@JsonProperty("POSITION ID")
	private ArrayList<Integer>positionIds;
	
	public int getExpertId() {
		return expertId;
	}

	public void setExpertId(int expertId) {
		this.expertId = expertId;
	}

	public String getExpFullName() {
		return expFullName;
	}

	public void setExpFullName(String expFullName) {
		this.expFullName = expFullName;
	}

	public String getExpGender() {
		return expGender;
	}

	public void setExpGender(String expGender) {
		this.expGender = expGender;
	}

	public Date getExpDob() {
		return expDob;
	}

	public void setExpDob(Date expDob) {
		this.expDob = expDob;
	}

	public String getExpCurrentWork() {
		return expCurrentWork;
	}

	public void setExpCurrentWork(String expCurrentWork) {
		this.expCurrentWork = expCurrentWork;
	}

	public float getExpSalary() {
		return expSalary;
	}

	public void setExpSalary(float expSalary) {
		this.expSalary = expSalary;
	}

	public String getExpInterest() {
		return expInterest;
	}

	public void setExpInterest(String expInterest) {
		this.expInterest = expInterest;
	}

	public short getExpYearExperience() {
		return expYearExperience;
	}

	public void setExpYearExperience(short expYearExperience) {
		this.expYearExperience = expYearExperience;
	}

	public String getExpImageURL() {
		return expImageURL;
	}

	public void setExpImageURL(String expImageURL) {
		this.expImageURL = expImageURL;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public AddExpertAddress getAddress() {
		return address;
	}

	public void setAddress(AddExpertAddress address) {
		this.address = address;
	}

	public ArrayList<AddExpertContact> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<AddExpertContact> contacts) {
		this.contacts = contacts;
	}

	public ArrayList<AddExpertEducation> getEducations() {
		return educations;
	}

	public void setEducations(ArrayList<AddExpertEducation> educations) {
		this.educations = educations;
	}

	public ArrayList<AddExpertDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(ArrayList<AddExpertDocument> documents) {
		this.documents = documents;
	}

	public ArrayList<AddExpertExperience> getExperiences() {
		return experiences;
	}

	public void setExperiences(ArrayList<AddExpertExperience> experiences) {
		this.experiences = experiences;
	}

	public ArrayList<AddExpertLanguage> getLanguages() {
		return languages;
	}

	public void setLanguages(ArrayList<AddExpertLanguage> languages) {
		this.languages = languages;
	}

	public ArrayList<AddExpertSkill> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<AddExpertSkill> skills) {
		this.skills = skills;
	}

	public ArrayList<Integer> getPositionIds() {
		return positionIds;
	}

	public void setPositionIds(ArrayList<Integer> positionIds) {
		this.positionIds = positionIds;
	}

	public static class AddExpertLanguage{
		
		@JsonProperty("LANGUAGE ID")
		private int languageId;
		
		@JsonProperty("LEVEL ID")
		private int levelId;

		public int getLanguageId() {
			return languageId;
		}

		public void setLanguageId(int languageId) {
			this.languageId = languageId;
		}

		public int getLevelId() {
			return levelId;
		}

		public void setLevelId(int levelId) {
			this.levelId = levelId;
		}
		
	}
	
	public static class AddExpertSkill{
		
		@JsonProperty("SKILL ID")
		private int skillId;
		
		@JsonProperty("LEVEL ID")
		private int levelId;

		public int getSkillId() {
			return skillId;
		}

		public void setSkillId(int skillId) {
			this.skillId = skillId;
		}

		public int getLevelId() {
			return levelId;
		}

		public void setLevelId(int levelId) {
			this.levelId = levelId;
		}
			
	}
}
