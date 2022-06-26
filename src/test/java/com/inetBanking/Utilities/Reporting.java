package com.inetBanking.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Reporting extends TestListenerAdapter 

{
	
	ReadConfig   raedconfig = new ReadConfig();
	ExtentSparkReporter htmlreport;
	ExtentReports report;
	ExtentTest test;

	//initialized reports
	public void confogurereport()
	{
		String timstamp= new SimpleDateFormat("yyyy.mm.dd  hh.mm.ss").format(new Date());
		String reporName="MyStoreTestReport--"+timstamp+".html" ;
		
		htmlreport = new ExtentSparkReporter(System.getProperty("user.dir")  +  "//Reports//"  + reporName );
		report = new ExtentReports();
		report.attachReporter(htmlreport);

		// envomntal details
		report.setSystemInfo("Tester Name", "Deepak");
		report.setSystemInfo("OW", "Wind 10");
		report.setSystemInfo("Browser", raedconfig.getchrome());
		report.setSystemInfo("Envmt ", "SYST QA");

		// configuration look and feel
		htmlreport.config().setDocumentTitle("Extent  Report");
		htmlreport.config().setReportName("First report");
	}

	@Test
	public void onStart(ITestContext Result) {

		confogurereport();

		System.out.println(">>>>On Start method Invoke as  execution start for all test methods<<<<<< ");

	}

	@Test
	public void onFinish(ITestContext context) {
		System.out.println(">>>>On Finish  method Invoke as  execution complete for all test methods<<<<<<");
		
		report.flush();
	}

	@Test// when test case failed thn this method is called
	public void onTestFailure(ITestResult result) {
		System.out.println("Name  of failed test method " + result.getName() );
		
		test=report.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of fail test case is: "+result.getName(), ExtentColor.RED));
		
		String screenshotPath=System.getProperty("user.dir")+"//Screenshots//"+result.getName()+".png";
		File screenshotfile =   new File(screenshotPath);
		if(screenshotfile.exists())
		{
			test.fail("captued screensshot below is "+test.addScreenCaptureFromPath(screenshotPath));
		}
		//test.addScreenCaptureFromPath(null);

	}
	@Test 
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name  of skipped  test method " + result.getName() );

	}

	@Test// when test case start this method called
	public void onTestStart(ITestResult result) {
		System.out.println("Name  of test method  start  " + result.getName() );

	}

	@Test // when test cases passed ths method call
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name  of test success  method    " + result.getName() );
		test=report.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of Pass test case is: "+result.getName(), ExtentColor.GREEN));

	}





	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}


	
}
