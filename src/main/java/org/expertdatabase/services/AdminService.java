package org.expertdatabase.services;

import java.util.ArrayList;
import java.util.List;
import org.expertdatabase.entities.admin.Admin;
import org.expertdatabase.entities.admin.AdminContact;
import org.expertdatabase.entities.admin.input.AddAdmin;

public interface AdminService {

	
	public ArrayList<Admin>getAdmins();
	
	public boolean changeStateExpert(boolean state,int expertId);
	
	public boolean addAdmin(AddAdmin admin);
	
	public boolean addAdminContact(int id,List<AdminContact>contacts);
	
	public Admin findAdminByNameAndPassword(String name,String password);
}
