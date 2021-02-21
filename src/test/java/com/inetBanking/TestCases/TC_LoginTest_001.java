package com.inetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
public class TC_LoginTest_001 extends BaseClass
{
	
  @Test
  public void loginTest() throws IOException
  {
	  driver.get(Baseurl);
	  
	  logger.info("URL is opened");
	  LoginPage lp=new LoginPage(driver);
	  lp.setUserName(userName);
	  logger.info("User name is entered");
	  lp.setPassword(password);
	  logger.info("password is entered");
	  
	  lp.clickSubmit();
	  
	  if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	  {
		  Assert.assertTrue(true);
		  logger.info("login test is passed");
	  }
	  else
	  {
		  captureScreenshot(driver,"loginTest");
		  Assert.assertTrue(false);
		  logger.info("login test is failed");
	  }
	  
  }
}
