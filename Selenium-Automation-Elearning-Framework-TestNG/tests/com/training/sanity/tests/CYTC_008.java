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









import com.training.pom.LogoutPOM;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
//import com.training.pom.ChangepasswordPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_008
{
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM pm;
	private LogoutPOM lg;
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
		pm=new LoginPOM(driver);
		lg=new LogoutPOM(driver);
		
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();

}
	@Test
	public void logout() throws InterruptedException
	{
		pm.sendUserName("admin");
		Thread.sleep(2000);
		pm.sendPassword("password");
		Thread.sleep(2000);
		pm.clickLoginBtn();
		lg.clicklogout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		String expect="Login";
		String actual = driver.findElement(By.xpath("//div[contains(text(),'Login')]")).getText();
		Assert.assertEquals(expect, actual);
	}
}
