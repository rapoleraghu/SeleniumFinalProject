package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginAdminPOM;
import com.training.pom.LoginUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYCT_004 {

	
	private WebDriver driver;
	private String baseUrl;
	private LoginUserPOM loginuserPOM;
	private LoginAdminPOM loginadminPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginuserPOM  = new LoginUserPOM(driver);
		loginadminPOM =new LoginAdminPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000); 
		//driver.quit();
	}
	@Test
	public void validLoginTest() {
		
		loginadminPOM.sendUserName("joya");
		loginuserPOM.sendPassword();
		//loginuserPOM.clickLoginBtn();
		loginadminPOM.clickLoginBtn();
		
		String actual=driver.findElement(By.xpath("//div[@class='topBannerText']")).getText();
		String expected="Open Source on-line banking software";
		Assert.assertEquals(actual, expected);
		screenShot.captureScreenShot("First");
	}
}
