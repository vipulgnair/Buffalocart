package com.project.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.utiities.PageUtility;

public class SalesCommissionAgentPage extends PageUtility {
	WebDriver driver;

	public SalesCommissionAgentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='box-tools']")
	WebElement addButton;

	@FindBy(id = "surname")
	WebElement surname;

	@FindBy(id = "first_name")
	WebElement fname;

	@FindBy(id = "last_name")
	WebElement lname;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "contact_no")
	WebElement contactno;

	@FindBy(id = "address")
	WebElement address;

	@FindBy(id = "cmmsn_percent")
	WebElement commission;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement saveButton;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement search;
	
	@FindBy(xpath="//table[@id='sales_commission_agent_table']//tr//td")
	WebElement tablelist;

	public void addAgent() {
		clickOnElement(addButton);
	}

	public void enterSurname(String sname) {
		enterText(surname, sname);
	}

	public void enterFirstName(String firstname) {
		enterText(fname, firstname);
	}

	public void enterLastName(String lastname) {

		enterText(lname, lastname);
	}

	public void enterEmail(String e) {
		enterText(email, e);
	}

	public void enterContact(String contact) {
		enterText(contactno, contact);
	}

	public void enterAddress(String addr) {
		enterText(address, addr);
	}

	public void enterSalesComission(String salesCommission) {
		enterText(commission, salesCommission);
	}

	public void clickSave() {
		clickOnElement(saveButton);
	}
	
	
	public void searchfunction(String sear) {
		sleep(3000);
		enterText(search, sear);
	}
	
	public String isSearchElementPresent() {
		sleep(3000);
		return tablelist.getText();
	}
}
