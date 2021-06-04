package com.project.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.core.Base;
import com.project.pages.HomePage;
import com.project.pages.LoginPage;
import com.project.pages.LogoutPage;
import com.project.pages.RolesPage;
import com.project.pages.UserManagementPage;

public class RolesTest extends Base{
	
	LoginPage login;
	HomePage home;
	LogoutPage logout;
	UserManagementPage userManagement;
	RolesPage roles;
	
	
	
	@Test
	public void verifyRoleTitle() throws InterruptedException
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
		home=login.clickonLoginButton();
		home.clickonApplicationTour();
		userManagement=home.clickonusermanagement();
		userManagement.clickonUsersSubmenu("Roles");
		String actualusersTitle=driver.getTitle();
		String expectedusersTitle="Roles - Demo Company";
		Assert.assertEquals(actualusersTitle, expectedusersTitle,"Title Mismatch");
	}
	
	
	@Test
	public void verifyAddRoles() throws InterruptedException
	{
		login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("123456");
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

}
