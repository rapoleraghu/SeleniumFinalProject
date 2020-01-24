package com.training.pom;

import java.awt.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



	public class AdPOM {
		private WebDriver driver; 
		
		public AdPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="cyclosUsername")
		private WebElement userName; 
		
		@FindBy(id="cyclosPassword")
		private WebElement password;
		
		@FindBy(id="Submit")
		private WebElement loginBtn; 
		
		@FindBy(xpath="//input[@id='memberUsername']")
		private WebElement memname;
		
		@FindBy(xpath="Submit")
		private WebElement Submit;
		
		@FindBy(xpath="newButton")
		private WebElement newbutton;
		
		@FindBy(xpath="//input[@name='ad(title)']")
		private WebElement title;
		
		//@FindBy(xpath="//select[@name='ad(category)']")
		//private WebElement category;
		
		@FindBy(xpath="//option[contains(text(),'Example ad category')]")
		private WebElement category1;
		
		@FindBy(xpath="//input[@name='ad(price)']")
		private WebElement price;
		
		@FindBy(xpath="//input[@id='notExpirableCheck']")
		private WebElement check;
		
		
		@FindBy(xpath="//iframe")
		private WebElement desc;
		
		@FindBy(xpath="//input[@id='saveButton']")
		private WebElement save;
		
		@FindBy(xpath="//span[contains(text(),'Logout')]")
		private WebElement logout;
		
		@FindBy(id="cyclosUsername")
		private WebElement memlogin; 
		
		@FindBy(id="cyclosPassword")
		private WebElement mempwd;
		
		@FindBy(xpath="//div[@id='virtualKeyboard']//div//input[@class='button']")
		private WebElement submitBtn; 
		
		@FindBy(xpath="//span[contains(text(),'Personal')]")
		private WebElement personal;
		
		@FindBy(xpath="//span[contains(text(),'Advertisements')]")
		private WebElement ad;
		
		public void sendUserName(String userName) {
			this.userName.clear();
			this.userName.sendKeys(userName);
		}
		
		public void sendPassword(String password) {
			driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
			driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click(); 
			driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click(); 
			driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='4']")).click(); 

		}
		
		public void clickLoginBtn() {
			driver.findElement(By.xpath("//div[@id='virtualKeyboard']//div//input[@class='button']")).click();
		}
		public void memname(String memname)
		{
			this.memname.clear();
			this.memname.sendKeys(memname);
	
		}
		
		public void submit(){
			driver.findElement(By.xpath("//tr[4]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")).click();
		}
		
		public void newButton(){
			driver.findElement(By.xpath("//input[@id='newButton']")).click();
		}
		
		public void title(String title) {
			this.title.clear();
			this.title.sendKeys(title);
		}
		
		public void category()
		{
			this.category1.click();
		}
		public void price(String price) {
			this.price.clear();
			this.price.sendKeys(price);
		}
	
		public void check(){
			check.click();
		}
		
		public void Desc(String descr) {
			this.desc.sendKeys(descr);
		}
	
		public void save(){
			save.click();
		}
		
		public void alertOk(){
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
public void logout(){
	logout.click();
}

public void alertaccept(){
	Alert alert1=driver.switchTo().alert();
	alert1.accept();
}
public void memlogin(String memlogin) {
	this.memlogin.clear();
	this.memlogin.sendKeys(memlogin);
}

public void mempwd(String mempwd) {
	driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='p']")).click();
	driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='a']")).click(); 
	driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='n']")).click(); 
	driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='d']")).click(); 
	driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='u']")).click(); 


}

public void submitBtn() {
	submitBtn.click();
}

public void personal(){
	personal.click();
}
public void ad(){
	ad.click();
}
}
