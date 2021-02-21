package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	
	public ReadConfig()
	{
	File src=new File("./Configuration/config.properties");
	
	try
	{
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
		
	}
	catch(Exception e)
	{
		System.out.println("Exception is "+e.getMessage());
	}
	}
	public String getApplicationUrl()
	{
		String url=pro.getProperty("Baseurl");
		return url;
	}
	public String getUserName()
	{
		String Uname=pro.getProperty("userName");
		return Uname;
	}
	public String getPassword()
	{
		String pass=pro.getProperty("password");
		return pass;
		
		
	}
	public String getChrompath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
		
	}
	public String getiepath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
		
	}
	public String getfirefoxpath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
		
	}

}
