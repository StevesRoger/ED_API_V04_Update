package org.expertdatabase.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.expertdatabase.entities.admin.Admin;
import org.expertdatabase.entities.admin.AdminContact;
import org.expertdatabase.entities.admin.input.AddAdmin;
import org.expertdatabase.entities.admin.input.AddAdminContact;
import org.expertdatabase.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	private Map<String,Object>map;
	private ArrayList list;
	
	@RequestMapping(value="/get-admins",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>selectAllAdmins(){
		map = new HashMap<String , Object>();
		list=adminService.getAdmins();
		try{
			if(!list.isEmpty()){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
				map.put("DATA", list);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/change-state-expert",method=RequestMethod.PUT,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>changeStateExpert(
			@RequestParam("state")boolean state,
			@RequestParam("expertId")int expertId){
		map = new HashMap<String , Object>();
		try{
			if(adminService.changeStateExpert(state, expertId)){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
				map.put("STATUS",true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS",false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}	

	@RequestMapping(value="/add-admin",method=RequestMethod.POST,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>addAdmin(
			@RequestBody AddAdmin admin){
		map = new HashMap<String , Object>();
		try{
			if(adminService.addAdmin(admin)){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/add-admin-contact",method=RequestMethod.POST,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>addAdminContact(
			@RequestParam("adminId")int adminId,
			@RequestBody AdminContact contacts){
		map = new HashMap<String , Object>();
		if(contacts!=null){
			list=new ArrayList<AddAdminContact>();
			list.add(contacts);
		}
		try{
			if(adminService.addAdminContact(adminId,list)){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/find-by-name-password",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>findAdminByNameAndPassword(
			@RequestParam("name")String name,
			@RequestParam("password")String password){
		map = new HashMap<String , Object>();
		Admin obj=adminService.findAdminByNameAndPassword(name, password);
		try{
			if(obj!=null){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
				map.put("DATE",obj);
				map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","not found");
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}	

}
