package com.project.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.project.core.Base;
import com.project.pages.LoginPage;
import com.project.pages.LogoutPage;
import com.project.utiities.PageUtility;
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
	public void verifyValidLogin() throws IOException
	{
		login = new LoginPage(driver);
		
		PageUtility util=new PageUtility();
		String username = util.readdata(1, 0);
		login.enterUsername(username);
		String password=util.readdata(1, 1);
		login.enterPassword(password);
		login.clickonRemember();
		home=login.clickonLoginButton();
		home.clickonApplicationTour();
		//
		boolean result=home.isHomePageLoaded();
		Assert.assertTrue(result, "Home Page not Loaded");
		//String actualUserID = home.getPageName();
		//String expectedUserID = "Demo Company";
		//Assert.assertEquals(actualUserID, expectedUserID,":User account page not loaded");
		//home.clickonUseraccount();
		//logout.clickonLogoutButton();
	}
	


}
