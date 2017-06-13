package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MobileAppPage {
protected WebDriver driver;
protected String pageURL;
protected String authUrl;
protected String journeyURL;

//protected Logger log = LoggerFactory.getLogger(this.getClass());

public MobileAppPage(AppiumDriver driver){
	this.driver =driver;
	//log.debug("Saved local driver reference");
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	//log.debug("Initialized page elements");
}
}
