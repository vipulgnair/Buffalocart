package com.project.testscripts;


import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.core.Base;
import com.project.pages.HomePage;
import com.project.pages.LoginPage;
import com.project.pages.LogoutPage;
import com.project.pages.UserManagementPage;

public class UserManagementTest extends Base {
	LoginPage login;
	HomePage home;
	LogoutPage logout;
	UserManagementPage userManagement;
	
	@Test
	public void verifyusermanagementloaded() throws InterruptedException
	{
		login = new LoginPage(driver);
		//LogoutPage logout = new LogoutPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		login.clickonRemember();
		//home = new HomePage(driver);
		home=login.clickonLoginButton();
		home.clickonApplicationTour();
		userManagement =home.clickonusermanagement();
		Thread.sleep(2000);
		boolean result = userManagement.getUserManagementStatus();
		Assert.assertTrue(result,"Usermanagement Page not expanded");
	}
	
	@Test
	public void VerifyUserManagementTab() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		LogoutPage logout = new LogoutPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		login.clickonRemember();
		HomePage home = new HomePage(driver);
		home=login.clickonLoginButton();
		home.clickonApplicationTour();
		userManagement=home.clickonusermanagement();
		List<String> actualMenu=userManagement.getMenuOptions();
		List<String> expectedMenu = new ArrayList<String>();
		expectedMenu.add("Users");
		expectedMenu.add("Roles");
		expectedMenu.add("Sales Commission Agents");
		Assert.assertEquals(actualMenu, expectedMenu,"Not all menus are listed");	
		
	}
	
	@Test
	public void verifyUsersTabloaded() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		LogoutPage logout = new LogoutPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		login.clickonRemember();
		HomePage home = new HomePage(driver);
		home=login.clickonLoginButton();
		home.clickonApplicationTour();
		userManagement=home.clickonusermanagement();
		userManagement.clickonUsersSubmenu("Users");
		
	}
	

}
