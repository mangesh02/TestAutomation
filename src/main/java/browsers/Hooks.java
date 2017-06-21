package browsers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automation.config.PlatformDetails;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	static WebDriver driver;
	int number = 0;
	Logger log = LoggerFactory.getLogger(Hooks.class);
	
	@Before
	public void startSession(Scenario scenario) throws IOException {
		System.out.println("This is the name of the tag for feature file "+scenario.getSourceTagNames());
		driver = MobilePlatformFactory.configuredPlatform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		log.info("Session Started");
	}

	@After
	public void closeSession(Scenario scenario) throws Exception {
		if (PlatformDetails.getPlatform().equals("AndroidBrowser")) {
			scenario.write("Scenario executed on " + PlatformDetails.getDeviceName() + " with OS version "
					+ PlatformDetails.getPlatformName() + " " + PlatformDetails.getPlatformVersion() + " on "
					+ PlatformDetails.getBrowserName());
		} else if (PlatformDetails.getPlatform().equals("AndroidApp")) {
			scenario.write("Scenario executed on " + PlatformDetails.getDeviceName() + " with OS version "
					+ PlatformDetails.getPlatformName() + " " + PlatformDetails.getPlatformVersion() + " on "
					+ PlatformDetails.getApkName() + " Native App");
		}
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
		driver.quit();
		log.info("Session Closed");
	}

	public WebDriver getDriver() {
		return driver;
	}

	public Cookie getCookie() {
		return driver.manage().getCookieNamed("browser-session-duration");
	}

	public void embedImage(final byte[] image) throws IOException {
		++number;
		InputStream in = new ByteArrayInputStream(image);
		BufferedImage bufferedImage = ImageIO.read(in);
		String filePath = System.getProperty("user.dir") + "/target/test-report/" + number;
		ImageIO.write(bufferedImage, "jpg", new File(filePath + ".jpg"));
	}
}
