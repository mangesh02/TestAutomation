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
import pages.FlipkartHomePage;

public class FlipkartAppStep {
	AppiumDriver driver;
	private FlipkartHomePage flipkarthomepage;
	Hooks hooks = new Hooks();
	Logger log = LoggerFactory.getLogger(FlipkartAppStep.class);
	
	public FlipkartAppStep() throws IOException{
		this .driver=(AppiumDriver) hooks.getDriver();
		this.flipkarthomepage = new FlipkartHomePage(this.driver);
	}

	@Given("^flipkart app is launched$")
	public void flipkart_app_launched() throws MalformedURLException{
		log.info("Flipkart app launched");
	}
	
	@When("^user searches for (.*)$")
	public void search_for_specific_text(String text) throws InterruptedException{
		flipkarthomepage.clickOnSkipButton();
		flipkarthomepage.clickOnSearchTextBox();
		flipkarthomepage.enterDataInSearchTextbox(text);
		flipkarthomepage.pressSearchKey();
		flipkarthomepage.clickOnLocationAccessContinueButton();
		flipkarthomepage.clickOnLocationAccessAllowButton();
		log.info("Searched for the text '" + text + "'");
	}
	
	@Then("^search result should show as no products found for hsbc bag$")
	public void search_result(){
		Assert.assertEquals(flipkarthomepage.isSearchResultTextDisplayed(), true);
		log.info("Verified the result");
	}
}
