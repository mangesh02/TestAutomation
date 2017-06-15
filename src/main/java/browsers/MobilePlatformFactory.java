package browsers;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;

import automation.config.PlatformDetails;

public class MobilePlatformFactory {
	
	public static WebDriver configuredPlatform() throws IOException{
		String desiredBrowser = System.getProperty("browser",PlatformDetails.getPlatform());
		WebDriver selectedDriver=null;
		
/*		switch (desiredBrowser){
		case "androidchrome":
			selectedDriver = AndroidBrowser.configuredAndroidChromeBrowser();
			break;
		default:
			//throw new NotImplementedException("Desired Browser is not Found");
		}*/
		
		if(desiredBrowser.equalsIgnoreCase("AndroidBrowser")){
			selectedDriver = AndroidPlatform.configuredAndroidBrowser();
		}else if(desiredBrowser.equalsIgnoreCase("AndroidApp")){
			selectedDriver = AndroidPlatform.configuredAndroidApp();
		}else if(desiredBrowser.equalsIgnoreCase("AndroidBrowserStack")){
			selectedDriver = AndroidPlatform.configuredAndroidBrowserStack();
		}else if(desiredBrowser.equalsIgnoreCase("IOSBrowserStack")){
			selectedDriver = IOSPlatform.configuredIOSBrowserStack();
		}  
		else {
			throw new NotImplementedException("Desired Browser is not Found");
		}
		selectedDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return selectedDriver;
	}

}
