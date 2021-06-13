package com.project.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.core.Base;
import com.project.pages.HomePage;
import com.project.pages.LoginPage;
import com.project.pages.LogoutPage;
import com.project.pages.UserManagementPage;
import com.project.utiities.PageUtility;

public class HomeTest extends Base{
	HomePage home;
	LoginPage login;
	LogoutPage logout;
	UserManagementPage userManagement;
	
	@Test
	public void verifyHomePageTitle() throws IOException
	{
		login=new LoginPage(driver);
		PageUtility util=new PageUtility();
		String username = util.readdata(1, 0);
		login.enterUsername(username);
		String password=util.readdata(1, 1);
		login.enterPassword(password);
		login.clickonRemember();
		home=login.clickonLoginButton();
		home.clickonApplicationTour();
		String actualHomePageTitle=driver.getTitle();
		String expectedHomePageTilte="Home - Reobeen LLC";
		Assert.assertEquals(actualHomePageTitle, expectedHomePageTilte,"Title Mismatch!!");
		
	}
	@Test(enabled=true)
	public void verifyHomepageloaded() throws InterruptedException, IOException {
		login = new LoginPage(driver);
		//LogoutPage logout = new LogoutPage(driver);
		PageUtility util=new PageUtility();
		String username = util.readdata(1, 0);
		login.enterUsername(username);
		String password=util.readdata(1, 1);
		login.enterPassword(password);
		login.clickonRemember();
		home=login.clickonLoginButton();
		home.clickonApplicationTour();
		//home.clickonusermanagement();
		boolean result = home.getHomeMenuStatus();
		Assert.assertTrue(result,"Home Page not expanded");
		
		
		
	}

}
