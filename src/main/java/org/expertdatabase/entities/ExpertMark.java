package org.expertdatabase.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpertMark {

	@JsonProperty("ID")
	private int mark_id;
	
	@JsonProperty("EXPERTID")
	private int expert_id;
	
	@JsonProperty("DESCRIPTION")
	private String mark_description;

	public int getMark_id() {
		return mark_id;
	}

	public void setMark_id(int mark_id) {
		this.mark_id = mark_id;
	}

	public int getExpert_id() {
		return expert_id;
	}

	public void setExpert_id(int expert_id) {
		this.expert_id = expert_id;
	}

	public String getMark_description() {
		return mark_description;
	}

	public void setMark_description(String mark_description) {
		this.mark_description = mark_description;
	}
		
}
