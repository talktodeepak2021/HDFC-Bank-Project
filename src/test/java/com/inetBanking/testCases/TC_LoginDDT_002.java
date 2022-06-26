package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.Utilities.ExcelUtil;
import com.inetBanking.pageObject.loginPage;

public class TC_LoginDDT_002 extends BaseClass	 {
	
	@Test(dataProvider="loginpage")
	public void loginDDT(String usr,String pwd)
	{
		
		loginPage lp = new loginPage(driver);
		lp.setusername(usr);		
		logger.info("enter username  ");
		
		lp.setpassword(pwd);		
		logger.info("enter password");
		
		lp.clickLogin();
		logger.info("login");
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			
			logger.warn("login passed");
			lp.clickLogout();
			
			driver.switchTo().alert().accept();
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
	
	
	@DataProvider(name="loginpage")
	String[][] getdata() throws IOException
	{
		String Path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginDetails.xlsx";
		
		int rownum=ExcelUtil.getrowCount(Path, "Sheet1");
		int cellnum= ExcelUtil.getcolCOunt(Path, "Sheet1",1);
		
		String logindata[][]=new String[rownum][cellnum];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<cellnum;j++)
			{
				logindata[i-1][j]=ExcelUtil.getcellvalue(Path,"Sheet1",i,j);
			}
		}
		return logindata;
	}
	

}
