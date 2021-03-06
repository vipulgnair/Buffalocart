package com.project.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.project.utiities.PageUtility;

public class RolesPage extends PageUtility {

	WebDriver driver;

	public RolesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	WebElement addRoleButton;
	@FindBy(id = "name")
	WebElement roleName;
	@FindBys(@FindBy(xpath = "//div[@class='row check_group']//ins[@class='iCheck-helper']"))
	List<WebElement> permissioncheckBox;
	@FindBy(xpath = "//button[@class='btn btn-primary pull-right']")
	WebElement saveButton;

	@FindBy(xpath = "//table[@id='roles_table']//tr//td")
	WebElement roles;

	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement search;

	@FindBy(xpath = "//td[@class='sorting_1']")
	WebElement searchElement;

	public void addUser() {
		clickOnElement(addRoleButton);
	}

	public void enterRoleName(String rname) {
		enterText(roleName, rname);
	}

	public void selectPermissions(String pcheckboxes) {
		for (int i = 0; i < permissioncheckBox.size(); i++) {
			if (permissioncheckBox.get(i).getText().equals(pcheckboxes)) {
				clickOnElement(permissioncheckBox.get(i));
			}
		}
	}

	public void clickOnSaveButton() {
		clickOnElement(saveButton);
	}

	public void searchfunction(String sear) {
		sleep(3000);
		enterText(search, sear);
	}

	public String isSearchElementPresent() {
		sleep(3000);
		return searchElement.getText();
	}

}
