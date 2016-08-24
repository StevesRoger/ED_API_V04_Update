package org.expertdatabase.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Skill {

	@JsonProperty("SKILLID")
	private int skill_id;
	
	@JsonProperty("SKILL")
	private String skill_status;

	@JsonProperty("LEVEL")
	private String level_status;
	
	@JsonProperty("RNAGE")
	private float level_range;
	
	public int getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}

	public String getSkill_status() {
		return skill_status;
	}

	public void setSkill_status(String skill_status) {
		this.skill_status = skill_status;
	}

	public String getLevel_status() {
		return level_status;
	}

	public void setLevel_status(String level_status) {
		this.level_status = level_status;
	}

	public float getLevel_range() {
		return level_range;
	}

	public void setLevel_range(float level_range) {
		this.level_range = level_range;
	}
	
	public static class TempSkill{
		
		@JsonProperty("ID")
		private int skill_id;
		
		@JsonProperty("SKILL")
		private String skill_status;
		
		@JsonProperty("COUNT")
		private int count;
		
		public int getSkill_id() {
			return skill_id;
		}

		public void setSkill_id(int skill_id) {
			this.skill_id = skill_id;
		}

		public String getSkill_status() {
			return skill_status;
		}

		public void setSkill_status(String skill_status) {
			this.skill_status = skill_status;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}	

	}
	
	public static class TempInnerSkill{
		
		@JsonProperty("ID")
		private int skill_id;
		
		@JsonProperty("SKILL")
		private String skill_status;

		public int getSkill_id() {
			return skill_id;
		}

		public void setSkill_id(int skill_id) {
			this.skill_id = skill_id;
		}

		public String getSkill_status() {
			return skill_status;
		}

		public void setSkill_status(String skill_status) {
			this.skill_status = skill_status;
		}
	}
}
