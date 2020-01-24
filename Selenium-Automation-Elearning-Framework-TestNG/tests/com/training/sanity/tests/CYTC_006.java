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
import com.training.pom.ChangepasswordPOM;

import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_006
{
	private WebDriver driver;
	private String baseUrl;
	private ChangepasswordPOM ch;
	private LoginPOM pm;
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
		Thread.sleep(3000);
		ch = new ChangepasswordPOM(driver); 
		pm=new LoginPOM(driver);
		
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();

}
	@Test
	public void changePass() throws InterruptedException
	{
		pm.sendUserName("divya");
		pm.sendPassword("password");                                                                                                                                                                   
		pm.clickLoginBtn();
		Thread.sleep(2000);
          ch.personallink();
          Thread.sleep(2000);
          ch.changelink();
          Thread.sleep(2000);
          ch.oldpassword("divya");
          Thread.sleep(2000);
          ch.newpassword("1234");
          Thread.sleep(2000);
          ch.newconfirmpassword("1234");
          ch.passsubmit();
          driver.switchTo().alert().accept();
         String expct="News (message board)";
       String actual = driver.findElement(By.xpath("//td[contains(text(),'News (message board)')]")).getText();
       Assert.assertEquals(expct, actual);
       driver.close();
       
	}
	}
	
