package org.expertdatabase.entities.update;

import java.sql.Date;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateExpert {
	
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
	private UpdateExpertAddress address;
	
	@JsonProperty("CONTACTS")
	private ArrayList<UpdateExpertContact>contacts;
	
	@JsonProperty("EDUCATIONS")
	private ArrayList<UpdateExpertEducation>educations;
	
	@JsonProperty("DOCUMENTS")
	private ArrayList<UpdateExpertDocument>documents;
	
	@JsonProperty("EXPERIENCES")
	private ArrayList<UpdateExpertExperience>experiences;
	
	@JsonProperty("LANGUAGES")
	private ArrayList<UpdateExpertLanguage>languages;
	
	@JsonProperty("SKILLS")
	private ArrayList<UpdateExpertSkill>skills;
	
	@JsonProperty("POSITION ID")
	private ArrayList<UpdateExpertPosition>positions;

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

	public UpdateExpertAddress getAddress() {
		return address;
	}

	public void setAddress(UpdateExpertAddress address) {
		this.address = address;
	}

	public ArrayList<UpdateExpertContact> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<UpdateExpertContact> contacts) {
		this.contacts = contacts;
	}

	public ArrayList<UpdateExpertEducation> getEducations() {
		return educations;
	}

	public void setEducations(ArrayList<UpdateExpertEducation> educations) {
		this.educations = educations;
	}

	public ArrayList<UpdateExpertDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(ArrayList<UpdateExpertDocument> documents) {
		this.documents = documents;
	}

	public ArrayList<UpdateExpertExperience> getExperiences() {
		return experiences;
	}

	public void setExperiences(ArrayList<UpdateExpertExperience> experiences) {
		this.experiences = experiences;
	}

	public ArrayList<UpdateExpertLanguage> getLanguages() {
		return languages;
	}

	public void setLanguages(ArrayList<UpdateExpertLanguage> languages) {
		this.languages = languages;
	}

	public ArrayList<UpdateExpertSkill> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<UpdateExpertSkill> skills) {
		this.skills = skills;
	}

	public ArrayList<UpdateExpertPosition> getPositions() {
		return positions;
	}

	public void setPositions(ArrayList<UpdateExpertPosition> positions) {
		this.positions = positions;
	}


	public static class UpdateExpertLanguage{
		
		@JsonProperty("OLD LANGUAGE ID")
		private int old_id;
		
		@JsonProperty("NEW LANGUAGE ID")
		private int new_id;
		
		@JsonProperty("LEVEL ID")
		private int levelId;

		public int getOld_id() {
			return old_id;
		}

		public void setOld_id(int old_id) {
			this.old_id = old_id;
		}

		public int getNew_id() {
			return new_id;
		}

		public void setNew_id(int new_id) {
			this.new_id = new_id;
		}

		public int getLevelId() {
			return levelId;
		}

		public void setLevelId(int levelId) {
			this.levelId = levelId;
		}
		
	}
	
	public static class UpdateExpertSkill{
		
		@JsonProperty("OLD SKILL ID")
		private int old_id;
		
		@JsonProperty("NEW SKILL ID")
		private int new_id;
		
		@JsonProperty("LEVEL ID")
		private int levelId;


		public int getOld_id() {
			return old_id;
		}

		public void setOld_id(int old_id) {
			this.old_id = old_id;
		}

		public int getNew_id() {
			return new_id;
		}

		public void setNew_id(int new_id) {
			this.new_id = new_id;
		}

		public int getLevelId() {
			return levelId;
		}

		public void setLevelId(int levelId) {
			this.levelId = levelId;
		}
			
	}
	
	public static class UpdateExpertPosition{
		
		@JsonProperty("OLD POSITION ID")
		private int old_id;
		
		@JsonProperty("NEW POSITION ID")
		private int new_id;

		public int getOld_id() {
			return old_id;
		}

		public void setOld_id(int old_id) {
			this.old_id = old_id;
		}

		public int getNew_id() {
			return new_id;
		}

		public void setNew_id(int new_id) {
			this.new_id = new_id;
		}	
	}
}
