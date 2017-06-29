package automation.stepdefs;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cucumber.listener.Reporter;

import automation.config.PlatformDetails;
import browsers.Hooks;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HSBCWebsitePage;

public class HSBCWebStep {
	WebDriver driver;
	private HSBCWebsitePage hsbcwebsitepage;
	Hooks hooks = new Hooks();
	Logger log = LoggerFactory.getLogger(HSBCWebStep.class);

	public HSBCWebStep() throws IOException {
		this.driver = hooks.getDriver();
		this.hsbcwebsitepage = new HSBCWebsitePage(this.driver);
	}
	
	//@Rule
	//public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Given("^hsbc website page is open$")
	public void user_on_hsbc_website_page() throws MalformedURLException {
		hsbcwebsitepage.load();
		// Reporter.addStepLog("HSBC website page has been loaded");
		// Reporter.addScenarioLog("This is a test scenario log");//Test run on
		// "+PlatformDetails.getDeviceName());
		log.info("HSBC website page loaded");
	}

	@When("^user clicks on the online banking button$")
	public void user_clicks_on_online_banking_button() throws InterruptedException {
		hsbcwebsitepage.clickOnlineBankingButton();
		log.info("Clicked on Online banking button on homepage");
	}
	
	@When("^user clicks on the about hsbc link$")
	public void user_clicks_on_about_hsbc_link() throws InterruptedException {
		hsbcwebsitepage.scrollToAboutHSBCLink();
		hsbcwebsitepage.clickOnAboutHSBCLink();
		log.info("Clicked on About HSBC link on homepage");
	}
	
	@When("^user clicks on the our purpose link$")
	public void user_clicks_on_our_purpose_link() throws InterruptedException {
		hsbcwebsitepage.scrollToOurPurposeLink();
		hsbcwebsitepage.clickOnOurPurposeLink();
		log.info("Clicked on Our purpose link on homepage");
	}
	
	@When("^user clicks on the digital and innovation link$")
	public void user_clicks_on_life_at_hsbc_link() throws InterruptedException {
		hsbcwebsitepage.clickOnDigitalAndInnovationLink();
		log.info("Clicked on Life at HSBC link on homepage");
	}

	@Then("^(.*) page should open$")
	public void display_respective_page(String pageHeader) {
		Assert.assertEquals(hsbcwebsitepage.getPageHeader(), pageHeader);
		log.info("Verified the heading on the page which is " + pageHeader);
	}
}
