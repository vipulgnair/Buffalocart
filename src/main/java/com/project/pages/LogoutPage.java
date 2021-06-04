package com.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.utiities.PageUtility;

public class LogoutPage extends PageUtility{
	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='pull-left']/a")
	WebElement profile;
	@FindBy(xpath="//div[@class='pull-right']/a")
	WebElement logoutButton;
	
	public String getProfileText()
	{
	String result = getElementText(profile);
	return result;
		
	}

	public String getSignoutText()
	{
	String result = getElementText(logoutButton);
	return result;
		
	}

	
	public LoginPage clickonLogoutButton()
	{
		
		clickOnElement(logoutButton);
		return new LoginPage(driver);
	}

}
