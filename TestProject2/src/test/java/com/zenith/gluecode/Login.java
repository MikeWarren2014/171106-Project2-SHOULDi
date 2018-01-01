package com.zenith.gluecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.zenith.constants.TestData;
import com.zenith.pages.LoginFactory;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static org.junit.Assert.*;

public class Login {
	public static WebDriver driver;
	
	@Given("^I am at login$")
	public void i_am_at_login() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get(TestData.getLoginUrl());
	    // NOTE: This way is bad, because that class name could change. I felt I had
	    //	no other choice, though...
	    // assertion that we are, indeed, at the login page....
	    assertFalse(driver.findElements(By.className("login-content")).isEmpty());
	}

	@When("^I login with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_login_with_and(String arg1, String arg2) throws Throwable {
	    LoginFactory lf = new LoginFactory(driver);
	    lf.driverLogIntoMercury(arg1, arg2);
	}

	@Then("^I arrive at dashboard$")
	public void i_arrive_at_dashboard() throws Throwable {
	    assertEquals(driver.getCurrentUrl(), TestData.getBaseUrl() + "/home");
	}

	@After
	public void testTeardown()
	{
		if (driver != null)
			driver.quit();
	}
}
