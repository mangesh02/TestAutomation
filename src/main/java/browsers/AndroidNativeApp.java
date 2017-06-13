package browsers;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import automation.config.PlatformDetails;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public final class AndroidNativeApp {

	public static AppiumDriver configuredAndroidApp() throws IOException{
		final int waitSeconds = 30;
		AndroidDriver driver = null;
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", PlatformDetails.getDeviceName());//Samsumg Galay S7 Edge, iris X1
		cap.setCapability("platformVersion", PlatformDetails.getPlatformVersion());// Samsung S7 - 6.0.1, Lava Iris - 4.4.2 
		cap.setCapability("platformName", PlatformDetails.getPlatformName());
		//cap.setCapability("browserName", PlatformDetails.getBrowser());
		cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(waitSeconds, TimeUnit.SECONDS);
		return driver;
	}
	
	private AndroidNativeApp(final DesiredCapabilities cap){
		super();
	}
}
