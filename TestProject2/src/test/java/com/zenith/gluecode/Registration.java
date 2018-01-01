package com.zenith.gluecode;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.zenith.constants.TestData;
import com.zenith.pages.RegistrationFactory;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Registration {
	public static WebDriver driver;
	
	@Given("^I am at registration page$")
	public void i_am_at_registration_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get(TestData.getRegisterUrl());
	    assertFalse(driver.findElements(By.xpath("//[contains(text(), \"Register\")]")).isEmpty());
	}

	@When("^I input my firstName and lastName username and password and confirmPassword and gender and email and enter submit$")
	public void i_input_my_firstName_and_lastName_username_and_password_and_confirmPassword_and_gender_and_email_and_enter_submit(
			List<RegistrationCredentials> credentialsList) throws Throwable {
	    RegistrationFactory rf = new RegistrationFactory(driver);
	    for (RegistrationCredentials credentials : credentialsList)
	    {
	    	rf.driverRegisterWithSHOULDi(credentials);
	    }
	}

	@Then("^I am at login page$")
	public void i_am_at_login_page() throws Throwable {
	    assertEquals(driver.getCurrentUrl(), TestData.getLoginUrl());
	}
	
	@When("^I hit Register as Sponsor$")
	public void i_hit_Register_as_Sponsor() throws Throwable {
	    WebElement registerAsSponsor = driver.findElement(By.id("isSponsor"));
	    // make sure registerAsSponsor is clicked 
	    if (!registerAsSponsor.isSelected())
	    	registerAsSponsor.click();
	}

	@Then("^Sponsor fields appear$")
	public void sponsor_fields_appear() throws Throwable {
	     assertFalse(driver.findElements(By.xpath("//[contains(text(), \"Sponsor \")]")).isEmpty());
	         
	}
	
	@After
	public void testTeardown()
	{
		if (driver != null)
			driver.quit();
	}
}
