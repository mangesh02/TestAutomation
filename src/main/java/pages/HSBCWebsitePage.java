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
	protected WebElement onlineBankingPageHeader;

	public HSBCWebsitePage(WebDriver driver) throws IOException {
		super(driver);
		authUrl = PlatformDetails.getAUT_URL();
		elements = new GenericActions(driver);
	}

	public void load() {
		elements.loadURL(authUrl);
	}

	public void clickOnlieBankingButton() {
		elements.click(onlineBankingButton);
	}

	public String getPageHeader() {
		return elements.getText(onlineBankingPageHeader);
	}
}
