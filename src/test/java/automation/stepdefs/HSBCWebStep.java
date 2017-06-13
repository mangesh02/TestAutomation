package automation.stepdefs;


import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import browsers.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HSBCWebsitePage;

public class HSBCWebStep {
	WebDriver driver;
	private HSBCWebsitePage hsbcwebsitepage;
	Hooks hooks = new Hooks();
	Logger log = LoggerFactory.getLogger(HSBCWebStep.class);
	
	public HSBCWebStep() throws IOException{
		this .driver=hooks.getDriver();
		this.hsbcwebsitepage = new HSBCWebsitePage(this.driver);
	}

	@Given("^hsbc website page is open$")
	public void user_on_hsbc_website_page() throws MalformedURLException{
		//driver.get("http://hsbc.co.in");
		hsbcwebsitepage.load();
		log.info("HSBC wesite page loaded");
	}
	
	@When("^user clicks on the online banking button$")
	public void user_clicks_on_online_banking_button() throws InterruptedException{
		hsbcwebsitepage.clickOnlieBankingButton();
		log.info("Clicked on Online banking button on homepage");
	}
	
	@Then("^(.*) page should open$")
	public void display_online_banking_page(String pageHeader){
		Assert.assertEquals(hsbcwebsitepage.getPageHeader(), pageHeader);
		log.info("Verified the heading on the page which is " + pageHeader);
	}
}
