package com.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.project.utiities.PageUtility;



public class HomePage extends PageUtility {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='logo-lg']")
	WebElement home;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-sm']")
	WebElement endTour;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement usernameDropdown;
	
	
	@FindBy(xpath="//li[@class='active']")
	WebElement activeHome;
	
	@FindBy(xpath="//ul[@class='sidebar-menu']//a//span[@class='title']")
	WebElement userManagement;
	
	
	
	
	public String getPageName()
	{
	
		String result = getElementText(home);
		return result;
	}
	
	public void clickonApplicationTour()
	{
		clickOnElement(endTour);
		
	}
	
	public LogoutPage clickonUseracoount()
	{
		clickOnElement(usernameDropdown);
		return new LogoutPage(driver);
	}
	
	public UserManagementPage clickonusermanagement() throws InterruptedException {
		clickOnElement(userManagement);
		Thread.sleep(3000);
		return new UserManagementPage(driver);
		
	}
	
	public boolean getHomeMenuStatus()
	{
		waitForElementTobeVisible(driver, activeHome, 15);
		return getElementDisplayedStatus(activeHome);
		
	}
	
	

	

}
