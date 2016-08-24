package org.expertdatabase.repositories;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.expertdatabase.entities.admin.Admin;
import org.expertdatabase.entities.admin.AdminContact;
import org.expertdatabase.entities.admin.Role;
import org.expertdatabase.entities.admin.input.AddAdmin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository {

	public ArrayList<Admin>getAdmins();
	
	public Role selectRoleByAdminId();
	
	public ArrayList<AdminContact>selectContactByAdminId();
	
	public int changeStateExpert(@Param("state")boolean state,@Param("expertId")int expertId);
	
	public ArrayList<Role>getRoles();
	
	public boolean addAdmin(AddAdmin admin);
	
	public boolean addAdminContact(@Param("id")int id,@Param("contacts")List<AdminContact>contacts);
	
	public Admin findAdminByNameAndPassword(@Param("name")String email,@Param("password")String password);
}
