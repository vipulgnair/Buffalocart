package com.project.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.core.Base;
import com.project.pages.HomePage;
import com.project.pages.LoginPage;
import com.project.pages.LogoutPage;

public class LogoutTest extends Base{
	
	LoginPage login;
	HomePage home;
	LogoutPage logout;
	
	@Test
	public void verifyprofile() {
	LoginPage login = new LoginPage(driver);
	LogoutPage logout = new LogoutPage(driver);
	login.enterUsername("admin");
	login.enterPassword("123456");
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
	public void verifySignout() {
		LoginPage login = new LoginPage(driver);
		LogoutPage logout = new LogoutPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
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
