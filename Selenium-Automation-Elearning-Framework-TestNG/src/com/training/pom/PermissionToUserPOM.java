package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PermissionToUserPOM {

private WebDriver driver; 
	
	public PermissionToUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//input[@id='memberUsername']")
	private WebElement memberlogin;
	
	@FindBy(xpath="//body[@class='main']//tr//tr[2]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[4]//input[1]")
	private WebElement submitBtn;
	
	
	@FindBy(xpath="//select[@name='newGroupId']")
	private WebElement clicknewgroup;
	
	
	@FindBy(xpath="//option[contains(text(),'Full members')]")
	private WebElement selectfullmembers;
	
	@FindBy(xpath="//textarea[@id='comments']")
	private WebElement comment;
	
	@FindBy(xpath="//table[@class='defaultTable']//input[@class='button']")
	private WebElement clickSubmitBtn;
	
	
	
	
	
	
	
	
	public void memberLogin(String memberlogin)
	{
		this.memberlogin.sendKeys(memberlogin);
	}
	
	public void clickSubmit()
	{
		this.submitBtn.click();
	}
	
	public void clickNewGroup()
	{
		this.clicknewgroup.click();
	}
	
	public void selectFullMembers()
	{
		this.selectfullmembers.click();
	}
	
	public void Comment(String comment)
	{
		this.comment.click();
		this.comment.clear();
		this.comment.sendKeys(comment);
	}
	
	public void ClickSubmitBtn()
	{
		this.clickSubmitBtn.click();
	}
	
	public void AlertOK()
	{
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		
	}
	
}