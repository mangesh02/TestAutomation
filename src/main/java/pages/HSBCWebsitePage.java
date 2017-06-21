package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automation.config.GenericActions;
import automation.config.PlatformDetails;

public class HSBCWebsitePage extends Page {
	GenericActions elements;

	@FindBy(css = "#GoToInternetBanking")
	protected WebElement onlineBankingButton;

	@FindBy(css = "div.title-content>h1")
	protected WebElement pageHeader;

	@FindBy(css = "div.home-page-content a[href='/about-hsbc']")
	protected WebElement aboutHSBCLink;

	@FindBy(css = "div.home-page-content a[href='/about-hsbc/our-purpose']")
	protected WebElement ourPurposeLink;
	
	@FindBy(css = "div.ss-tag a[href='/tag/digital-and-innovation']")
	protected WebElement digitalAndInnovationLink;

	public HSBCWebsitePage(WebDriver driver) throws IOException {
		super(driver);
		authUrl = PlatformDetails.getAUT_URL();
		elements = new GenericActions(driver);
	}

	public void load() {
		elements.loadURL(authUrl);
	}

	public void clickOnlineBankingButton() {
		elements.click(onlineBankingButton);
	}

	public String getPageHeader() {
		return elements.getText(pageHeader);
	}

	public void clickOnAboutHSBCLink() {
		elements.click(aboutHSBCLink);
	}

	public void clickOnOurPurposeLink() {
		elements.click(ourPurposeLink);
	}
	
	public void clickOnDigitalAndInnovationLink() {
		elements.click(digitalAndInnovationLink);
	}
	
	public void scrollToAboutHSBCLink() {
		elements.scrollToSpecificPoint("0", "1500");
	}
	
	public void scrollToOurPurposeLink() {
		elements.scrollToSpecificPoint("0", "1700");
	}
}
