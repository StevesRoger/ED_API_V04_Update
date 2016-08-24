package org.expertdatabase.entities;

import java.sql.Date;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Expert {

	@JsonProperty("STATE")
	private boolean expert_state;
	
	@JsonProperty("ID")
	private int expert_id;
	
	@JsonProperty("FULLNAME")
	private String expert_full_name;
	
	@JsonProperty("GENDER")
	private String expert_gender;
	
	@JsonProperty("DATEOFBIRTH")
	private Date expert_date_of_birth;
	
	@JsonProperty("AGE")
	private byte expert_age;
		
	@JsonProperty("CURRENTWORK")
	private String expert_current_work;
	
	@JsonProperty("SALARY")
	private float expert_salary;
	
	@JsonProperty("INTEREST")
	private String expert_interest;
	
	@JsonProperty("YEAREXPERIENCE")
	private byte expert_year_experience;
		
	@JsonProperty("IMAGEURL")
	private String expert_image_url;
			
	@JsonProperty("LOCATION")
	private Location location;
	
	@JsonProperty("ADDRESS")
	private ExpertAddress address;
	
	@JsonProperty("CONTACTS")
	private ArrayList<ExpertContact>contacts;
	
	@JsonProperty("EXPERIENCES")
	private ArrayList<ExpertExperience>experiences;
	
	@JsonProperty("EDUCATIONS")
	private ArrayList<ExpertEducation>educations;
	
	@JsonProperty("DOCUMENTS")
	private ArrayList<ExpertDocument>documents;
	
	@JsonProperty("SKILLS")
	private ArrayList<Skill>skills;
	
	@JsonProperty("POSITIONS")
	private ArrayList<Position>positions;
	
	@JsonProperty("LANGUAGES")
	private ArrayList<Language>languages;

	public boolean isExpert_state() {
		return expert_state;
	}

	public void setExpert_state(boolean expert_state) {
		this.expert_state = expert_state;
	}

	public int getExpert_id() {
		return expert_id;
	}

	public void setExpert_id(int expert_id) {
		this.expert_id = expert_id;
	}

	public String getExpert_full_name() {
		return expert_full_name;
	}

	public void setExpert_full_name(String expert_full_name) {
		this.expert_full_name = expert_full_name;
	}

	public String getExpert_gender() {
		return expert_gender;
	}

	public void setExpert_gender(String expert_gender) {
		this.expert_gender = expert_gender;
	}

	public Date getExpert_date_of_birth() {
		return expert_date_of_birth;
	}

	public void setExpert_date_of_birth(Date expert_date_of_birth) {
		this.expert_date_of_birth = expert_date_of_birth;
	}

	public byte getExpert_age() {
		return expert_age;
	}

	public void setExpert_age(byte expert_age) {
		this.expert_age = expert_age;
	}

	public String getExpert_current_work() {
		return expert_current_work;
	}

	public void setExpert_current_work(String expert_current_work) {
		this.expert_current_work = expert_current_work;
	}

	public float getExpert_salary() {
		return expert_salary;
	}

	public void setExpert_salary(float expert_salary) {
		this.expert_salary = expert_salary;
	}

	public String getExpert_interest() {
		return expert_interest;
	}

	public void setExpert_interest(String expert_interest) {
		this.expert_interest = expert_interest;
	}

	public byte getExpert_year_experience() {
		return expert_year_experience;
	}

	public void setExpert_year_experience(byte expert_year_experience) {
		this.expert_year_experience = expert_year_experience;
	}

	public String getExpert_image_url() {
		return expert_image_url;
	}

	public void setExpert_image_url(String expert_image_url) {
		this.expert_image_url = expert_image_url;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public ExpertAddress getAddress() {
		return address;
	}

	public void setAddress(ExpertAddress address) {
		this.address = address;
	}

	public ArrayList<ExpertContact> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<ExpertContact> contacts) {
		this.contacts = contacts;
	}

	public ArrayList<ExpertExperience> getExperiences() {
		return experiences;
	}

	public void setExperiences(ArrayList<ExpertExperience> experiences) {
		this.experiences = experiences;
	}

	public ArrayList<ExpertEducation> getEducations() {
		return educations;
	}

	public void setEducations(ArrayList<ExpertEducation> educations) {
		this.educations = educations;
	}

	public ArrayList<ExpertDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(ArrayList<ExpertDocument> documents) {
		this.documents = documents;
	}

	public ArrayList<Skill> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<Skill> skills) {
		this.skills = skills;
	}

	public ArrayList<Position> getPositions() {
		return positions;
	}

	public void setPositions(ArrayList<Position> positions) {
		this.positions = positions;
	}

	public ArrayList<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(ArrayList<Language> languages) {
		this.languages = languages;
	}	
}
