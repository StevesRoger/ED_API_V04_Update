package org.expertdatabase.entities.temp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CounterExpert {

	@JsonProperty("CATEGORYSTATUS")
	private String category_status;
	
	@JsonProperty("SKILLSTATUS")
	private String skill_status;
	
	@JsonProperty("COUNT")
	private int count;

	public String getCategory_status() {
		return category_status;
	}

	public void setCategory_status(String category_status) {
		this.category_status = category_status;
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
