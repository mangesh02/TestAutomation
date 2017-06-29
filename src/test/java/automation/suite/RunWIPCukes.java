package automation.suite;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import reports.HTMLParser;
import reports.XMLParser;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber.json" }, glue = { "automation.stepdefs",
		"browsers" }, features = "src/test/resources/features", monochrome = true, tags = { "@androidbrowser",
				"~@androidapp" })
// "pretty",
// "json:target/cucumber.json","com.cucumber.listener.ExtentCucumberFormatter:output/report.html"

public class RunWIPCukes {
	/*
	 * @AfterClass public static void setup() throws Exception {
	 * Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	 * Reporter.setSystemInfo("user", System.getProperty("user.name"));
	 * Reporter.setSystemInfo("OS", "Windows");
	 * Reporter.setTestRunnerOutput("Sample Test run"); }
	 */
}
