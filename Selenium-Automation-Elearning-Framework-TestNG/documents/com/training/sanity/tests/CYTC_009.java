package com.training.sanity.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.AdminNamePOM;
import com.training.pom.AdminNamePOM;
import com.training.pom.LoginPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_009
{
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM pm;
	private AdminNamePOM ch;
	private static Properties properties;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
	}
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		pm=new LoginPOM(driver);
		ch=new AdminNamePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		driver.get("http://localhost:8585/");
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		
		pm.sendUserName("admin");
		pm.sendPassword("password");
		pm.clickLoginBtn();
		ch.personallink();
		ch.profilelink();
		ch.changebutton();
		Thread.sleep(2000);
		ch.fullnamechange("administrator");
		ch.submitbutton();
		driver.switchTo().alert().accept();
		String actual=driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).getText();
		String expected="My admin profile";
		Assert.assertEquals(actual, expected);
	}
}
