package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.Utilities.ReadConfig;

public class BaseClass {
	ReadConfig rc= new ReadConfig();
	
	public String baseURL=rc.getApplicationURL();
	public String username=rc.getusername();
	public String password=rc.getpassword();
	public WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
//system.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		
	
	
	
		logger = Logger.getLogger("HDFCBANK") ;
		PropertyConfigurator.configure("Log4j.properties");
		
		
		if(br.equals("chrome"))
				{
		System.setProperty("webdriver.chrome.driver", rc.getchrome());
		driver=new ChromeDriver();
				}
		else if(br.equals("edge"))
				{
			System.setProperty("webdriver.edge.driver", rc.getedgepath());
			driver=new EdgeDriver();
				}
		driver.get(baseURL);
		logger.info("open URL");
			
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public void capturescreenshot(WebDriver driver,String Testname) throws IOException
	{
		//step1 convert webdriver object into Takescreenshot interfcae
		TakesScreenshot	screenshot =((TakesScreenshot)driver);
		// step2 call getscreenshotas method to create image file
		
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"//Screenshots//"+Testname+".png");
		FileUtils.copyFile(src, dest);
	}

}
