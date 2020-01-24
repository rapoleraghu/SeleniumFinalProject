package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddContactAndMakePaymentPOM;
import com.training.pom.LoginAdminPOM;
import com.training.pom.LoginUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_052 {

	private WebDriver driver;
	private String baseUrl;
	private LoginUserPOM loginuserPOM;
	private LoginAdminPOM loginadminPOM;
	private AddContactAndMakePaymentPOM makepaymentPOM;
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
		loginuserPOM  = new LoginUserPOM(driver);
		loginadminPOM =new LoginAdminPOM(driver);
		makepaymentPOM =new AddContactAndMakePaymentPOM(driver);
	
		baseUrl = properties.getProperty("baseURL");
		new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000); 
		//driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		
		loginadminPOM.sendUserName("papa");
		loginuserPOM.sendPassword();
		//loginuserPOM.clickLoginBtn();
		loginadminPOM.clickLoginBtn();
		
		makepaymentPOM.ClickOnPersonal();
		makepaymentPOM.ClickOnContact();
		Thread.sleep(2000);
		makepaymentPOM.EnterMemberLogin("mamu");
		Thread.sleep(2000);
		makepaymentPOM.ClickOnSubmitButton1();
		Thread.sleep(2000);
		makepaymentPOM.AlertOK();
		makepaymentPOM.ClickOnContactName();
		Thread.sleep(5000);
		makepaymentPOM.MakePayment();
		Thread.sleep(2000);
		makepaymentPOM.EnterAmount("50000");
		Thread.sleep(2000);
		makepaymentPOM.EnterDescription("made payment");
		Thread.sleep(2000);
		makepaymentPOM.ClickOnSubmitButton2();
		Thread.sleep(2000);
		makepaymentPOM.AlertOK();
		Thread.sleep(2000);
		makepaymentPOM.ClickOnSumbitButton3();
		Thread.sleep(2000);
		
		String result=driver.findElement(By.xpath("//body[@class='main']//tr//tr[1]//td[1]")).getText();
		//String actual=result.trim();
		StringTokenizer st=new StringTokenizer(result);
		String name="";
		while(st.hasMoreTokens())
		{
			name=name+st.nextToken();
		}
		String expected="Thepaymenthasbeenperformed";
		Assert.assertEquals(name, expected);
		
		Thread.sleep(2000);
		makepaymentPOM.ClickLogout();
	}
	
}
