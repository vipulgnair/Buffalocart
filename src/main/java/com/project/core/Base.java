package com.project.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {
	public WebDriver driver;
	
	public void testinitialize(String browser) throws Exception {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Java programs\\Selenium files\\driver files\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Java programs\\Selenium files\\driver files\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver ",
					"C:\\Java programs\\Selenium files\\driver files\\Edge\\edgedriver_win64 (1)\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			throw new Exception("Invalid brwoser");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}
	
	@BeforeMethod
	@Parameters({"url","browser"})

	public void setUp(String urlvalue, String browser) throws Exception {
		testinitialize(browser);
		driver.get(urlvalue);
	}

	@AfterMethod

	public void tearDown(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			TakesScreenshot takescreenshot=(TakesScreenshot)driver;
			File screenshot = takescreenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("./Screenshots/"+result.getName()+".png"));
		}
		
		driver.close();
		
	}



}
