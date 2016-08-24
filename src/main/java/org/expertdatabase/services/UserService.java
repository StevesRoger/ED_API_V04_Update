package org.expertdatabase.services;

import java.util.ArrayList;
import org.expertdatabase.entities.apiuser.Role;
import org.expertdatabase.entities.apiuser.User;
import org.expertdatabase.entities.temp.UserKA;

public interface UserService {

	public User findUserByName(String userName);
	
	public ArrayList<Role> findRoleById(int id);

	public UserKA findUserByEmailAndPassword(String email,String password);
}
