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
import com.training.pom.PermissionToUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_003 {

	private WebDriver driver;
	private String baseUrl;
	private PermissionToUserPOM permissiontouserPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private LoginAdminPOM loginadminPOM;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		permissiontouserPOM  = new PermissionToUserPOM(driver); 
		loginadminPOM = new LoginAdminPOM(driver);
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
		loginadminPOM.sendUserName("admin");
		loginadminPOM.sendPassword("password");
		loginadminPOM.clickLoginBtn(); 
		permissiontouserPOM.memberLogin("joya");
		permissiontouserPOM.clickSubmit();
		permissiontouserPOM.clickNewGroup();
		permissiontouserPOM.selectFullMembers();
		permissiontouserPOM.Comment("You are authorized user");
		permissiontouserPOM.ClickSubmitBtn();
		
		
		String actualtitle=driver.switchTo().alert().getText();
		String expectedtitle="The member's group was changed, however, the activation mail could not be sent";
		Assert.assertEquals(actualtitle,expectedtitle);
		permissiontouserPOM.AlertOK();
		Thread.sleep(3000);
		screenShot.captureScreenShot("First");
	}
}
