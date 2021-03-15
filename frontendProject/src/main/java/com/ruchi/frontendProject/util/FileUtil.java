package com.ruchi.frontendProject.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil
{
    
	private static final String ABS_PATH = "C:\\Users\\Ruchi\\OneDrive\\Documents\\Ruchi\\Website\\Website\\frontendProject\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = null;
	
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	public static boolean uploadFile(HttpServletRequest request, MultipartFile file, String code) 
	{
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");     //extracting
		
		logger.info(REAL_PATH);                          // will show the log
		
		if(! new File(REAL_PATH).exists()) 
		{
			 new File(REAL_PATH).mkdirs();              //mkdirs means directory exist or not
		}
		
		if(!new File(ABS_PATH).exists()) 
		{
			new File(ABS_PATH).mkdirs();                 //mkdirs means directory exist or not
		}
		
		try 
		{
		    file.transferTo(new File(REAL_PATH + code + ".jpg"));   //transfer the file to both the location
			file.transferTo(new File(ABS_PATH + code + ".jpg"));    //transferTo() will upload the file
		}
		catch(IOException ex) 
		{
			ex.printStackTrace();
		}
		
		return true; 
	}
}
