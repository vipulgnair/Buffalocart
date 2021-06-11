package com.project.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.core.Base;
import com.project.pages.HomePage;
import com.project.pages.LoginPage;
import com.project.pages.RolesPage;
import com.project.pages.SalesCommissionAgentPage;
import com.project.pages.UserManagementPage;

public class SalesCommissionAgentTest extends Base {
	
	LoginPage login;
	HomePage home;
	UserManagementPage userManagement;
	SalesCommissionAgentPage salesCommAgentPage;
	
	@Test
	public void verifySalesCommissionAgentTitle() throws InterruptedException
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		login.clickonRemember();
		home=login.clickonLoginButton();
		home.clickonApplicationTour();
		userManagement=home.clickonusermanagement();
		userManagement.clickonUsersSubmenu("Sales Commission Agents");
		String actualusersTitle=driver.getTitle();
		String expectedusersTitle="Sales Commission Agents - Demo Company";
		Assert.assertEquals(actualusersTitle, expectedusersTitle,"Title Mismatch");
		}
	
	@Test
	public void addAgent() throws InterruptedException
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		login.clickonRemember();
		home=login.clickonLoginButton();
		home.clickonApplicationTour();
		userManagement=home.clickonusermanagement();
		Thread.sleep(3000);
		userManagement.clickonUsersSubmenu("Sales Commission Agents");
		salesCommAgentPage=new SalesCommissionAgentPage(driver);
		salesCommAgentPage.addAgent();
		Thread.sleep(3000);
		salesCommAgentPage.enterSurname("Mr");
		salesCommAgentPage.enterFirstName("agent");
		salesCommAgentPage.enterLastName("1234");
		salesCommAgentPage.enterEmail("agent1234@gmail.com");
		salesCommAgentPage.enterContact("989767678");
		salesCommAgentPage.enterAddress("1st street, Abc nagar , Trivandrum");
		salesCommAgentPage.enterSalesComission("20");
		salesCommAgentPage.clickSave();
	}
	
	@Test
	public void verifysearch() throws InterruptedException
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		login.clickonRemember();
		home=login.clickonLoginButton();
		home.clickonApplicationTour();
		userManagement=home.clickonusermanagement();
		Thread.sleep(3000);
		userManagement.clickonUsersSubmenu("Sales Commission Agents");
		salesCommAgentPage=new SalesCommissionAgentPage(driver);
		salesCommAgentPage.searchfunction("Mr agent 123");
		String actualresult= salesCommAgentPage.isSearchElementPresent();
		String expectedresult="Mr agent 123";
		Assert.assertEquals(actualresult, expectedresult);
		
	}

	
}


