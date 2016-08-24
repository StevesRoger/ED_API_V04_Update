package org.expertdatabase.entities.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddSkill {

	@JsonProperty("SKILL STATUS")
	private String status;
	
	@JsonProperty("CATEGORY ID")
	private int categoryId;

	public AddSkill(){
		super();
	}
	public AddSkill(String status, int categoryId) {
		this();
		this.status = status;
		this.categoryId = categoryId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public static class UpdateSkill{
		
		@JsonProperty("SKILL ID")
		private int id;
		
		@JsonProperty("SKILL STATUS")
		private String status;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
	}
}
