package org.expertdatabase.entities.update;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateExpertDocument {

	@JsonProperty("DOCUMENT ID")
	private int document_id;
	
	@JsonProperty("STATUS")
	private String status;
	
	@JsonProperty("URL")
	private String url;
	
	@JsonProperty("STATE")
	private String state;
	
	@JsonProperty("DESCRIPTION")
	private String description;

	public int getDocument_id() {
		return document_id;
	}

	public void setDocument_id(int document_id) {
		this.document_id = document_id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
