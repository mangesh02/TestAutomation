package browsers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automation.config.PlatformDetails;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public final class AndroidPlatform {
	static Logger log = LoggerFactory.getLogger(AndroidPlatform.class);
	//public static final String USERNAME = "hsbcsystem1";
	  //public static final String AUTOMATE_KEY = "aB9AAb7nHxAsS7xWD22W";
	  //public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	
	public static WebDriver configuredAndroidBrowser() throws IOException{
		final int waitSeconds = 30;
		WebDriver driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", PlatformDetails.getDeviceName());
		capabilities.setCapability("platformVersion", PlatformDetails.getPlatformVersion()); 
		capabilities.setCapability("platformName", PlatformDetails.getPlatformName());
		capabilities.setCapability("browserName", PlatformDetails.getBrowserName());
		driver = new RemoteWebDriver(new URL(PlatformDetails.getAppiumHubURL()), capabilities);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(waitSeconds, TimeUnit.SECONDS);
		log.info("Opening Browser Session on " + PlatformDetails.getDeviceName() + " on "
				+ PlatformDetails.getBrowserName());
		return driver;
	}
	
	public static AppiumDriver configuredAndroidApp() throws IOException{
		final int waitSeconds = 30;
		AndroidDriver driver = null;
		File app = new File(PlatformDetails.getApkPath(), PlatformDetails.getApkName());
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("deviceName", PlatformDetails.getDeviceName());
		capabilities.setCapability("platformVersion", PlatformDetails.getPlatformVersion()); 
		capabilities.setCapability("platformName", PlatformDetails.getPlatformName());
		capabilities.setCapability("appPackage", PlatformDetails.getAppPackage());
		capabilities.setCapability("appActivity", PlatformDetails.getAppActivity());
		capabilities.setCapability("noReset", true);
		driver = new AndroidDriver(new URL(PlatformDetails.getAppiumHubURL()), capabilities);
		driver.manage().timeouts().implicitlyWait(waitSeconds, TimeUnit.SECONDS);
		log.info("Launching App Session on " + PlatformDetails.getDeviceName());		
		return driver;
	}
	
	public static WebDriver configuredAndroidBrowserStack() throws IOException{
		final int waitSeconds = 30;
		WebDriver driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", PlatformDetails.getBrowserName());
		capabilities.setPlatform(Platform.ANDROID);
		capabilities.setCapability("device", PlatformDetails.getDeviceName());
		capabilities.setCapability("realMobile", "true");
		capabilities.setCapability("browserstack.debug", "true");
		driver = new RemoteWebDriver(new URL(PlatformDetails.getBrowserStackURL()), capabilities);
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(waitSeconds, TimeUnit.SECONDS);
		log.info("Opening Browser Session with BrowserStack on " + PlatformDetails.getDeviceName() + " on "
				+ PlatformDetails.getBrowserName());
		return driver;
	}
	
	private AndroidPlatform(final DesiredCapabilities cap){
		super();
	}
}
