package org.expertdatabase.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.expertdatabase.entities.input.AddCategory;
import org.expertdatabase.entities.input.AddCategory.UpdateCategory;
import org.expertdatabase.entities.input.AddLanguage;
import org.expertdatabase.entities.input.AddLanguage.UpdateLanguage;
import org.expertdatabase.entities.input.AddLevel;
import org.expertdatabase.entities.input.AddLevel.UpdateLevel;
import org.expertdatabase.entities.input.AddLocation;
import org.expertdatabase.entities.input.AddLocation.UpdateLocation;
import org.expertdatabase.entities.input.AddPosition;
import org.expertdatabase.entities.input.AddPosition.UpdatePosition;
import org.expertdatabase.entities.input.AddSkill;
import org.expertdatabase.entities.input.AddSkill.UpdateSkill;
import org.expertdatabase.services.AddExpertService;
import org.expertdatabase.services.DeleteExpertService;
import org.expertdatabase.services.ExpertService;
import org.expertdatabase.services.UpdateExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/component")
public class ComponentController {

	@Autowired
	private ExpertService getExpertService;
	@Autowired
	private AddExpertService addExpertService;
	@Autowired
	private DeleteExpertService deleteExpertService;
	@Autowired
	private UpdateExpertService updateExpertService;
	
	private Map<String,Object>map;
	private ArrayList list;
	
	@RequestMapping(value="/skill-categories",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>selectAllSkillCategories(){
		map = new HashMap<String , Object>();
		list=getExpertService.selectAllSkillCategories();
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
	@RequestMapping(value="/positions",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> selectAllPositions(){
		map = new HashMap<String , Object>();
		try{
			if(!(list=getExpertService.selectAllPositions()).isEmpty()){
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
	
	@RequestMapping(value="/languages",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> selectAllLanguages(){
		map = new HashMap<String , Object>();
		try{
			if(!(list=getExpertService.selectAllLanguages()).isEmpty()){
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
	
	@RequestMapping(value="/locations",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> selectAllLocations(){
		map = new HashMap<String , Object>();
		try{
			if(!(list=getExpertService.selectAllLocations()).isEmpty()){
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
	
	
	@RequestMapping(value="/get-all-skills",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> selectAllSkills(){
		map = new HashMap<String , Object>();
		try{
			if(!(list=getExpertService.selectAllSkills()).isEmpty()){
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
	
	@RequestMapping(value="/levels",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> selectAllLevels(){
		map = new HashMap<String , Object>();
		try{
			if(!(list=getExpertService.selectAllLevels()).isEmpty()){
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
	
	@RequestMapping(value="/all-categories",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> selectAllCategories(){
		map = new HashMap<String , Object>();
		try{
			if(!(list=getExpertService.selectAllCategories()).isEmpty()){
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
	
	@RequestMapping(value="/skill-by-categoryId/{categoryId}",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> findSkillByCategory(
			@PathVariable("categoryId")int categoryId){
		map = new HashMap<String , Object>();
		try{
			if(!(list=getExpertService.selectSkillByCategoryId(categoryId)).isEmpty()){
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
	
	@RequestMapping(value="/add-language",method=RequestMethod.POST,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> addLanguage(
			@RequestBody AddLanguage language){
		map = new HashMap<String , Object>();
		try{
			if(addExpertService.addLanguage(language)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
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
	
	@RequestMapping(value="/add-position",method=RequestMethod.POST,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> addPosition(
			@RequestBody AddPosition position){
		map = new HashMap<String , Object>();
		try{
			if(addExpertService.addPosition(position)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
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
	
	@RequestMapping(value="/add-skill",method=RequestMethod.POST,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> addSkill(
			@RequestBody AddSkill skill){
		map = new HashMap<String , Object>();
		try{
			if(addExpertService.addSkill(skill)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
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
	
	@RequestMapping(value="/add-skill-category",method=RequestMethod.POST,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> addSkillCategory(
			@RequestBody AddCategory category){
		map = new HashMap<String , Object>();
		try{
			if(addExpertService.addSkillCategory(category)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
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
	
	@RequestMapping(value="/add-location",method=RequestMethod.POST,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> addLocation(
			@RequestBody AddLocation location){
		map = new HashMap<String , Object>();
		try{
			if(addExpertService.addLocation(location)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
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
	
	@RequestMapping(value="/add-level",method=RequestMethod.POST,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> addLevel(
			@RequestBody AddLevel level){
		map = new HashMap<String , Object>();
		try{
			if(addExpertService.addLevel(level)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
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
	
	@RequestMapping(value="/delete-language/{languageId}",method=RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteLanguage(
			@PathVariable("languageId")int languageId){
		map = new HashMap<String , Object>();
		try{
			if(deleteExpertService.deleteLanguage(languageId)){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
				map.put("STATUS", true);
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
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-position/{positionId}",method=RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deletePosition(
			@PathVariable("positionId")int positionId){
		map = new HashMap<String , Object>();
		try{
			if(deleteExpertService.deletePosition(positionId)){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
				map.put("STATUS", true);
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
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/delete-skill/{skillId}",method=RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteSkill(
			@PathVariable("skillId")int skillId){
		map = new HashMap<String , Object>();
		try{
			if(deleteExpertService.deleteSkill(skillId)){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
				map.put("STATUS", true);
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
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-category/{categoryId}",method=RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteSkillCategory(
			@PathVariable("categoryId")int categoryId){
		map = new HashMap<String , Object>();
		try{
			if(deleteExpertService.deleteSkillCategory(categoryId)){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
				map.put("STATUS", true);
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
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-location/{locationId}",method=RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteLocation(
			@PathVariable("locationId")int locationId){
		map = new HashMap<String , Object>();
		try{
			if(deleteExpertService.deleteLocation(locationId)){
				map.put("CODE", "500");
				map.put("MESSAGE","Success");
				map.put("STATUS", true);
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
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-level/{levelId}",method=RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteLevel(
			@PathVariable("levelId")int levelId){
		map = new HashMap<String , Object>();
		try{
			if(deleteExpertService.deleteLevel(levelId)){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
				map.put("STATUS", true);
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
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-language",method=RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateLanguage(
			@RequestBody UpdateLanguage language){
		map = new HashMap<String , Object>();
		try{
			if(updateExpertService.updateLanguage(language)){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
				map.put("STATUS", true);
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
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-location",method=RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateLocation(
			@RequestBody UpdateLocation location){
		map = new HashMap<String , Object>();
		try{
			if(updateExpertService.updateLocation(location)){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
				map.put("STATUS", true);
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
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@RequestMapping(value="/update-position",method=RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updatePosition(
			@RequestBody UpdatePosition position){
		map = new HashMap<String , Object>();
		try{
			if(updateExpertService.updatePosition(position)){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
				map.put("STATUS", true);
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
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@RequestMapping(value="/update-skill",method=RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateSkill(
			@RequestBody UpdateSkill skill){
		map = new HashMap<String , Object>();
		try{
			if(updateExpertService.updateSkill(skill)){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
				map.put("STATUS", true);
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
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@RequestMapping(value="/update-category",method=RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateSkillCategory(
			@RequestBody UpdateCategory category){
		map = new HashMap<String , Object>();
		try{
			if(updateExpertService.updateSkillCategory(category)){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
				map.put("STATUS", true);
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
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-level",method=RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateLevel(
			@RequestBody UpdateLevel level){
		map = new HashMap<String , Object>();
		try{
			if(updateExpertService.updateLevel(level)){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
				map.put("STATUS", true);
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
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/change-location-state",method=RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> changeLocationState(
			@RequestParam(value="state")boolean state,
			@RequestParam(value="locationId")int locationId){
		map = new HashMap<String , Object>();
		try{
			if(updateExpertService.changeLocationState(locationId,state)){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
				map.put("STATUS", true);
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
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
}
