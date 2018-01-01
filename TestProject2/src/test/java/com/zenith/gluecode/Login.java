package com.zenith.gluecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	public static WebDriver driver;
//	public static final String LOGIN = 
	
	@Given("^I am at login$")
	public void i_am_at_login() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("");
	}

	@When("^I login with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_login_with_and(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I arrive at dashboard$")
	public void i_arrive_at_dashboard() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@After
	public void testTeardown()
	{
		if (driver != null)
			driver.quit();
	}
}
