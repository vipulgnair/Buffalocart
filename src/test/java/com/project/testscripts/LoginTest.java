package com.project.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.project.core.Base;
import com.project.pages.LoginPage;
import com.project.pages.LogoutPage;
import com.project.pages.HomePage;

public class LoginTest extends Base{
	LoginPage login;
	HomePage home;
	LogoutPage logout;
	
	@Test
	public void verifyLoginPageTitle()
	{
		login = new LoginPage(driver);
		String actualPageTitle = login.getLoginPageTitle();
		String expectedPageTitle = "Login - Demo POS";
		Assert.assertEquals(actualPageTitle,expectedPageTitle, "Invalid login page title");
	}
	
	@Test
	public void verifyLoginPageLoadedorNot() {
		LoginPage login = new LoginPage(driver);
		boolean result = login.isLoginPageLoaded();
		Assert.assertTrue(result,"Login Page not loaded");

	}
	
	@Test
	public void verifyValidLogin()
	{
		login = new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		login.clickonRemember();
		home=login.clickonLoginButton();
		home.clickonApplicationTour();
		//
		boolean result=home.isHomePageLoaded();
		Assert.assertTrue(result, "Home Page not Loaded");
		//String actualUserID = home.getPageName();
		//String expectedUserID = "Demo Company";
		//Assert.assertEquals(actualUserID, expectedUserID,":User account page not loaded");
		home.clickonUseraccount();
		logout.clickonLogoutButton();
	}
	


}
