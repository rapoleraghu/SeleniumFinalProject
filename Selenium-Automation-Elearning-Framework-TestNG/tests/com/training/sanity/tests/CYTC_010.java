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

import com.training.pom.ChangeAdminPasswordPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_010
{
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM pm;
	private ChangeAdminPasswordPOM ch;
	private static Properties properties;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
	}
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		pm=new LoginPOM(driver);
		ch=new ChangeAdminPasswordPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		driver.get("http://localhost:8585/");
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException 
	{
	    pm.sendUserName("admin");
		pm.sendPassword("password");
		pm.clickLoginBtn();
		ch.personal();
		ch.changepasswordlink();
		ch.oldpassword("1234");
		ch.newpassword("1234");
		ch.confirmpassword("1234");
		ch.submitbutton();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		String expect="Application status";
		String actual=driver.findElement(By.xpath("//td[contains(text(),'Application status')]")).getText();
		Assert.assertEquals(expect, actual);
	}
}