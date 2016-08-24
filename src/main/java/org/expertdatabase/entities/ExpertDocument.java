package org.expertdatabase.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpertDocument {

	@JsonProperty("DOCUMENTID")
	private int document_id;
	
	@JsonProperty("DOCUMENTSTATUS")
	private String document_status;
	
	@JsonProperty("DOCUMENTURL")
	private String document_url;
	
	@JsonProperty("DOCUMENTSTATE")
	private String document_state;
	
	@JsonProperty("DOCUMENTDESCRIPTION")
	private String document_description;

	public int getDocument_id() {
		return document_id;
	}

	public void setDocument_id(int document_id) {
		this.document_id = document_id;
	}

	public String getDocument_status() {
		return document_status;
	}

	public void setDocument_status(String document_status) {
		this.document_status = document_status;
	}

	public String getDocument_url() {
		return document_url;
	}

	public void setDocument_url(String document_url) {
		this.document_url = document_url;
	}

	public String getDocument_state() {
		return document_state;
	}

	public void setDocument_state(String document_state) {
		this.document_state = document_state;
	}

	public String getDocument_description() {
		return document_description;
	}

	public void setDocument_description(String document_description) {
		this.document_description = document_description;
	}

}
