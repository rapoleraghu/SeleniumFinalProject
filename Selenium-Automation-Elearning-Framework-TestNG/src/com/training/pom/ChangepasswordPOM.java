package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;


public class ChangepasswordPOM 
{
private WebDriver driver; 
	
	public  ChangepasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//span[contains(text(),'Personal')]")
	 WebElement personal;
	
	@FindBy(xpath="//span[contains(text(),'Change password')]")
	 WebElement changepassword;

	@FindBy(xpath="//input[@name='oldPassword']")
	private WebElement oldpass;
	
	
	@FindBy(xpath="//input[@name='newPassword']")
	private WebElement newpass;
	
	@FindBy(xpath="//input[@name='newPasswordConfirmation']")
	private WebElement newconpass;
	
	@FindBy(xpath="//input[@class='button']")
	private WebElement submit;
	
	
	

	public void personallink()
	{
		this.personal.click();
	}
		
	public void changelink()
		{        
			
			this.changepassword.click();
		
	}
		
		public void oldpassword(String oldpass) {
			this.oldpass.sendKeys(oldpass);
		}

		public void newpassword(String newpass) {
			this.newpass.sendKeys(newpass);
		}	
		
		public void newconfirmpassword(String newconpass) {
			this.newconpass.sendKeys(newconpass);
		}	

		public void passsubmit() {
			this.submit.click();
		}	
	
	 
}
