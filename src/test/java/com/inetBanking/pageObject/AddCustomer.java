package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {
	WebDriver ldriver;

	public AddCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='New Customer']")//a[normalize-space()='New Customer']
	WebElement linkaddcustomer;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement txtcustomername;
	
	
	@FindBy(xpath="//tbody/tr[5]/td[2]/input[1]")
	WebElement radioselect;
	
	@FindBy(xpath="//input[@id='dob']")
	WebElement selectdob	;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement txtaddrss	;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement txtcity	;
	
	
	@FindBy(xpath="//input[@name='state']")
	WebElement txtstate	;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement txtpincode	;
	
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement txtphone	;
	
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement txtemail	;
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement submitbttn	;
	
	public void clicAddNewCustomer()
	{
		linkaddcustomer.click();
	}
	
	public void Enterusername(String name)
	{
		txtcustomername.sendKeys(name);
	}
	
	
	public void selectgender(String gender)
	{
		radioselect.click();
	}
	
	public void EnterCdob(String day,String mm,String yyyy)
	{
		selectdob.sendKeys(day);
		selectdob.sendKeys(mm);
		selectdob.sendKeys(yyyy);
		
	}
	
	public void EnterCAddress(String addr)
	{
		txtaddrss.sendKeys(addr);
	}
	
	public void EntercCity(String city)
	{
		txtcity	.sendKeys(city);
	}
	
	public void Entercstate(String state)
	{
		txtstate.sendKeys(state);
	}
	
	public void Entercpincode(String pincde)
	{
		txtpincode.sendKeys(String.valueOf(pincde));
	}
	
	public void Enterctelephn(String telephne)
	{
		txtphone.sendKeys(telephne);
	}
	
	public void Entercemail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void clicksubmit()
	{
		submitbttn.click();
	}
}
