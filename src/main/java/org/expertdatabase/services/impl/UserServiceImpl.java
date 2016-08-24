package org.expertdatabase.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.expertdatabase.entities.apiuser.Role;
import org.expertdatabase.entities.apiuser.User;
import org.expertdatabase.entities.temp.UserKA;
import org.expertdatabase.repositories.UserRepository;
import org.expertdatabase.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findUserByName(String userName) {
		
		if(!userName.isEmpty())
			return userRepository.findUserByName(userName);
		else
			return null;
	}

	@Override
	public ArrayList<Role> findRoleById(int id) {
		if(id>0)
			return userRepository.findRoleById(id);
		else
			return null;
	}

	@Override
	public UserKA findUserByEmailAndPassword(String email, String password) {
		
		if(!email.isEmpty()&&!password.isEmpty())
			return userRepository.findUserByEmailAndPassword(email, password);
		else
			return null;
	}

}
