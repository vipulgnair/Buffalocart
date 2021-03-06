package com.project.testscripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.core.Base;
import com.project.pages.HomePage;
import com.project.pages.LoginPage;
import com.project.pages.LogoutPage;
import com.project.pages.UserManagementPage;
import com.project.pages.UsersPage;
import com.project.utiities.PageUtility;

public class UsersTest extends Base {
	
	LoginPage login;
	HomePage home;
	LogoutPage logout;
	UserManagementPage userManagement;
	UsersPage users;
	
	@Test
	public void verifyusersTitle() throws InterruptedException, IOException
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
	userManagement.clickonUsersSubmenu("Users");
	String actualusersTitle=driver.getTitle();
	String expectedusersTitle="Users - Reobeen LLC";
	Assert.assertEquals(actualusersTitle, expectedusersTitle,"Title Mismatch");
	}
	@Test
	public void AddList() throws InterruptedException, IOException
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
		userManagement.clickonUsersSubmenu("Users");
	users= new UsersPage(driver);
	users.addUser();
	users.enterSurname("Mr");
	users.enterFirstName("stud");
	users.enterLastName("123");
	users.enterEmail("stud123@gmail.com");
    users.selectRole("staff");
	users.enterpassword("password1");
	users.enterconfirmPassword("password1");
	users.enterSalesCommission("15");
	users.clickSave();
	}
	@Test
	public void verifyTableRow() throws InterruptedException, IOException
	{
		login=new LoginPage(driver);
		PageUtility util=new PageUtility();
		String username = util.readdata(1, 0);
		login.enterUsername(username);
		String password=util.readdata(1, 1);
		login.enterPassword(password);
		home=login.clickonLoginButton();
		home.clickonApplicationTour();;
		userManagement=home.clickonusermanagement();
		userManagement.clickonUsersSubmenu("Users");
		//UsersPage users= new UsersPage(driver);
	List<String> actualTableList=users.verifyTable();
	List<String> expectedTableList=new ArrayList<String>();
	expectedTableList.add("028");
	expectedTableList.add("Mr stud 123");
	expectedTableList.add("Admin");
	expectedTableList.add("stud123@gmail.com");
	Assert.assertEquals(actualTableList, expectedTableList,"Mismatch List!!!");

	}
	
	@Test
	public void verifyViewUserPageTitle() throws InterruptedException, IOException
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
		userManagement.clickonUsersSubmenu("Users");
		users= new UsersPage(driver);
		users.clickUserview();
		String actualViewUserTitle=driver.getTitle();
		String expectedViewUserTitle="View User - Reobeen LLC";
		Assert.assertEquals(actualViewUserTitle, expectedViewUserTitle, "Userview page title mismatch");
		
		
	}

	

}
