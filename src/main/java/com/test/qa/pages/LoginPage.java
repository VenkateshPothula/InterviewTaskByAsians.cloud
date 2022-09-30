package com.test.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	//RegisterElements ****////
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	WebElement registerlink;
	
	@FindBy(id="email")
	WebElement emailtexbox;
	
	@FindBy(id="password")
	WebElement passwordtextbox;
	
	@FindBy(id="password-confirm")
	WebElement passwordconfirmtexbox;
	
   @FindBy(xpath="//input[@value='Register']")
	
	WebElement Registerbutton;
	
	///*** Login Elements****///
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	
	WebElement password;
	
	@FindBy(name="login")
	
	WebElement loginBtn;
	
	
	
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	
public  void RegisterFunction(String NewEmailID, String NewPassword) throws InterruptedException, IOException {
		
		Thread.sleep(2000);
		click(registerlink);
		
		typeText(emailtexbox, NewEmailID);
		Thread.sleep(2000);
		typeText(passwordtextbox, NewPassword);
		Thread.sleep(2000);
		typeText(passwordconfirmtexbox, NewPassword);
		ExplicitWait(Registerbutton, 20);
		click(Registerbutton);
		
	}
	
	public  void LoginFunction(String firstname, String lastname) throws InterruptedException, IOException {
		
		Thread.sleep(2000);
		
		
		typeText(username, firstname);
		Thread.sleep(2000);
		typeText(password, lastname);
		Thread.sleep(2000);
		ExplicitWait(loginBtn, 20);
		click(loginBtn);
		
	}
	
	
	
	
	
	
}
