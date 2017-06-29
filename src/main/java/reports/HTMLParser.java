package reports;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTMLParser {

	public static void main (String[] args) throws IOException {
/*		boolean waitForFile = true;
		while(waitForFile){
			File f = new File("./target/site/cucumber-reports/feature-overview.html");
			if(f.exists() && f.isDirectory()){waitForFile=false;}
		}*/
		HashMap<String, String> result = new HashMap<String, String>();
		Logger log = LoggerFactory.getLogger(HTMLParser.class);

		String hostname = "Unknown";

		try {
			InetAddress addr;
			addr = InetAddress.getLocalHost();
			hostname = addr.getHostName();
		} catch (UnknownHostException ex) {
			System.out.println("Hostname can not be resolved");
		}
		System.out.println(hostname);
		log.info("The hostname is : "+hostname);

		File input = new File("./target/site/cucumber-reports/feature-overview.html");
		Document doc = Jsoup.parse(input, "UTF-8", "");
		String featureName;

		String title = doc.title();
		System.out.println("title : " + title);

		Elements text = doc.getElementsByClass("tagName");

		for (Element element : text) {
			featureName = element.text();
			System.out.println(featureName);
		}

		Element totalFeatures = doc.getElementById("stats-total-features");
		System.out.println("The total number of features are : " + totalFeatures.text());
		log.info("The total number of features are : " + totalFeatures.text());

		Element totalScenarios = doc.getElementById("stats-total-scenarios");
		System.out.println("The total number of scenarios are : " + totalScenarios.text());
		log.info("The total number of scenarios are : " + totalScenarios.text());

		Element totalScenariosPassed = doc.getElementById("stats-total-scenarios-passed");
		System.out.println("The total number of scenarios passed are : " + totalScenariosPassed.text());
		log.info("The total number of scenarios passed are : " + totalScenariosPassed.text());

		Element totalScenariosFailed = doc.getElementById("stats-total-scenarios-failed");
		System.out.println("The total number of scenarios failed are : " + totalScenariosFailed.text());
		log.info("The total number of scenarios failed are : " + totalScenariosFailed.text());

		Element totalSteps = doc.getElementById("stats-total-steps");
		System.out.println("The total number of steps are : " + totalSteps.text());
		log.info("The total number of steps are : " + totalSteps.text());

		Element totalStepsPassed = doc.getElementById("stats-total-steps-passed");
		System.out.println("The total number of steps passed are : " + totalStepsPassed.text());
		log.info("The total number of steps passed are : " + totalStepsPassed.text());

		Element totalStepsFailed = doc.getElementById("stats-total-steps-failed");
		System.out.println("The total number of steps failed are : " + totalStepsFailed.text());
		log.info("The total number of steps failed are : " + totalStepsFailed.text());

		result.put("HostName", hostname);
		result.put("Total Features", totalFeatures.text());
		result.put("Total Scenarios", totalScenarios.text());
		result.put("Total Scenarios Passed", totalScenariosPassed.text());
		result.put("Total Scenarios Failed", totalScenariosFailed.text());
		result.put("Total Steps", totalSteps.text());
		result.put("Total Steps Passed", totalStepsPassed.text());
		result.put("Total Steps Failed", totalStepsFailed.text());
		
		/*		Elements scriptElements = doc.getElementsByTag("script");

		for (Element element : scriptElements) {
			for (DataNode node : element.dataNodes()) {
				System.out.println(node.getWholeData());
			}
			System.out.println("-------------------");
		}
*/
	}

}
