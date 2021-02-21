package com.inetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustome() throws InterruptedException, IOException
	{
	
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("username is provide");
		lp.setPassword(password);
		logger.info("password is provide");
		lp.clickSubmit();
		
		Thread.sleep(6000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		logger.info("Providing the customer details.......");
		addcust.custName("Pritam");
		addcust.custGender("male");
		addcust.custDob("16", "11", "1993");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		Thread.sleep(3000);
		addcust.custCity("BETTIAH");
		addcust.custState("BIHAR");
		
		addcust.custPin("845438");
		addcust.custTelephone("9540482320");
		String email=randomString()+"@gmail.com";
		addcust.custemail(email);
		addcust.custPassword("abcdef");
		Thread.sleep(3000);
		addcust.custSubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation started......");
		
		Boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Testcases are passed.......");
		}
		else
		{
			logger.info("Testcases are failed........");
			captureScreenshot(driver,"addNewCustome");
			Assert.assertTrue(false);
		}
	}

	
}
