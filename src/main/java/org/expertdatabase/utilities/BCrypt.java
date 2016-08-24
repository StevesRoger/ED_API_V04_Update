package org.expertdatabase.utilities;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCrypt {
	
public static void main(String[] args) {
	// Encrypt Password
		//System.out.println(new BCryptPasswordEncoder().encode("admin123!@"));
		//EncryptPassword basic authentication
	   // System.out.println(Base64.getUrlEncoder().encodeToString("dev:!@#$%api".getBytes()));
	 //SimpleDateFormat sd=new SimpleDateFormat("MMddhhmmss");
	 //System.out.println(sd.format(new Date()));
	 
	 String USER_DIR_KEY = "user.dir";
     String currentDir = System.getProperty(USER_DIR_KEY);

     System.out.println("Working Directory: " + currentDir);
}

}