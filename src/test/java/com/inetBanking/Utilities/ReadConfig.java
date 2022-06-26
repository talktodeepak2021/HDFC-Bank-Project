package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties obj;
	
	public ReadConfig()
	{
		File src= new File("./Configuration/config.properties");
		try {
			FileInputStream fis= new FileInputStream(src);
			
			obj= new Properties();
			obj.load(fis);
			} catch(Exception e)
		{
				System.out.println("Exception is " +e.getMessage()        );
		}
	}
	
	public String  getApplicationURL() {
		String url=obj.getProperty("baseURL");
		return url;
	}
	
	public String  getusername() {
		String username=obj.getProperty("username");
		return username;
	}
	
	public String  getpassword() {
		String password=obj.getProperty("password");
		return password;
	}
	
	public String  getchrome() {
		String chromepath=obj.getProperty("chromepath");
		return chromepath;
	}
	
	public String  getedgepath() {
		String edgepath=obj.getProperty("edgepath");
		return edgepath;
	}


}
