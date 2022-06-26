package com.inetBanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.AddCustomer;
import com.inetBanking.pageObject.loginPage;

public class TC_AddCustomer_003 extends BaseClass {
	
	@Test
	public void addCustomer() throws InterruptedException
	{
		loginPage lp = new loginPage(driver);
		
		lp.setusername(username);		
	//	logger.info("enter username  ");
		lp.setpassword(password);
	//	logger.info(" enter password");
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		AddCustomer Addcust=new AddCustomer(driver);
		Addcust.clicAddNewCustomer();
		Addcust.Enterusername("deepak");
		Addcust.selectgender("male");
		Addcust.EnterCdob("12", "03", "1986");
		Thread.sleep(3000);
		Addcust.EnterCAddress("india");
		
		Addcust.EntercCity("delhi");
		Addcust.Entercstate("new delhi");
		Addcust.Entercpincode("110092");
		
		Addcust.Enterctelephn("220526788");
		
		String stremail=randomstring() +"@gmail.com";
		Addcust.Entercemail(stremail);
		Addcust.clicksubmit();
					
		Thread.sleep(3000);
		
	}
	public String randomstring() 
	{
		
	String randomstr=	RandomStringUtils.randomAlphabetic(5);
	return (randomstr);
		
	}

}
