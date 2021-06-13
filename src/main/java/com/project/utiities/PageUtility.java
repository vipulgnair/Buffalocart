package com.project.utiities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PageUtility {
	public static int IMPLICIT_TIME=20;
	public static int EXPLICIT_TIME=20;
	public static int PAGELOAD_WAIT=20;

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
		
		public void waitForAnElement(WebDriver driver, String locator) {
			WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_TIME);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			
		}
		
		public void waitForElement(WebDriver driver, String locator, String path) {
			WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_TIME);
			switch(locator) {
			case "xpath":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
				break;
			case "id":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(path)));
				break;
			case "name":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(path)));
				break;
			case "class":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(path)));
				break;
			default:
				String text="Invalid locator found";
			}
			
			
		}
		
		
			
			XSSFSheet sh;
			
			public String readdata(int i, int j) throws IOException
			{
				FileInputStream f= new FileInputStream("C:\\Users\\TEMP.DESKTOP-75SCK3T.003\\eclipse-workspace\\BuffalocartProject\\src\\main\\resources\\Sel_excel.xlsx");
				XSSFWorkbook w= new XSSFWorkbook(f);
				sh = w.getSheet("Sheet1");
				Row r = sh.getRow(i);
				Cell c = r.getCell(j);
				int celltype = c.getCellType();
				switch (celltype) {
				case Cell.CELL_TYPE_NUMERIC:{
					int d = (int) c.getNumericCellValue();
					return String.valueOf(d);
				}
				case Cell.CELL_TYPE_STRING:{
					return c.getStringCellValue();
				}
				}
				return null;
			}
		


}
