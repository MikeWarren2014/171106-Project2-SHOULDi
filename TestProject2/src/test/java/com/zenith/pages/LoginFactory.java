package com.zenith.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFactory {
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//button[contains(text(), 'Login')]")
	WebElement login;
	
	public LoginFactory(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inputUsername(String username){
		this.username.sendKeys(username);
	}
	
	public void inputPassword(String password){
		this.password.sendKeys(password);
	}
	
	public void submitLogin(){
		this.login.click();
	}
	
	public void driverLogIntoMercury(String username, String password){
		inputUsername(username);
		inputPassword(password);
		submitLogin();
	}

}
