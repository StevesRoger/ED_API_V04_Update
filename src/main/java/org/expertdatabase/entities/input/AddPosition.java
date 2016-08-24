package org.expertdatabase.entities.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddPosition {

	@JsonProperty("POSITION STATUS")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public static class UpdatePosition{
		
		@JsonProperty("POSITION ID")
		private int id;
		
		@JsonProperty("POSITION STATUS")
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
