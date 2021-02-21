package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using="/html[1]/body[1]/div[3]/div[1]/ul[1]/li[2]/a[1]")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.NAME, using= "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.NAME, using= "rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how = How.ID_OR_NAME, using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how = How.NAME, using= "addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how = How.NAME, using= "city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how = How.NAME, using= "state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(how = How.NAME, using= "pinno")
	@CacheLookup
	WebElement txtpinno;
	
	@FindBy(how = How.NAME, using= "telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(how = How.NAME, using= "emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(how = How.NAME, using= "password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(how = How.NAME, using= "sub")
	@CacheLookup
	WebElement btnSubmit;
	
	
	
	public void clickAddNewCustomer() 
	{
		lnkAddNewCustomer.click();
	}
	
	public void custName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender(String cgender)
	{
		rdGender.click();
	}

	public void custDob(String dd,String mm,String yy)
	{
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(yy);
	}
	
	public void custaddress(String caddress)
	{
		txtaddress.sendKeys(caddress);
	}
	
	public void custCity(String cCity)
	{
		txtcity.sendKeys(cCity);
	}
	
	public void custState(String cState)
	{
		txtstate.sendKeys(cState);
	}
	
	public void custPin(String cpinno)
	{
		txtpinno.sendKeys(String.valueOf(cpinno));
	}
	
	public void custTelephone(String ctelephone)
	{
		txttelephoneno.sendKeys(ctelephone);
	}
	
	public void custemail(String cemail)
	{
		txtemailid.sendKeys(cemail);
	}
	
	public void custPassword(String cpassword)
	{
		txtpassword.sendKeys(cpassword);
	}
	
	public void custSubmit()
	{
		btnSubmit.click();
	}
	
	
}
