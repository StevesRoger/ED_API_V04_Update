package org.expertdatabase.controller;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.expertdatabase.entities.ExpertAddress;
import org.expertdatabase.entities.Location;
import org.expertdatabase.entities.input.AddExpert;
import org.expertdatabase.entities.input.AddExpert.AddExpertLanguage;
import org.expertdatabase.entities.input.AddExpert.AddExpertSkill;
import org.expertdatabase.entities.input.AddExpertAddress;
import org.expertdatabase.entities.input.AddExpertContact;
import org.expertdatabase.entities.input.AddExpertDocument;
import org.expertdatabase.entities.input.AddExpertEducation;
import org.expertdatabase.entities.input.AddExpertExperience;
import org.expertdatabase.entities.temp.CountAll;
import org.expertdatabase.entities.update.UpdateExpert;
import org.expertdatabase.entities.update.UpdateExpert.UpdateExpertLanguage;
import org.expertdatabase.entities.update.UpdateExpert.UpdateExpertPosition;
import org.expertdatabase.entities.update.UpdateExpert.UpdateExpertSkill;
import org.expertdatabase.entities.update.UpdateExpertAddress;
import org.expertdatabase.entities.update.UpdateExpertContact;
import org.expertdatabase.entities.update.UpdateExpertDocument;
import org.expertdatabase.entities.update.UpdateExpertEducation;
import org.expertdatabase.entities.update.UpdateExpertExperience;
import org.expertdatabase.services.AddExpertService;
import org.expertdatabase.services.DeleteExpertService;
import org.expertdatabase.services.ExpertService;
import org.expertdatabase.services.SaveFileUploadService;
import org.expertdatabase.services.UpdateExpertService;
import org.expertdatabase.utilities.FileUpload;
import org.expertdatabase.utilities.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/expert")
public class ExpertController {

	@Autowired
	private ExpertService expertService;
	@Autowired
	private AddExpertService addExpertService;
	@Autowired
	private UpdateExpertService updateExpertService;
	@Autowired
	private DeleteExpertService deleteExpertService;
	@Autowired
	private SaveFileUploadService serviceFileUpload;
	@Autowired
	private String ROOTPATH;
	
	private final ArrayList<FileUpload>listFiles=new ArrayList<FileUpload>();
	private final FileUpload fileUpload=new FileUpload();
	
	private Map<String,Object>map;
	private ArrayList list;
	
	@RequestMapping(value="/count-all",method = RequestMethod.GET , 
			headers = "Accept=application/json")
	public ResponseEntity<Map<String , Object>> countAll(){
		map = new HashMap<String , Object>();
		CountAll count=null;
		try{
			if((count=expertService.countAll())!=null){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
				map.put("DATA",count);
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
	
	@RequestMapping(value="/get-limit-experts",method = RequestMethod.GET , 
			headers = "Accept=application/json")
	public ResponseEntity<Map<String , Object>> getExpertWithLimit(
			 @RequestParam(value = "page", required = false , defaultValue="1") int page,
			 @RequestParam(value="limit" , required = false , defaultValue="10") int limit){
		map = new HashMap<String , Object>();
		try{
			Pagination pagination = new Pagination();
			pagination.setLimit(limit);
			pagination.setPage(page);
			pagination.setTotalCount(expertService.countExpert());
			list = expertService.getAllExperts(pagination);
			if(!list.isEmpty()){
				map.put("CODE", "200");
				map.put("MESSAGE","Success");
				map.put("DATA", list);
				map.put("PAGINATION", pagination);
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
	
	@RequestMapping(value="/get-experts",method = RequestMethod.GET , 
			headers = "Accept=application/json")
	public ResponseEntity<Map<String , Object>> getExperts(){
		map = new HashMap<String , Object>();
		try{
			list = expertService.getAllExperts();
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
	
	@RequestMapping(value="/get-expert-address/{expertId}",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> selectExpertAddress(
			@PathVariable("expertId")int expertId){
		map = new HashMap<String , Object>();
		ExpertAddress expAdd=null;
		try{
			if((expAdd=expertService.selectExpertAddress(expertId))!=null){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("DATA", expAdd);
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
	
	@RequestMapping(value="/get-expert-location/{expertId}",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> selectExpertLocation(
			@PathVariable("expertId")int expertId){
		map = new HashMap<String , Object>();
		Location location=null;
		try{
			if((location=expertService.selectLocationByExpertId(expertId))!=null){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("DATA", location);
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
	
	@RequestMapping(value="/get-expert-contact/{expertId}",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> selectExpertContact(
			@PathVariable("expertId")int expertId){
		map = new HashMap<String , Object>();
		try{
			if(!(list=expertService.selectExpertContact(expertId)).isEmpty()){
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
	
	@RequestMapping(value="/get-expert-experience/{expertId}",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public  ResponseEntity<Map<String,Object>> selectExpertExperience(
			@PathVariable("expertId") int expertId){
		map = new HashMap<String , Object>();
		try{
			if(!(list=expertService.selectExpertExperience(expertId)).isEmpty()){
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
	
	@RequestMapping(value="/get-expert-education/{expertId}",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> selectExpertEducation(
			@PathVariable("expertId")int expertId){
		map = new HashMap<String , Object>();
		try{
			if(!(list=expertService.selectExpertEducation(expertId)).isEmpty()){
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
	@RequestMapping(value="/get-expert-document/{expertId}",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>selectExpertDocument(
				@PathVariable("expertId")int expertId){
			map = new HashMap<String , Object>();
			try{
				if(!(list=expertService.selectExpertDocument(expertId)).isEmpty()){
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
	@RequestMapping(value="/get-expert-skill/{expertId}",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>selectExpertSkill(
		@PathVariable("expertId")int expertId){
			map = new HashMap<String , Object>();
			try{
				if(!(list=expertService.selectExpertSkill(expertId)).isEmpty()){
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
	
	@RequestMapping(value="/get-expert-position/{expertId}",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> selectExpertPosition(
			@PathVariable("expertId")int expertId){
		map = new HashMap<String , Object>();
		try{
			if(!(list=expertService.selectExpertPosition(expertId)).isEmpty()){
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
	@RequestMapping(value="/get-expert-language/{expertId}",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> selectExpertLanguage(
			@PathVariable("expertId")int expertId){
		map = new HashMap<String , Object>();
		try{
			if(!(list=expertService.selectExpertLanguage(expertId)).isEmpty()){
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
	 
	@RequestMapping(value="/add-expert",method=RequestMethod.POST,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> addExpert(
			@RequestBody AddExpert expert){
		map = new HashMap<String , Object>();
		try{
			if(addExpertService.addExpert(expert)){
				String path=ROOTPATH+expert.getExpFullName();
				serviceFileUpload.writeDocuments(listFiles,path);
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}finally{
			if(listFiles!=null){
				if(!listFiles.isEmpty())
					listFiles.clear();
			}
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	@RequestMapping(value="/delete-expert/{expertId}",method=RequestMethod.DELETE,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> deleteExpert(
			@PathVariable("expertId")int expertId){
		map = new HashMap<String , Object>();
		try{
			if(deleteExpertService.deleteExpert(expertId)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add-expert-address/{expertId}",method=RequestMethod.POST,
			headers = "Accept=application/json")	
	public ResponseEntity<Map<String,Object>> addExpertAddress(
			@PathVariable("expertId")int expertId,
			@RequestBody AddExpertAddress address){
		map = new HashMap<String , Object>();
		try{
			if(addExpertService.addExpertAddress(expertId, address)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value="/add-expert-contact/{expertId}",method=RequestMethod.POST,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> addExpertContact(
			@PathVariable("expertId")int expertId,
			@RequestBody AddExpertContact contact){
		map = new HashMap<String , Object>();
		if(contact!=null){
			list=new ArrayList<AddExpertContact>();
			list.add(contact);
		}
		try{
			if(addExpertService.addExpertContacts(expertId,list)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/add-expert-education/{expertId}",method=RequestMethod.POST,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> addExpertEducation(
			@PathVariable("expertId")int expertId,
			@RequestBody AddExpertEducation education){
		map = new HashMap<String , Object>();
		if(education!=null){
			list=new ArrayList<AddExpertEducation>();
			list.add(education);
		}
		try{
			if(addExpertService.addExpertEducations(expertId, list)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add-expert-documnet/{expertId}",method=RequestMethod.POST,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> addExpertDocument(
			@PathVariable("expertId")int expertId,
			@RequestBody AddExpertDocument document){
		map = new HashMap<String , Object>();
		if(document!=null){
			list=new ArrayList<AddExpertDocument>();
			list.add(document);
		}
		try{
			if(addExpertService.addExpertDocuments(expertId, list)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add-expert-experience/{expertId}",method=RequestMethod.POST,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> addExpertExperience(
			@PathVariable("expertId")int expertId,
			@RequestBody AddExpertExperience experience){
		map = new HashMap<String , Object>();
		if(experience!=null){
			list=new ArrayList<AddExpertExperience>();
			list.add(experience);
		}
		try{
			if(addExpertService.addExpertExperiences(expertId, list)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add-expert-language/{expertId}",method=RequestMethod.POST,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> addExpertLanguage(
			@PathVariable("expertId")int expertId,
			@RequestBody AddExpertLanguage language){
		map = new HashMap<String , Object>();
		if(language!=null){
			list=new ArrayList<AddExpertLanguage>();
			list.add(language);
		}
		try{
			if(addExpertService.addExpertLanguages(expertId, list)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add-expert-skill/{expertId}",method=RequestMethod.POST,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> addExpertSkill(
			@PathVariable("expertId")int expertId,
			@RequestBody AddExpertSkill skill){
		map = new HashMap<String , Object>();
		if(skill!=null){
			list=new ArrayList<AddExpertSkill>();
			list.add(skill);
		}
		try{
			if(addExpertService.addExpertSkills(expertId, list)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add-expert-position/{expertId}",method=RequestMethod.POST,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> addExpertPosition(
			@PathVariable("expertId")int expertId,
			@RequestParam(value="positionIds")List<Integer>positionIds){
		map = new HashMap<String , Object>();
		try{
			if(addExpertService.addExpertPositions(expertId, positionIds)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-expert/{expertId}",method=RequestMethod.PUT,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> updateExpert(
			@PathVariable("expertId")int expertId,
			@RequestBody UpdateExpert expert){
		map = new HashMap<String , Object>();
		try{
			if(updateExpertService.updateExpert(expertId,expert)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-expert-address/{expertId}",method=RequestMethod.PUT,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> updateExpertAddress(
			@PathVariable("expertId")int expertId,
			@RequestBody UpdateExpertAddress address){
		map = new HashMap<String , Object>();
		try{
			if(updateExpertService.updateExpertAddress(expertId, address)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/update-expert-contact/{expertId}",method=RequestMethod.PUT,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> updateExpertContact(
			@PathVariable("expertId")int expertId,
			@RequestBody UpdateExpertContact contact){
		map = new HashMap<String , Object>();
		if(contact!=null){
			list=new ArrayList<UpdateExpertContact>();
			list.add(contact);
		}
		try{
			if(updateExpertService.updateExpertContacts(expertId, list)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-expert-education/{expertId}",method=RequestMethod.PUT,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> updateExpertEducation(
			@PathVariable("expertId")int expertId,
			@RequestBody UpdateExpertEducation education){
		map = new HashMap<String , Object>();
		if(education!=null){
			list=new ArrayList<UpdateExpertEducation>();
			list.add(education);
		}
		try{
			if(updateExpertService.updateExpertEducations(expertId, list)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-expert-document/{expertId}",method=RequestMethod.PUT,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> updateExpertDocument(
			@PathVariable("expertId")int expertId,
			@RequestBody UpdateExpertDocument document){
		map = new HashMap<String , Object>();
		if(document!=null){
			list=new ArrayList<UpdateExpertDocument>();
			list.add(document);
		}
		try{
			if(updateExpertService.updateExpertDocuments(expertId, list)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-expert-experience/{expertId}",method=RequestMethod.PUT,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> updateExpertExperience(
			@PathVariable("expertId")int expertId,
			@RequestBody UpdateExpertExperience experience){
		map = new HashMap<String , Object>();
		if(experience!=null){
			list=new ArrayList<UpdateExpertExperience>();
			list.add(experience);
		}
		try{
			if(updateExpertService.updateExpertExperiences(expertId, list)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	@RequestMapping(value="/update-expert-language/{expertId}",method=RequestMethod.PUT,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> updateExpertLanguage(
			@PathVariable("expertId")int expertId,
			@RequestBody UpdateExpertLanguage language){
		map = new HashMap<String , Object>();
		if(language!=null){
			list=new ArrayList<UpdateExpertLanguage>();
			list.add(language);
		}
		try{
			if(updateExpertService.updateExpertLanguages(expertId, list)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
	}
	@RequestMapping(value="/update-expert-skill/{expertId}",method=RequestMethod.PUT,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> updateExpertSkill(
			@PathVariable("expertId")int expertId,
			@RequestBody UpdateExpertSkill skill){
		map = new HashMap<String , Object>();
		if(skill!=null){
			list=new ArrayList<UpdateExpertSkill>();
			list.add(skill);
		}
		try{
			if(updateExpertService.updateExpertSkills(expertId, list)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-expert-position/{expertId}",method=RequestMethod.PUT,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> updateExpertPosition(
			@PathVariable("expertId")int expertId,
			@RequestBody UpdateExpertPosition position ){
		map = new HashMap<String , Object>();
		if(position!=null){
			list=new ArrayList<UpdateExpertPosition>();
			list.add(position);
		}
		
		try{
			if(updateExpertService.updateExpertPositions(expertId, list)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-expert-address",method=RequestMethod.DELETE,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> deleteExpertAddress(
			@RequestParam("expertId")int expertId,
			@RequestParam("addressId")int addressId){
		map = new HashMap<String , Object>();
		try{
			if(deleteExpertService.deleteExpertAddress(expertId, addressId)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-expert-contact",method=RequestMethod.DELETE,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> deleteExpertContact(
			@RequestParam("expertId")int expertId,
			@RequestParam("contactId")int contactId){
		map = new HashMap<String , Object>();
		try{
			if(deleteExpertService.deleteExpertContact(expertId, contactId)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-expert-education",method=RequestMethod.DELETE,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> deleteExpertEducation(
			@RequestParam("expertId")int expertId,
			@RequestParam("educationId")int educationId){
		map = new HashMap<String , Object>();
		try{
			if(deleteExpertService.deleteExpertEducation(expertId, educationId)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-expert-document",method=RequestMethod.DELETE,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> deleteExpertDocument(
			@RequestParam("expertId")int expertId,
			@RequestParam("documentId")int documentId){
		map = new HashMap<String , Object>();
		try{
			if(deleteExpertService.deleteExpertDocument(expertId, documentId)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-expert-experience",method=RequestMethod.DELETE,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> deleteExpertExperience(
			@RequestParam("expertId")int expertId,
			@RequestParam("experienceId")int experienceId){
		map = new HashMap<String , Object>();
		try{
			if(deleteExpertService.deleteExpertExperience(expertId, experienceId)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-expert-language",method=RequestMethod.DELETE,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> deleteExpertLanguage(
			@RequestParam("expertId")int expertId,
			@RequestParam("languageId")int languageId){
		map = new HashMap<String , Object>();
		try{
			if(deleteExpertService.deleteExpertLanguage(expertId, languageId)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-expert-skill",method=RequestMethod.DELETE,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> deleteExpertSkill(
			@RequestParam("expertId")int expertId,
			@RequestParam("skillId")int skillId){
		map = new HashMap<String , Object>();
		try{
			if(deleteExpertService.deleteExpertSkill(expertId, skillId)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete-expert-position",method=RequestMethod.DELETE,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> deleteExpertPosition(
			@RequestParam("expertId")int expertId,
			@RequestParam("positionId")int positionId){
		map = new HashMap<String , Object>();
		try{
			if(deleteExpertService.deleteExpertPosition(expertId, positionId)){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/upload-file", method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> uploadFile(
		@RequestParam(value="expertName",required=false,defaultValue="temp")String expertName,
	    @RequestParam(value="file",required=false) MultipartFile file) {
		map=new HashMap<String,Object>();
	  try {
		  if(file!=null){
			  String filePath=ROOTPATH+expertName+"/"+file.getOriginalFilename();
			  
			  SimpleDateFormat sd=new SimpleDateFormat("MMddhhmmss");
			  String key=sd.format(new Date());
			  
			  listFiles.add(new FileUpload(file.getBytes(),filePath,key));
			 	
			    map.put("MESSAGE", "Success");
			    map.put("CODE", "200");
			    map.put("PATH", filePath);
			    map.put("KEY", key);
		  }else{
			  map.put("MESSAGE", "Upload file error");
			  map.put("CODE", "303");
		  }
	  }
	  catch (Exception e) {	
		  map.put("MESSAGE", "Something is broken. Please contact to developers team!");
		  map.put("CODE", "ex003");
		  e.printStackTrace();
	}

	  return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	} 
	
	@RequestMapping(value = "/delete-upload-file/{key}", method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteUploadFile(
		@PathVariable("key") String key) {
		map=new HashMap<String,Object>();
	  try {
		  if(!key.isEmpty()){
			  if(!listFiles.isEmpty()){
			  	
				  for(FileUpload file:listFiles){
					  if(file.getKey().equalsIgnoreCase(key)){
						  listFiles.remove(file);
						  break;
					  }
				  }
					  
				  map.put("MESSAGE", "Delete Success");
				  map.put("CODE", "200");
			  }
			  
		  }else{
			  map.put("MESSAGE", "key not exists");
			  map.put("CODE", "303");
		  }
	  }
	  catch (Exception e) {	
		  map.put("MESSAGE", "Something is broken. Please contact to developers team!");
		  map.put("CODE", "ex003");
		  e.printStackTrace();
	}

	  return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	} 
	

	@RequestMapping(value = "/download-document/{documentId}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getDownloadData(
			@PathVariable("documentId")int documentId) {
		
		File file = null;
		HttpHeaders responseHeaders = null;
		byte[] bytes=null;
		
		try{
			file=new File(expertService.findDocumentURLById(documentId));
		
			bytes= FileCopyUtils.copyToByteArray(file);
		    
		    responseHeaders=new HttpHeaders();
		    responseHeaders.set("charset", "utf-8");
		    responseHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		    responseHeaders.setContentLength(bytes.length);
		    responseHeaders.set("Content-disposition", "attachment; filename="+file.getName());
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	    return new ResponseEntity<byte[]>(bytes, responseHeaders, HttpStatus.OK);
	}

	@RequestMapping(value="/find-profile-image/{expertId}",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> findProfileImageById(@PathVariable("expertId")int expertId){
		map = new HashMap<String , Object>();
		String str=expertService.findProfileImageById(expertId);
		try{
			if(!str.isEmpty()){
			map.put("CODE", "200");
			map.put("MESSAGE","Success");
			map.put("DATA", str);
			map.put("STATUS", true);
			}else{
				map.put("CODE", "303");
				map.put("MESSAGE","fail");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("CODE", "ex003");
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);	
	}
	
	/*@RequestMapping(value = "/download-document/{documentId}", method = RequestMethod.GET)
	public void downloadFiles(HttpServletRequest request,
			HttpServletResponse response) {

		ServletContext context = request.getServletContext();
		
		File downloadFile = new File("C:/Users/Winter Solider/Pictures/uploads/sok channy/Chrysanthemum.jpg");
		FileInputStream inputStream = null;
		OutputStream outStream = null;
		
		try {
			inputStream = new FileInputStream(downloadFile);

			response.setContentType(context.getMimeType("C:/Users/Winter Solider/Pictures/uploads/sok channy/Chrysanthemum.jpg"));
			response.setContentLength((int) downloadFile.length());

			// response header
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"",downloadFile.getName());
			response.setHeader(headerKey, headerValue);

			// Write response
			outStream = response.getOutputStream();
			IOUtils.copy(inputStream, outStream);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != inputStream)
					inputStream.close();
				if (null != inputStream)
					outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}*/
	

	/*@RequestMapping(value="/download-document/{documentId}", method=RequestMethod.GET)
	//@ResponseBody
	public FileSystemResource downloadFile(@PathVariable("documentId")int documentId) {
	    //Product product = productRepo.findOne(documentId);
	    return new FileSystemResource(new File("C:/Users/Winter Solider/Pictures/uploads/sok channy/Chrysanthemum.jpg"));
	}
	*/
	/*@RequestMapping(value="/download-document/{documentId}", method=RequestMethod.GET)
	public ResponseEntity<Resource> downloadFile(
			@PathVariable("documentId")int documentId) {
		System.out.println("\n********** Download File : ************\n");
		
		System.out.println(documentId);
		
		//HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.ALL);
		
		File file = FileUtils.getFile("C:/Users/Winter Solider/Pictures/uploads/sok channy/Chrysanthemum.jpg");
		
		FileSystemResource fileSystemResource = new FileSystemResource(file);
		
		return new ResponseEntity<Resource>(fileSystemResource, HttpStatus.OK);
	}*/
	/*@RequestMapping(value = "/upload-files", method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> uploadFiles(
		@RequestParam(value="expertName",required=false,defaultValue="temp")String expertName,
	    @RequestParam(value="files",required=false) List<MultipartFile> files) {
		map=new HashMap<String,Object>();
		List<String>listFileNames=new ArrayList<String>();
		BufferedOutputStream stream=null;
	  try {
		  if(files!=null){
			  String path=ROOTPATH+expertName+"/";
			   
			  File dir=new File(path);
				  
				  if(!dir.exists())
					  dir.mkdirs();
				  
			if(!files.isEmpty()){
			  for(MultipartFile item:files){
				  
			    stream = new BufferedOutputStream(new FileOutputStream(new File(path+item.getOriginalFilename())));
			    stream.write(item.getBytes());
			    
			    listFileNames.add(path+item.getOriginalFilename());
			 
			  }
			}
			    map.put("MESSAGE", "Success");
			    map.put("CODE", "200");
			    map.put("PATHS",listFileNames);
		  }else{
			  map.put("MESSAGE", "Upload file error");
			  map.put("CODE", "303");
		  }
	  }
	  catch (Exception e) {	
		  map.put("MESSAGE", "Something is broken. Please contact to developers team!");
		  map.put("CODE", "ex003");
		  e.printStackTrace();
	  }finally{
		  
		  if(stream!=null)
				try {
					stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  }

	  return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	} */
	
}
