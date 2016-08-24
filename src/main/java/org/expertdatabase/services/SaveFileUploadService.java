package org.expertdatabase.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.expertdatabase.utilities.FileUpload;
import org.springframework.stereotype.Service;

@Service
public class SaveFileUploadService {
	
	public boolean writeDocuments(ArrayList<FileUpload>lists,String directory){
		boolean temp=false;
		BufferedOutputStream stream=null;
		try{
		if(lists!=null){
			if(!lists.isEmpty()){
				  
				File dir=new File(directory);
				  
				if(!dir.exists())
				 dir.mkdirs();
				
				 for(FileUpload item:lists){
					   stream = new BufferedOutputStream(new FileOutputStream(new File(item.getFile())));
					   stream.write(item.getBytes());		 
					  }
				 }
				temp=true;
			}
		}catch(Exception e){
			e.printStackTrace();
			temp=false;
		}finally{
			if(stream!=null)
				try {
					stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return temp;
	}
	
}
