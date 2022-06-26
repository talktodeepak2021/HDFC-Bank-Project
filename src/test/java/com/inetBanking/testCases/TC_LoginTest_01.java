package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.loginPage;

public class TC_LoginTest_01 extends BaseClass {
	
	
@Test
public void loginpage() throws IOException
{
	
	
	loginPage lp = new loginPage(driver);
	lp.setusername(username);
	
	logger.info("enter username  ");
	lp.setpassword(password);
	logger.info(" enter password");
	lp.clickLogin();
	
	logger.info("click on submit button");
	 WebElement p=driver.findElement(By.xpath("//h2[normalize-space()='Gtpl Bank']"));
     //getText() to obtain text
     String s= p.getText();
     System.out.println("Text content is : " + s);
     
     Assert.assertEquals(s, "Gtpl Bank");
     System.out.println("Bank name displayed");
     
     if ( driver.getPageSource().contains("Gtpl Bannnk")){
         System.out.println("Text: " + s + " is present. ");
         Assert.assertTrue(true);
         logger.info("login passed");
      } else {
    	  
    	  capturescreenshot(driver,"loginpage");
          Assert.assertTrue(false);
         System.out.println("Text: " + s + " is not present. ");
         
         logger.info("login failed");
      }
}
}
