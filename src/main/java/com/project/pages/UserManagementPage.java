package com.project.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.project.utiities.PageUtility;

public class UserManagementPage extends PageUtility{
	WebDriver driver;
	public UserManagementPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBys(@FindBy(xpath="//li[@class='treeview  active']//ul[@class='treeview-menu menu-open']/li//span"))
	List<WebElement>menu;
	
	@FindBys(@FindBy(xpath="//ul[@class='sidebar-menu']//ul//span[@class='title']"))
	List<WebElement>options;
	
	@FindBy(xpath="//ul[@class='sidebar-menu']//a//span[@class='title']")
	WebElement sidebar;
	
	@FindBy(xpath="//li[contains(@class,'treeview active')]")
	WebElement activeUsermanagement;
	
	
	public List<String> getMenuOptions() throws InterruptedException
	{
		List<String>menuName = new  ArrayList<String>();
				for(int i=0;i<menu.size();i++)
				{
				menuName.add(menu.get(i).getText());
				Thread.sleep(3000);
					
				}
				return menuName;
				
	}
	
	
	
	public UsersPage clickonUsersSubmenu(String menu1) throws InterruptedException
	{
		
		for(int i= 0; i<options.size();i++)
		{
			//System.out.println(options.get(i).getText());
			if(options.get(i).getText().equals(menu1))
			{
			Thread.sleep(3000);
			clickOnElement(options.get(i));
			}
		}
		return new UsersPage(driver);
	}
	
	public boolean getUserManagementStatus()
	{
		waitForElementTobeVisible(driver, activeUsermanagement, 15);
		return getElementDisplayedStatus(activeUsermanagement);
	}
	

}
