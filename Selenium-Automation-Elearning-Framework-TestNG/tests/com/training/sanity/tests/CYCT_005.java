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
import com.training.pom.ChangeAddressPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYCT_005 {

	private WebDriver driver;
	private String baseUrl;
	private ChangeAddressPOM changeaddressPOM;
	private LoginAdminPOM adminloginPOM;
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
		changeaddressPOM  = new ChangeAddressPOM(driver); 
		adminloginPOM=new LoginAdminPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000); 
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		adminloginPOM.sendUserName("mami");
		changeaddressPOM.sendPassword("password");
		adminloginPOM.clickLoginBtn(); 
		changeaddressPOM.ClickProfile();
		changeaddressPOM.ClickChange();
		changeaddressPOM.ClickAddress("Hyderabad");
		changeaddressPOM.ClickSubmitBtn();
		Thread.sleep(3000);
		
		
		String actualtitle=driver.switchTo().alert().getText();
		String expectedtitle="Profile modified";
		Assert.assertEquals(actualtitle,expectedtitle);
		
		changeaddressPOM.AlertOK();
		screenShot.captureScreenShot("First");
	}
}
