package automation.stepdefs;


import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import browsers.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import pages.CalculatorPage;

public class CalculatorStep {
	AppiumDriver driver;
	private CalculatorPage calculatorpage;
	Hooks hooks = new Hooks();
	Logger log = LoggerFactory.getLogger(CalculatorStep.class);
	
	public CalculatorStep() throws IOException{
		this .driver=(AppiumDriver) hooks.getDriver();
		this.calculatorpage = new CalculatorPage(this.driver);
	}

	@Given("^calculator app is launched$")
	public void calculator_app_launched() throws MalformedURLException{
		log.info("Calculator app launched");
	}
	
	@When("^user adds two numbers$")
	public void add_two_numbers() throws InterruptedException{
		calculatorpage.clickOnNumberFourButton();
		calculatorpage.clickOnPlusButton();
		calculatorpage.clickOnNumberFourButton();
		calculatorpage.clickOnEqualToButton();
		log.info("Clicked on Online banking button on homepage");
	}
	
	@Then("^correct result for the addition should be displayed$")
	public void addition_result(){
		Assert.assertEquals(calculatorpage.getResult(), "8");
		log.info("Verified the result");
	}
}
