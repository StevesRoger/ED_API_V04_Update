package org.expertdatabase.entities.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddLevel {
	
	@JsonProperty("LEVEL STATUS")
	private String status;
	
	@JsonProperty("LEVEL RANGE")
	private int range;


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}
	
	public static class UpdateLevel{
	
		@JsonProperty("LEVEL ID")
		private int id;
		
		@JsonProperty("LEVEL STATUS")
		private String status;
		
		@JsonProperty("LEVEL RANGE")
		private int range;

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

		public int getRange() {
			return range;
		}

		public void setRange(int range) {
			this.range = range;
		}
	}
}
