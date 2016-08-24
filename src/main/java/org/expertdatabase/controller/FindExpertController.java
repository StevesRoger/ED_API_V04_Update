package org.expertdatabase.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.expertdatabase.entities.Expert;
import org.expertdatabase.entities.temp.CounterExpert;
import org.expertdatabase.services.FindExpertService;

@RestController
@RequestMapping("/api/expert/find-by")
public class FindExpertController {

	@Autowired
	private FindExpertService findExpertService;
	
	private Map<String,Object>map;
	private ArrayList list;
	
	@RequestMapping(value="/expert-id/{expertId}",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>findExpertById(
			@PathVariable("expertId")int expertId){
		map=new HashMap<String,Object>();
		Expert exp;
		try{
			if((exp=findExpertService.findExpertById(expertId))!=null){
				map.put("CODE", "200");
				map.put("MESSAGE", "Success");
				map.put("DATA", exp);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE", "Not Found!");
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "exception");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/expert-name/{expertName}",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>findExpertByName(
			@PathVariable("expertName")String expertName){
		map=new HashMap<String,Object>();
		Expert exp;
		try{
			if((exp=findExpertService.findExpertByName(expertName))!=null){
				map.put("CODE", "200");
				map.put("MESSAGE", "Success");
				map.put("DATA", exp);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE", "Not Found!");
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "exception");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/skill-id",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>findExpertBySkillId(
			@RequestParam(value="skillId") List<String>skillId){
		map=new HashMap<String,Object>();
		List<CounterExpert> counter=findExpertService.countExpertBySkillId(skillId);
		list=findExpertService.findExpertBySkillId(skillId);
		for(String item:skillId)
		System.out.println("client finding expert by skill id="+item);
		try{
			if(!list.isEmpty()&&!counter.isEmpty()){
				map.put("CODE", "200");
				map.put("MESSAGE", "Success");
				map.put("DATA", list);
				map.put("COUNTER",counter);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE", "Not Found!");
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "exception");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/skill-name",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>findExpertBySkillName(
			@RequestParam(value="skillName") List<String>skillName){
		map=new HashMap<String,Object>();
		List<CounterExpert> counter=findExpertService.countExpertBySkillName(skillName);
		list=findExpertService.findExpertBySkillName(skillName);
		try{
			if(!list.isEmpty()&&!counter.isEmpty()){
				map.put("CODE", "200");
				map.put("MESSAGE", "Success");
				map.put("DATA", list);
				map.put("COUNTER",counter);
				
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE", "Not Found!");
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "exception");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/age-less-than/{age}",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>findExpertAgeLessThan(
			@PathVariable("age") int age){
		map=new HashMap<String,Object>();
		list=findExpertService.findExpertByAgeLessThan(age);
		try{
			if(!list.isEmpty()){
				map.put("CODE", "200");
				map.put("MESSAGE", "Success");
				map.put("DATA", list);
				
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE", "Not Found!");
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "exception");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/age-greater-than/{age}",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>findExpertAgeGreaterThan(
			@PathVariable("age") int age){
		map=new HashMap<String,Object>();
		list=findExpertService.findExpertByAgeGreaterThan(age);
		try{
			if(!list.isEmpty()){
				map.put("CODE", "200");
				map.put("MESSAGE", "Success");
				map.put("DATA", list);
				
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE", "Not Found!");
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "exception");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/age-between-age",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>findExpertBetweenAge(
			@RequestParam(value="age1",required=true,defaultValue="18")int age1,
			@RequestParam(value="age2",required=true,defaultValue="28")int age2){
		map=new HashMap<String,Object>();
		list=findExpertService.findExpertBetweenAge(age1,age2);
		try{
			if(!list.isEmpty()){
				map.put("CODE", "200");
				map.put("MESSAGE", "Success");
				map.put("DATA", list);
				
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE", "Not Found!");
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "exception");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/language-id",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>findExpertByLanguageId(
			@RequestParam(value="languageId") List<String> languageId){
		map=new HashMap<String,Object>();
		list=findExpertService.findExpertByLanguageId(languageId);
		try{
			if(!list.isEmpty()){
				map.put("CODE", "200");
				map.put("MESSAGE", "Success");
				map.put("DATA", list);
				
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE", "Not Found!");
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "exception");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/language-name",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>findExpertByLanguageName(
			@RequestParam(value="languageName") List<String> languageName){
		map=new HashMap<String,Object>();
		list=findExpertService.findExpertByLanguageName(languageName);
		try{
			if(!list.isEmpty()){
				map.put("CODE", "200");
				map.put("MESSAGE", "Success");
				map.put("DATA", list);
				
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE", "Not Found!");
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "exception");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/position-id",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>findExpertByPositionId(
			@RequestParam(value="positionId") List<String> positionId){
		map=new HashMap<String,Object>();
		list=findExpertService.findExpertByPositionId(positionId);
		try{
			if(!list.isEmpty()){
				map.put("CODE", "200");
				map.put("MESSAGE", "Success");
				map.put("DATA", list);
				
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE", "Not Found!");
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "exception");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/position-name",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>findExpertByPositionName(
			@RequestParam(value="positionName") List<String> positionName){
		map=new HashMap<String,Object>();
		list=findExpertService.findExpertByPositionName(positionName);
		try{
			if(!list.isEmpty()){
				map.put("CODE", "200");
				map.put("MESSAGE", "Success");
				map.put("DATA", list);
				
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE", "Not Found!");
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "exception");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
}
