package org.expertdatabase.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.expertdatabase.entities.admin.Admin;
import org.expertdatabase.entities.admin.AdminContact;
import org.expertdatabase.entities.admin.input.AddAdmin;
import org.expertdatabase.repositories.AdminRepository;
import org.expertdatabase.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public ArrayList<Admin> getAdmins() {
		// TODO Auto-generated method stub
		return adminRepository.getAdmins();
	}

	@Override
	public boolean changeStateExpert(boolean state, int expertId) {
		
		boolean temp=false;
		
		if(expertId>0)
			if(adminRepository.changeStateExpert(state, expertId)>0)
				temp=true;
		return temp;
	
	}

	@Override
	public boolean addAdmin(AddAdmin admin) {
		boolean temp=false;
		if(admin!=null){
			temp=adminRepository.addAdmin(admin);
			if(temp&&admin.getContacts()!=null){
				if(!admin.getContacts().isEmpty())
					adminRepository.addAdminContact(admin.getId(), admin.getContacts());
			}
		
		}
		return temp;
	}

	@Override
	public boolean addAdminContact(int id, List<AdminContact> contacts) {
		if(id>0&&contacts!=null)
			return adminRepository.addAdminContact(id, contacts);
		
		else
			return false;
	}

	@Override
	public Admin findAdminByNameAndPassword(String name, String password) {
		
		if(!name.isEmpty()&&!password.isEmpty())
			return adminRepository.findAdminByNameAndPassword(name, password);
		else
			return null;
	}

}
