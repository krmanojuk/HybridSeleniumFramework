package com.personalgroupskills.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.personalgroupskills.utility.BrowserFactory;
import com.personalgroupskills.utility.ConfigDataProvider;
import com.personalgroupskills.utility.ExcelDataProvider;
import com.personalgroupskills.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log("Setting up reports and going to initialise now", true);
		excel  = new ExcelDataProvider(); 
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/StudentPortal_"+Helper.getCurrentDateTime()+".html"));
		report =new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting up reports completed and Test can be Started", true);	
	}
	
	@BeforeClass
	public void setup()
	{
		Reporter.log("Going to launch Browser", true);
		driver= BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingurl());
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException 
	{
		Reporter.log("Test is going to end", true);
		if (result.getStatus() == ITestResult.FAILURE) {
			
			logger.fail("Test Failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
//		else if (result.getStatus() == ITestResult.SUCCESS) {
//			logger.fail("Test Passed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
//		}
//		else if (result.getStatus() == ITestResult.SKIP) {
//			logger.skip("Test Skipped ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
//		}
		report.flush();
		
		Reporter.log("Test Completed *** Report Generated Successfully *** ", true);
	}
	
} 
