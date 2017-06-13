package browsers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	static WebDriver driver;
	int number = 0;
	Logger log = LoggerFactory.getLogger(Hooks.class);

	@Before
	public void startSession() throws IOException {
		driver = MobilePlatformFactory.configuredPlatform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		log.info("Session Started");
	}

	@After
	public void closeSession(Scenario scenario) {
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
