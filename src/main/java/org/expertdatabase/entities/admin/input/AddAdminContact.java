package org.expertdatabase.entities.admin.input;

import java.util.ArrayList;

import org.expertdatabase.entities.admin.AdminContact;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddAdminContact {

	@JsonProperty("CONTACTS")
	private ArrayList<AdminContact> contacts;

	
	public ArrayList<AdminContact> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<AdminContact> contacts) {
		this.contacts = contacts;
	}
	
	
}
