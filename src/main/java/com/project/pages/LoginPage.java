package com.project.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.project.utiities.PageUtility;

public class LoginPage extends PageUtility{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='panel-heading']")
	WebElement loginPage;
	@FindBy(id="username")
	WebElement userName;
	@FindBy(id="password")
	WebElement password;
	@FindBy(xpath="//input[@name='remember']")
	WebElement remember;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement loginButton;
	@FindBy(xpath="//a[@class='btn btn-link']")
	WebElement forgotPassword;
	public String getLoginPageTitle()
	 {
		String title = driver.getTitle();
		return title;
	 }
	
	public boolean isLoginPageLoaded()
	{
		waitForElementTobeVisible(driver, loginPage, 15);
		return getElementDisplayedStatus(loginPage);
	}
	
	
	
	public void enterUsername(String uname) throws IOException
	{
		
		enterText(userName,uname);
		
	}
	public void enterPassword(String pass)
	{
		enterText(password,pass);
		
	}
	
	public void clickonRemember() {
		clickOnElement(remember);
	}
	
	public HomePage clickonLoginButton()
	{
		clickOnElement(loginButton);
		sleep(2000);
		return new HomePage(driver);
		
	}
	
	public ResetPasswordPage clickonForgotPassword() {
		clickOnElement(forgotPassword);
		return new ResetPasswordPage(driver);
		
	}


}
