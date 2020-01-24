package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeAdminPasswordPOM
{
private WebDriver driver; 
	
	public  ChangeAdminPasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//span[contains(text(),'Personal')]")
	 WebElement personal;
	
	@FindBy(xpath="//span[contains(text(),'Change Password')]")
	private WebElement change;
	
	@FindBy(xpath="//input[@name='oldPassword']")
	private WebElement oldpassword;
	
	@FindBy(xpath="//input[@name='newPassword']")
	private WebElement newpassword;
	
	@FindBy(xpath="//input[@name='newPasswordConfirmation']")
	private WebElement confirm;
	
	@FindBy(xpath="//input[@class='button']")
	private WebElement submit;
	
	public void personal()
	{
		this.personal.click();
	}
	public void changepasswordlink()
	{
		this.change.click();
	}
	public void oldpassword(String oldpassword)
	{
		this.oldpassword.sendKeys(oldpassword);
	}
	public void newpassword(String newpassword)
	{
		this.newpassword.sendKeys(newpassword);
	}
	public void confirmpassword(String confirm)
	{
		this.confirm.sendKeys(confirm);
	}
	public void submitbutton()
	{
		this.submit.click();
	}
	
	
	

}
