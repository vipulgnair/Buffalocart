package com.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.utiities.PageUtility;

public class ResetPasswordPage extends PageUtility{
	WebDriver driver;
	public ResetPasswordPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='panel-heading']")
	WebElement resetPage;
	@FindBy(id="email")
	WebElement email;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement sendPassword;
	@FindBy(xpath="//span[@class='help-block']/strong")//xpath need attention!!!
	WebElement successMessage;
	
	public boolean isResetPageLoaded()
	{
		waitForElementTobeVisible(driver, resetPage, 15);
		return getElementDisplayedStatus(resetPage);
	}
	
	public void enterEmail(String email1) {
		enterText(email,email1);
	}
		
	
	public String getsuccessMessage()
		{
		String result = getElementText(successMessage);
		return result;
			
		}
		
	
	
	public void clickOnResetButton() {
		clickOnElement(sendPassword);
	}
	
	
	

}
