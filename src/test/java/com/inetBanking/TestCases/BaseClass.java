package com.inetBanking.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;


public class BaseClass 
{
	ReadConfig rid=new ReadConfig();
	
	public String Baseurl=rid.getApplicationUrl();
	public String userName=rid.getUserName();
	public String password=rid.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters ("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties"); 
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",rid.getChrompath());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",rid.getfirefoxpath());
			driver=new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",rid.getiepath());
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(Baseurl);
		driver.manage().window().maximize();
		
	
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public void captureScreenshot(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+ tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot are taken");
		
	}
	public String randomString()
	{
		String generetedstring=RandomStringUtils.randomAlphabetic(8);
		return (generetedstring);
	}
	
	public static String randomNum()
	{
		String generetedString1=RandomStringUtils.randomNumeric(4);
		return (generetedString1) ;
	}

}
