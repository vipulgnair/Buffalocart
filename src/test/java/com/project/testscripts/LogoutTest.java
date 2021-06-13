package com.project.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.core.Base;
import com.project.pages.HomePage;
import com.project.pages.LoginPage;
import com.project.pages.LogoutPage;
import com.project.utiities.PageUtility;

public class LogoutTest extends Base{
	
	LoginPage login;
	HomePage home;
	LogoutPage logout;
	
	@Test
	public void verifyprofile() throws IOException {
	LoginPage login = new LoginPage(driver);
	LogoutPage logout = new LogoutPage(driver);
	PageUtility util=new PageUtility();
	String username = util.readdata(1, 0);
	login.enterUsername(username);
	String password=util.readdata(1, 1);
	login.enterPassword(password);
	login.clickonRemember();
	HomePage home = new HomePage(driver);
	home=login.clickonLoginButton();
	home.clickonApplicationTour();
	home.clickonUseraccount();
	String actualprofileText= logout.getProfileText();
	String expectedText="Profile";
	Assert.assertEquals(actualprofileText, expectedText,"Profile button is missing");
	
	}
	
	@Test
	public void verifySignout() throws IOException {
		LoginPage login = new LoginPage(driver);
		LogoutPage logout = new LogoutPage(driver);
		PageUtility util=new PageUtility();
		String username = util.readdata(1, 0);
		login.enterUsername(username);
		String password=util.readdata(1, 1);
		login.enterPassword(password);
		login.clickonRemember();
		home=login.clickonLoginButton();
		home.clickonApplicationTour();
		home.clickonUseraccount();
		String actualSignoutText=logout.getSignoutText();
		String expectedSignoutText="Sign Out";
		Assert.assertEquals(actualSignoutText, expectedSignoutText, "Signout Button is missing");
		logout.clickonLogoutButton();
		System.out.println("Logout successful");
		 
	}
	

}
