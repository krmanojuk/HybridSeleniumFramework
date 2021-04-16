package com.personalgroupskills.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.personalgroupskills.pages.BaseClass;
import com.personalgroupskills.pages.LoginPage;
import com.personalgroupskills.utility.ExcelDataProvider;
import com.personalgroupskills.utility.Helper;

public class LoginTest extends BaseClass{
	
	@Test
	public void loginApp()
	{	
		logger=report.createTest("login to Internal app");
		LoginPage LoginPage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Going to launch Internal app");
		LoginPage.loginToInternalApp(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		Helper.captureScreenshot(driver);
		logger.pass("Login Success");
	}
	

	
	
}
