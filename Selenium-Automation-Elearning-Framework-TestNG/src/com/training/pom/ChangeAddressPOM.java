package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeAddressPOM {

	
private WebDriver driver; 
	
	public ChangeAddressPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//td[@class='tdContentTableForms innerBorder']//td[1]//a[1]")
	private WebElement clickprofile;
	
	@FindBy(xpath="//input[@id='modifyButton']")
	private WebElement changeBtn;
	
	
	@FindBy(xpath="//tr[7]//td[2]//span[1]//input[2]")
	private WebElement address;
	
	
	@FindBy(xpath="//input[@id='saveButton']")
	private WebElement submitBtn;
	
	
	
	
	public void sendPassword(String password) {
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='m']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='a']")).click(); 
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='m']")).click(); 
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='i']")).click(); ; 
	}
	
	
	public void ClickProfile()
	{
		this.clickprofile.click();
	}
	
	public void ClickChange()
	{
		this.changeBtn.click();
	}
	
	public void ClickAddress(String enteraddress)
	{
		this.address.click();
		this.address.clear();
		this.address.sendKeys(enteraddress);
	}
	
	public void ClickSubmitBtn()
	{
		this.submitBtn.click();
	}
	
	
	
	public void AlertOK()
	{
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		
	}
	
}
