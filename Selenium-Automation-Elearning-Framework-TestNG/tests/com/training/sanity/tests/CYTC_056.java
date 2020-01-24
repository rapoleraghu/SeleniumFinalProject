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

import com.training.pom.AdPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;



public class CYTC_056 {
	
	private WebDriver driver;
	private String baseUrl;
	private AdPOM adPOM;
	private static Properties properties;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adPOM  = new AdPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000); 
		driver.quit();
	}
	@Test
	public void validLoginTest() throws Throwable {
		adPOM.sendUserName("admin");
		adPOM.sendPassword("password");
		adPOM.clickLoginBtn(); 
		Thread.sleep(3000);
		adPOM.memname("pandu");
		Thread.sleep(3000);

		adPOM.submit();
		Thread.sleep(3000);

		adPOM.newButton();
		Thread.sleep(3000);

		adPOM.title("new Offer");
		Thread.sleep(3000);

		adPOM.category();
		Thread.sleep(3000);
		

		adPOM.price("25");
		Thread.sleep(3000);

		adPOM.check();
		Thread.sleep(3000);

		adPOM.Desc("my new offer");
		Thread.sleep(3000);

		adPOM.save();
		Thread.sleep(3000);

		adPOM.alertOk();
		Thread.sleep(3000);

		adPOM.logout();
		adPOM.alertaccept();
		adPOM.memlogin("pandu");
		adPOM.mempwd("password");
		adPOM.submitBtn();
		adPOM.personal();
		adPOM.ad();
		
		String expected="My advertisements";
		String actual=driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).getText();
		Assert.assertEquals(actual, expected);
}
	}



