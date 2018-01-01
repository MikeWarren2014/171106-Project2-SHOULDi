package com.zenith.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zenith.gluecode.RegistrationCredentials;

public class RegistrationFactory {
	@FindBy(xpath="//input[@id=\"firstName\"]")
	WebElement firstName;
	@FindBy(xpath="//input[@id=\"lastName\"]")
	WebElement lastName;
	@FindBy(xpath="//input[@id=\"userName\"]")
	WebElement userName;
	@FindBy(xpath="//input[@id=\"password\"]")
	WebElement password;
	@FindBy(xpath="//input[@id=\"confirmPassword\"]")
	WebElement confirmPassword;
	@FindBy(xpath="//input[@id=\"gender\"]")
	WebElement gender;
	@FindBy(xpath="//input[@id=\"email\"]")
	WebElement email;
	@FindBy(xpath="//[@id=\"registerButton\"]")
	WebElement registerButton;
	
	public RegistrationFactory(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inputFirstName(String str)
	{
		this.firstName.sendKeys(str);
	}
	public void inputLastName(String str)
	{
		this.lastName.sendKeys(str);
	}
	public void inputUserName(String str)
	{
		this.userName.sendKeys(str);
	}
	public void inputPassword(String str)
	{
		this.password.sendKeys(str);
	}
	public void inputConfirmPassword(String str)
	{
		this.confirmPassword.sendKeys(str);
	}
	public void inputGender(String str)
	{
		this.gender.sendKeys(str);
	}
	public void inputEmail(String str)
	{
		this.email.sendKeys(str);
	}
	
	public void hitRegister()
	{
		this.registerButton.click();
	}
	
	public void driverRegisterWithSHOULDi(RegistrationCredentials credentials)
	{
		inputFirstName(credentials.getFirstName());
		inputLastName(credentials.getLastName());
		inputUserName(credentials.getUsername());
		inputPassword(credentials.getPassword());
		inputConfirmPassword(credentials.getConfirmPassword());
		inputGender(credentials.getGender());
		inputEmail(credentials.getEmail());
		hitRegister();
	}
}
