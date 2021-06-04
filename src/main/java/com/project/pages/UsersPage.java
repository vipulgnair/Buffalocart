package com.project.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.project.utiities.PageUtility;

public class UsersPage extends PageUtility{
	WebDriver driver;
	public UsersPage(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//div[@class='box-tools']//a")
	WebElement addUserButton;
	@FindBy(id="surname")
	WebElement prefix;
	@FindBy(id="first_name")
	WebElement firstname;
	@FindBy(id="last_name")
	WebElement lastname;
	@FindBy(id="email")
	WebElement email;
	@FindBys(
	@FindBy(xpath="//ul[@id='select2-role-results']//li"))
	List<WebElement> role;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="confirm_password")
	WebElement cpassword;
	@FindBy(id="cmmsn_percent")
	WebElement salesComm;
	@FindBy(xpath="//div[@class='icheckbox_square-blue']//ins")
	WebElement contactCheckbox;
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement selectContact;
	@FindBys(
	@FindBy(xpath="//ul[@id='select2-selected_contact_ids-t1-results']//li"))
	List<WebElement> selectContactOptions;
    @FindBy(id="submit_user_button")
	WebElement save;
	@FindBys(
	@FindBy(xpath="//table[@id='users_table']//tbody//td"))
	List<WebElement> table;
	
	
	public void addUser()
	{
	clickOnElement(addUserButton);
	}
	
	public void selectRole(String role1) {
	for(int i=0;i<role.size();i++)
	{
	if(role.get(i).getText().equalsIgnoreCase(role1))
	{

	clickOnElement(role.get(i));
	}
	}
	}
	
	
	public void enterSurname(String sname)
	{
	enterText(prefix,sname);
	}
	
	
	public void enterFirstName(String fname)
	{
	enterText(firstname,fname);
	}
	
	
	public void enterLastName(String lname)
	{

	enterText(lastname,lname);
	}
	
	
	public void enterEmail(String e)
	{
	enterText(email,e);
	}

	public void enterpassword(String pass)
	{
	enterText(password,pass);
	}
	
	public void enterconfirmPassword(String cpass)
	{
	enterText(cpassword,cpass);
	}
	
	public void enterSalesCommission(String sc)
	{
	enterText(salesComm,sc);
	}
	
	public void clickAllowSelectedContactCheckbox()
	{
	clickOnElement(contactCheckbox);
	}
	
	public void clickSelectContact()
	{
	clickOnElement(selectContact);
	}
	
	public void selectContactOptions(String option1) {
	for(int i=0;i<selectContactOptions.size();i++)
	{
	if(selectContactOptions.get(i).getText().equalsIgnoreCase(option1)) {
	clickOnElement(selectContactOptions.get(i));
	}
	}

	}
	public void clickSave()
	{
	clickOnElement(save);
	}
	
	public void compareTable()
	{
	for(int i=0;i<table.size();i++)
	{
	String actualTable=table.get(i).getText();
	}
	}
	public List<String> verifyTable()
	{
	List<String> tablerow=new ArrayList<String>();
	for(int i=0;i<table.size()-1;i++)
	{
	tablerow.add(table.get(i).getText());
	}

	return tablerow;
	}

}
