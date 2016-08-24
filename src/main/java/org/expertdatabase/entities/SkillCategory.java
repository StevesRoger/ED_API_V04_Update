package org.expertdatabase.entities;

import java.util.ArrayList;

import org.expertdatabase.entities.Skill.TempSkill;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SkillCategory {

	@JsonProperty("CATEGORYID")
	private int category_id;
	
	@JsonProperty("CATEGORYSTATUS")
	private String category_status;
	
	@JsonProperty("DESCRIPTION")
	private String category_description;

	@JsonProperty("SKILLS")
	private ArrayList<TempSkill>skills;
	
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_status() {
		return category_status;
	}

	public void setCategory_status(String category_status) {
		this.category_status = category_status;
	}

	public String getCategory_description() {
		return category_description;
	}

	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}

	public ArrayList<TempSkill> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<TempSkill> skills) {
		this.skills = skills;
	}
	
	public static class TempCategory{
		
		@JsonProperty("ID")
		private int category_id;
		
		@JsonProperty("CATEGORYSTATUS")
		private String category_status;
		
		@JsonProperty("DESCRIPTION")
		private String category_description;

		@JsonProperty("COUNT")
		private int counts;

		
		public int getCategory_id() {
			return category_id;
		}

		public void setCategory_id(int category_id) {
			this.category_id = category_id;
		}

		public String getCategory_status() {
			return category_status;
		}

		public void setCategory_status(String category_status) {
			this.category_status = category_status;
		}

		public String getCategory_description() {
			return category_description;
		}

		public void setCategory_description(String category_description) {
			this.category_description = category_description;
		}

		public int getCounts() {
			return counts;
		}

		public void setCounts(int counts) {
			this.counts = counts;
		}
			
	}

}
