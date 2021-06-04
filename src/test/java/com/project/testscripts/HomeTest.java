package com.project.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.core.Base;
import com.project.pages.HomePage;
import com.project.pages.LoginPage;
import com.project.pages.LogoutPage;
import com.project.pages.UserManagementPage;

public class HomeTest extends Base{
	HomePage home;
	LoginPage login;
	LogoutPage logout;
	UserManagementPage userManagement;
	
	//@Test
	public void verifyHomepageloaded() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		LogoutPage logout = new LogoutPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		login.clickonRemember();
		home=login.clickonLoginButton();
		home.clickonApplicationTour();
		home.clickonusermanagement();
		boolean result = home.getHomeMenuStatus();
		Assert.assertTrue(result,"Home Page not expanded");
		
		
		
	}

}
