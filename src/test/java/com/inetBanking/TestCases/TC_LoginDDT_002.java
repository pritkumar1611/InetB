package com.inetBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	
	@Test(dataProvider="LoginData")
     public void loginDDT(String user,String pwd) throws InterruptedException
     {
    	 LoginPage lp=new LoginPage(driver);
    	 lp.setUserName(user);
    	 logger.info("UserName provided");
    	 lp.setPassword(pwd);
    	 logger.info("Password is provided");
    	 lp.clickSubmit();
    	 Thread.sleep(3000);
    	 
    	 if(isAlertPresent()==true)
    	 {
    		 driver.switchTo().alert().accept();//close alert
    		 driver.switchTo().defaultContent();
    		 Assert.assertTrue(false);
    		 logger.warn("login is failed");
    		 
    	 }
    	 else
    	 {
    		 Assert.assertTrue(true);
    		 logger.info("Login is passed");
    		 lp.clickLogout();
    		 Thread.sleep(3000);
    		 driver.switchTo().alert().accept();//close the logout alert
    		 driver.switchTo().defaultContent();
    	 }
    	 
     }
	public boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
		
	}
	
	
	
	@DataProvider(name="LoginData")
	String[][] getdata() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/TestData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int Cocount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][Cocount];
		
		for(int i=1;i<=rownum;i++)
{       
			for(int j=0;j<Cocount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				
			}
	
}
		return logindata;
		
		
		
	}
	
}
