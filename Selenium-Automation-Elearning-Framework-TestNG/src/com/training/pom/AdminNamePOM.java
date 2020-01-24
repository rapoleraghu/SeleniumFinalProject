package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminNamePOM
{
private WebDriver driver; 
	
	public  AdminNamePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//span[contains(text(),'Personal')]")
	 private WebElement personal;

@FindBy(xpath="//span[contains(text(),'Profile')]")
private WebElement profile;

@FindBy(xpath="//input[@id='modifyButton']")
private WebElement change;

@FindBy(xpath="//input[@name='admin(name)']")
private WebElement fullname;

@FindBy(xpath="//input[@id='saveButton']")
private WebElement submit;

public void personallink() 
{
	this.personal.click();
}


public void profilelink() 
{
	this.profile.click();
}

public void changebutton() 
{
	this.change.click();
}
public void fullnamechange(String fullname) 
{
	this.fullname.clear();
	this.fullname.sendKeys(fullname);
}
public void submitbutton() 
{
	this.submit.click();
}
}