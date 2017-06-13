package browsers;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.NotImplementedException;

import automation.config.PlatformDetails;
import io.appium.java_client.AppiumDriver;

public class MobilePlatformFactory1 {
	
	public static AppiumDriver configuredAppPlatform() throws IOException{
		String desiredApp = System.getProperty("platform",PlatformDetails.getPlatform());
		AppiumDriver selectedDriver=null;
	
		if(desiredApp.equalsIgnoreCase("App")){
			selectedDriver = AndroidNativeApp.configuredAndroidApp();
		} 
		else {
			throw new NotImplementedException("Desired platform for App is not Found");
		}
		selectedDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return selectedDriver;
	}

}
