package com.project.utiities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtility {

		public WebElement waitForElementTobeVisible(WebDriver driver, WebElement elementToBeLoaded, int time) {
			WebDriverWait wait = new WebDriverWait(driver, time);
			WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
			return element;
		}

		public boolean getElementDisplayedStatus(WebElement element) {
			return element.isDisplayed();
		}

		public void enterText(WebElement element, String text) {

			element.sendKeys(text);
		}

		public void clickOnElement(WebElement element) {
			element.click();
		}
		
		public void sleep(long timeout)
		{
			try {
				Thread.sleep(timeout);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		public String getElementText(WebElement element)
		{
			return element.getText();
		}


}
