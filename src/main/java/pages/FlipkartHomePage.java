package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import automation.config.GenericActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FlipkartHomePage extends MobileAppPage{
	GenericActions elements;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[contains(@resource-id,'com.flipkart.android:id/btn_skip')]")
	protected WebElement skipButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.flipkart.android:id/search_widget_textbox')]")
	protected WebElement searchTextBox;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'com.flipkart.android:id/search_autoCompleteTextView')]")
	protected WebElement searchEditTextBox;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'com.flipkart.android:id/allow_button')]")
	protected WebElement continueButton;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'com.android.packageinstaller:id/permission_allow_button')]")
	protected WebElement allowButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='No products found for hsbc bag ']")
	protected WebElement searchResultText;
	
	public FlipkartHomePage(AppiumDriver driver) throws IOException{
		super(driver);
		elements = new GenericActions(driver);
	}
	
	public void clickOnSkipButton(){
		if(elements.isElementPresent(skipButton)){
			elements.click(skipButton);
		}
	}
	
	public void clickOnSearchTextBox(){
		if(elements.isElementPresent(searchTextBox)){
			elements.click(searchTextBox);
		}
	}
	
	public void enterDataInSearchTextbox(String text){
		elements.inputValue(searchEditTextBox, text);
	}
	
	public void clickOnLocationAccessContinueButton(){
		if(elements.isElementPresent(continueButton)){
			elements.click(continueButton);
		}
	}
	
	public void clickOnLocationAccessAllowButton(){
		if(elements.isElementPresent(allowButton)){
			elements.click(allowButton);
		}
	}
	
	public boolean isSearchResultTextDisplayed(){
		return elements.isElementPresent(searchResultText);
	}
	
	public void pressSearchKey(){
		((AppiumDriver) driver).sendKeyEvent(66); 
	}
	
}
