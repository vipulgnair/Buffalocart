package com.project.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.core.Base;
import com.project.pages.HomePage;
import com.project.pages.LoginPage;
import com.project.pages.LogoutPage;
import com.project.pages.RolesPage;
import com.project.pages.UserManagementPage;
import com.project.utiities.PageUtility;

public class RolesTest extends Base{
	
	LoginPage login;
	HomePage home;
	LogoutPage logout;
	UserManagementPage userManagement;
	RolesPage roles;
	
	
	
	@Test
	public void verifyRoleTitle() throws InterruptedException, IOException
	{
		login=new LoginPage(driver);
		PageUtility util=new PageUtility();
		String username = util.readdata(1, 0);
		login.enterUsername(username);
		String password=util.readdata(1, 1);
		login.enterPassword(password);
		home=login.clickonLoginButton();
		home.clickonApplicationTour();
		userManagement=home.clickonusermanagement();
		userManagement.clickonUsersSubmenu("Roles");
		String actualusersTitle=driver.getTitle();
		String expectedusersTitle="Roles - Roebeen LLC";
		Assert.assertEquals(actualusersTitle, expectedusersTitle,"Title Mismatch");
	}
	
	
	@Test
	public void verifyAddRoles() throws InterruptedException, IOException
	{
		login=new LoginPage(driver);
		PageUtility util=new PageUtility();
		String username = util.readdata(1, 0);
		login.enterUsername(username);
		String password=util.readdata(1, 1);
		login.enterPassword(password);
		home=login.clickonLoginButton();
		home.clickonApplicationTour();
		userManagement=home.clickonusermanagement();
		userManagement.clickonUsersSubmenu("Roles");
		RolesPage roles = new RolesPage(driver);
		roles.addUser();
		roles.enterRoleName("student");
		roles.selectPermissions("View user");
		roles.selectPermissions("Add user");
		roles.selectPermissions("Edit user");
		roles.selectPermissions("Delete user");
		roles.clickOnSaveButton();
		
		
		
	}
	
	@Test
	public void verifysearch() throws InterruptedException, IOException
	{
		login=new LoginPage(driver);
		PageUtility util=new PageUtility();
		String username = util.readdata(1, 0);
		login.enterUsername(username);
		String password=util.readdata(1, 1);
		login.enterPassword(password);
		home=login.clickonLoginButton();
		home.clickonApplicationTour();
		userManagement=home.clickonusermanagement();
		userManagement.clickonUsersSubmenu("Roles");
		RolesPage roles = new RolesPage(driver);
		roles.searchfunction("cashier");
		String actualresult= roles.isSearchElementPresent();
		String expectedresult="cashier";
		Assert.assertEquals(actualresult, expectedresult);
		
	}

}
