package automation.config;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericActions {
	WebDriver driver;

	public GenericActions(WebDriver driver) {
		this.driver = driver;
	}

	public void loadURL(String url) {
		driver.get(url);
	}

	public void inputValue(WebElement locator, String value) {
		waitForElementFluently(locator, 10);
		locator.clear();
		locator.sendKeys(value);
	}

	public void click(WebElement locator) {
		waitForElementFluently(locator, 10);
		locator.click();
	}

	public String getText(WebElement locator) {
		waitForElementFluently(locator, 10);
		String result = "";
		if (isElementPresent(locator)) {
			result = locator.getText();
		}
		return result;
	}

	public boolean isElementPresent(WebElement locator) {
		boolean result = false;
		try {
			result = locator.isDisplayed();
			if (result) {
				result = true;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}

	public void waitForElementFluently(WebElement locator, int seconds) {
		int retry = 0;
		int retryCount = seconds < 25 ? 2 : 1;
		while (retry < retryCount) {
			try {
				Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(seconds, TimeUnit.SECONDS)
						.pollingEvery(200, TimeUnit.MILLISECONDS);
				wait.until(ExpectedConditions.visibilityOf(locator));
			} catch (Exception ex) {

			}
			retry++;
		}
	}

	public void waitForElementToDisappear(List<WebElement> locator) {
		List<WebElement> elements = locator;
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	public void scrollToSpecificPoint(String xAxis, String yAxis) {
		((JavascriptExecutor) driver).executeScript("scroll(" + xAxis + ", " + yAxis + ")");
	}
}
