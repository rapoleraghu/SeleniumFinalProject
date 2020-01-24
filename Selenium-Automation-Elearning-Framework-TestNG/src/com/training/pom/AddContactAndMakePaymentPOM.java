package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddContactAndMakePaymentPOM {

	
	private WebDriver driver;
	
	
	public AddContactAndMakePaymentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[contains(text(),'Personal')]")
	private WebElement clickPersonal;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	private WebElement clickContacts;
	
	@FindBy(xpath="//input[@id='memberUsername']")
	private WebElement memberLogin;
	
	@FindBy(xpath="//input[@class='button']")
	private WebElement submitButton1;
	
	@FindBy(xpath="//*[@class='profileLink' and @memberid='21']")
	private WebElement clickOnContactName;
	
	@FindBy(xpath="//tr[contains(@class,'ClassColorSelected')]//td[1]//a[1]")
	private WebElement clickOnMakePayment;
	
	@FindBy(xpath="//input[@id='amount']")
	private WebElement enterAmount;
	
	@FindBy(xpath="//textarea[@id='description']")
	private WebElement enterDescription;
	
	@FindBy(xpath="//input[@id='submitButton']")
	private WebElement submitButton2;
	
	@FindBy(xpath="//table[@class='defaultTable']//input[@class='button']")
	private WebElement submitButton3;
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement clickLogout;
	
	
	public void ClickLogout()
	{
		this.clickLogout.click();
	}
	
	
	public void ClickOnSumbitButton3()
	{
		this.submitButton3.click();
	}
	
	public void ClickOnSubmitButton2()
	{
		this.submitButton2.click();
	}
	
	public void EnterDescription(String description)
	{
		this.enterDescription.click();
		this.enterDescription.clear();
		this.enterDescription.sendKeys(description);
	}
	public void ClickOnPersonal()
	{
		this.clickPersonal.click();
	}
	
	
	public void ClickOnContact()
	{
		this.clickContacts.click();
	}
	
	
	public void EnterMemberLogin(String membername)
	{
		this.memberLogin.clear();
		this.memberLogin.sendKeys(membername);
	}
	
	
	public void ClickOnSubmitButton1()
	{
		this.submitButton1.click();
	}
	
	public void ClickOnContactName()
	{
		this.clickOnContactName.click();
	//	this.clickOnContactName.click();
	}
	
	
	public void MakePayment()
	{
		this.clickOnMakePayment.click();
	}
	
	
	public void AlertOK()
	{
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		
	}
	
	public void EnterAmount(String amount)
	{
		this.enterAmount.clear();
		this.enterAmount.click();
		this.enterAmount.sendKeys(amount);
	}
	
}
