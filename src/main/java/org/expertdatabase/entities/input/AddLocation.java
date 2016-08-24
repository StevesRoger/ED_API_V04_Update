package org.expertdatabase.entities.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddLocation {
	
	@JsonProperty("LOCATION STATUS")
	private String status;

	@JsonProperty("DESCRIPTION")
	private String description;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
			
	public static class UpdateLocation{
		
		@JsonProperty("LOCATION ID")
		private int id;
		
		@JsonProperty("LOCATION STATUS")
		private String status;

		@JsonProperty("DESCRIPTION")
		private String description;
		
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
	}
}
