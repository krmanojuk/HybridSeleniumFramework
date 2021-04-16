package com.personalgroupskills.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	@FindBy(xpath="//div[@class='sv-form-group']/input[@name='MUA_CODE.DUMMY.MENSYS.1']") WebElement uname;
	
	@FindBy(xpath="//div[@class='sv-form-group']/input[@name='PASSWORD.DUMMY.MENSYS.1']") WebElement pwd;
	
	@FindBy(xpath="//div[@class='sv-form-group']/input[@value='Log in']") WebElement loginButton;
	
	public void loginToInternalApp(String usernameApplicaton, String passwordApplication)
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}	
		uname.sendKeys(usernameApplicaton);
		pwd.sendKeys(passwordApplication);
		loginButton.click();
	}
}
