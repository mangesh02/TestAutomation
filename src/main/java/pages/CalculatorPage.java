package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import automation.config.GenericActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CalculatorPage extends MobileAppPage{
	GenericActions elements;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='4']")
	protected WebElement numberFourButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='+']")
	protected WebElement plusButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='=']")
	protected WebElement equalToButton;
	
	@AndroidFindBy(xpath="//android.widget.EditText[contains(@resource-id,'com.sec.android.app.popupcalculator:id/txtCalc')]")
	protected WebElement result;
	
	public CalculatorPage(AppiumDriver driver) throws IOException{
		super(driver);
		elements = new GenericActions(driver);
	}
	
	public void clickOnNumberFourButton(){
		elements.click(numberFourButton);
	}
	
	public void clickOnPlusButton(){
		elements.click(plusButton);
	}
	
	public void clickOnEqualToButton(){
		elements.click(equalToButton);
	}
	
	public String getResult(){
		return elements.getText(result);				
	}
}
