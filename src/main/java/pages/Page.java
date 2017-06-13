package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {
protected WebDriver driver;
protected String pageURL;
protected String authUrl;
protected String journeyURL;

//protected Logger log = LoggerFactory.getLogger(this.getClass());

public Page(WebDriver driver){
	this.driver =driver;
	//log.debug("Saved local driver reference");
	PageFactory.initElements(driver, this);
	//log.debug("Initialized page elements");
}
}
