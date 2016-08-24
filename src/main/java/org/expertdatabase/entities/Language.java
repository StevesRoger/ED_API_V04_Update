package org.expertdatabase.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Language {

	@JsonProperty("LANGUAGEID")
	private int language_id;
	
	@JsonProperty("LANGUAGE")
	private String language_status;
	
	@JsonProperty("LEVEL")
	private String level_status;
	
	public int getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}

	public String getLanguage_status() {
		return language_status;
	}

	public void setLanguage_status(String language_status) {
		this.language_status = language_status;
	}

	public String getLevel_status() {
		return level_status;
	}

	public void setLevel_status(String level_status) {
		this.level_status = level_status;
	}
	
	public static class TempLanguage{
		
		@JsonProperty("ID")
		private int language_id;
		
		@JsonProperty("LANGUAGE")
		private String language_status;

		public int getLanguage_id() {
			return language_id;
		}

		public void setLanguage_id(int language_id) {
			this.language_id = language_id;
		}

		public String getLanguage_status() {
			return language_status;
		}

		public void setLanguage_status(String language_status) {
			this.language_status = language_status;
		}
			
	}
}
