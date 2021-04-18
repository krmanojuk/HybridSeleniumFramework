package com.personalgroupskills.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//div[@class='sv-header-text']/h1")
	WebElement screenIdentifier;
	
	public String validateHomePageTitle() {
		return driver.getTitle();
		
	}
	

	
//	public void loginToInternalApp(String usernameApplicaton, String passwordApplication)
//	{
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//		}	
//		uname.sendKeys(usernameApplicaton);
//		pwd.sendKeys(passwordApplication);
//		loginButton.click();
//	}
}
