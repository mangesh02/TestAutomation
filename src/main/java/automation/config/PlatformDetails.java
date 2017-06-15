package automation.config;

public class PlatformDetails {
	public static String autURL;
	public static String platform;
	public static String browserName;
	public static String deviceName;
	public static String platformName;
	public static String platformVersion;
	public static String appPackage;
	public static String appActivity;
	public static String apkPath;
	public static String apkName;
	public static String appiumHubURL;
	public static String browserStackURL;

	public static String getAUT_URL() {
		autURL = System.getProperty("autURL", ReadPropertiesFile.getProperty("aut.url"));
		return autURL;
	}

	public static String getPlatform() {
		platform = System.getProperty("platform", ReadPropertiesFile.getProperty("platform"));
		return platform;
	}

	public static String getBrowserName() {
		browserName = System.getProperty("browser", ReadPropertiesFile.getProperty("browser.name"));
		return browserName;
	}

	public static String getDeviceName() {
		deviceName = System.getProperty("deviceName", ReadPropertiesFile.getProperty("device.name"));
		return deviceName;
	}

	public static String getPlatformName() {
		platformName = System.getProperty("platformName", ReadPropertiesFile.getProperty("platform.name"));
		return platformName;
	}

	public static String getPlatformVersion() {
		platformVersion = System.getProperty("platformVersion", ReadPropertiesFile.getProperty("platform.version"));
		return platformVersion;
	}

	public static String getAppPackage() {
		appPackage = System.getProperty("appPackage", ReadPropertiesFile.getProperty("app.package"));
		return appPackage;
	}

	public static String getAppActivity() {
		appActivity = System.getProperty("appActivity", ReadPropertiesFile.getProperty("app.activity"));
		return appActivity;
	}

	public static String getApkPath() {
		apkPath = System.getProperty("apkPath", ReadPropertiesFile.getProperty("apk.path"));
		return apkPath;
	}

	public static String getApkName() {
		apkName = System.getProperty("apkName", ReadPropertiesFile.getProperty("apk.name"));
		return apkName;
	}

	public static String getAppiumHubURL() {
		appiumHubURL = System.getProperty("appiumHubURL", ReadPropertiesFile.getProperty("appium.server.url"));
		return appiumHubURL;
	}

	public static String getBrowserStackURL() {
		browserStackURL = "https://" + ReadPropertiesFile.getProperty("browserstack.user.name") + ":" 
				+ ReadPropertiesFile.getProperty("browserstack.access.key")
				+ ReadPropertiesFile.getProperty("browserstack.url");
		return browserStackURL;
	}

}
