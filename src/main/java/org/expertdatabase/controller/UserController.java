package org.expertdatabase.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.expertdatabase.entities.temp.UserKA;
import org.expertdatabase.services.ExpertService;
import org.expertdatabase.services.UserService;
import org.expertdatabase.utilities.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private ExpertService expertService;
	
	private Map<String,Object>map;
	private ArrayList list;
	
/*	@RequestMapping(value="/find-profile-image/{expertId}",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public String findProfileImageById(@PathVariable("expertId")int expertId){
		map = new HashMap<String , Object>();
		return expertService.findProfileImageById(expertId);	
	}
		*/
	/*@RequestMapping(value="/find-user-by-email-password",method=RequestMethod.GET,
			headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>>findUserByEmailAndPassword(
			@RequestParam("email")String email,
			@RequestParam("password")String password){
		map = new HashMap<String , Object>();
		UserKA obj=userService.findUserByEmailAndPassword(email, password);
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
	}*/
	
	/*@RequestMapping(value = "/download-document/{documentId}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getDownloadData() throws Exception {
		
		File file = new File("C:/Users/Winter Solider/Documents/Book1.xlsx");
		
		byte[] output = FileCopyUtils.copyToByteArray(file);

	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("charset", "utf-8");
	    responseHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    responseHeaders.setContentLength(output.length);
	    responseHeaders.set("Content-disposition", "attachment; filename="+file.getName());

	    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	}*/
	
/*	
	@RequestMapping(value="/download-document/{documentId}", method=RequestMethod.GET)
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
	/*@RequestMapping(value = "/download-document/{documentId}", method = RequestMethod.GET,produces ="application/zip")
    public HttpEntity<byte[]> downloadDocument(@PathVariable("documentId")int documentId) throws IOException {
        
    	System.out.println("api"+documentId);
    	
    	File file = new File("C:/Users/Winter Solider/Pictures/uploads/sok channy/Chrysanthemum.jpg");
        byte[] document = FileCopyUtils.copyToByteArray(file);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
       // header.set("Content-Disposition", "inline; filename=" + file.getName());
        header.set("Content-Disposition", "attachment; filename=" + file.getName());
        header.setContentLength(document.length);

        return new HttpEntity<byte[]>(document, header);

    }*/

	/*@RequestMapping(value = "/download-document/{documentId}", method = RequestMethod.GET,produces ="application/zip")
	public void getFile(HttpServletResponse response) throws IOException {
		 File file = new File("C:/Users/Winter Solider/Documents/Book1.xlsx");
	    InputStream myStream = new FileInputStream(file);
	    response.setHeader("Content-disposition", "attachment;filename="+file.getName());
	    response.setContentType("application/zip");
	    IOUtils.copy(myStream, response.getOutputStream());
	    response.flushBuffer();
	}*/
}
