package reports;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {
	 public static void main(String args[]) throws ClassNotFoundException, SQLException {
			String hostname = "Unknown";
			int totalScenarios = 0,totalScenariosFailed = 0,totalSteps = 0,totalStepsFailure = 0,totalErrors = 0,totalStepsSkipped = 0;
			
			try {
				InetAddress address;
				address = InetAddress.getLocalHost();
				hostname = address.getHostName();
			} catch (UnknownHostException ex) {
				System.out.println("Hostname can not be resolved");
			}
			System.out.println("The hostname is : "+hostname);

		    try {

			System.out.println("Root element :" + parseDocument().getDocumentElement().getNodeName());
			
			System.out.println("\n The total number of feature files executed is : " + getNumberOfFeatueFilesExecuted());
			
			totalScenarios = getCountUsingXpath("//testcase[contains(@name,'Scenario:')]");
			System.out.println("\n The total number of scenarios executed is : " + totalScenarios);

			totalScenariosFailed = getCountUsingXpath("//testcase[contains(@name,'Scenario:')]/failure");
			System.out.println("\n The total number of scenarios failed is : " + totalScenariosFailed);

			int steps = getCountUsingTagName("testsuite","tests");
			totalSteps = steps - totalScenarios;
			System.out.println("\n The total number of steps executed is : " + totalSteps);

			int stepsFailure = getCountUsingTagName("testsuite","failures");
			totalStepsFailure = stepsFailure - totalScenariosFailed;
			System.out.println("\n The total number of steps failed is : " + totalStepsFailure);

			totalErrors = getCountUsingTagName("testsuite","errors");
			System.out.println("\n The total number of errors is : " + totalErrors);

			totalStepsSkipped = getCountUsingTagName("testsuite","skipped");
			System.out.println("\n The total number of steps skipped is : " + totalStepsSkipped);

			System.out.println("----------------------------");

		    } catch (Exception e) {
			e.printStackTrace();
		    }
		    
		    String query = "INSERT INTO RESULTS " + "VALUES ("+hostname+","+totalScenarios+","+totalScenariosFailed+","+totalSteps+","+totalStepsFailure+","+totalStepsSkipped+","+totalErrors+")";
			//updateDataBase(query);
	 }
	 
		public static Document parseDocument(){
			Document doc = null;
			try{
			File fXmlFile = new File("target/surefire-reports/TEST-automation.suite.RunWIPCukes.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			}catch(Exception e){
				System.out.println(e);
			}
			return doc;
		}

		public static int getCountUsingXpath(String xpathExpression) {
			int count=0;
			try {
				XPathFactory xPathfactory = XPathFactory.newInstance();
				XPath xpath = xPathfactory.newXPath();
				XPathExpression xpathExpr = xpath.compile(xpathExpression);
				NodeList scn = (NodeList) xpathExpr.evaluate(parseDocument(), XPathConstants.NODESET);
				count=scn.getLength();
			} catch (Exception e) {
				System.out.println(e);
			}
			return count;
		}
		
		public static int getCountUsingTagName(String tagName, String attribute) {
			int count=0;
			try {
				NodeList nList1 = parseDocument().getElementsByTagName(tagName);
				String size = nList1.item(0).getAttributes().getNamedItem(attribute).getNodeValue();
				count=Integer.parseInt(size);
			} catch (Exception e) {
				System.out.println(e);
			}
			return count;
		}
	 
	 public static void updateDataBase(String query) throws ClassNotFoundException, SQLException{
		    Class.forName("oracle.jdbc.driver.OracleDriver");  
		    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
		    Statement statement = connection.createStatement();
		    statement.executeUpdate(query);
		    connection.close();
	 }
	 
		public static int getNumberOfFeatueFilesExecuted() {
			List<String> list = new ArrayList<String>();
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			File directory = new File("src/test/resources/features");
			File[] fList = directory.listFiles();
			
			try {
				XPathFactory xPathfactory = XPathFactory.newInstance();
				XPath xpath = xPathfactory.newXPath();
				XPathExpression xpathExpr = xpath.compile("//testcase[contains(@name,'Scenario:')]");
				NodeList scn = (NodeList) xpathExpr.evaluate(parseDocument(), XPathConstants.NODESET);

				for (int i = 0; i < scn.getLength(); i++) {
					Node curentItem = scn.item(i);
					String key = curentItem.getAttributes().getNamedItem("name").getNodeValue();

					for (File file : fList) {
						String fileName = file.getName();
						try {
							BufferedReader in = new BufferedReader(new FileReader(file));
							String line;
							while ((line = in.readLine()) != null) {
								if (line.contains("Scenario")) {
									list.add(line);
								}
							}
							in.close();
						} catch (FileNotFoundException e) {
							System.err.println("Unable to find the file: " + file);
						} catch (IOException e) {
							System.err.println("Unable to read the file: " + file);
						}
						for (int j = 0; j < list.size(); j++) {
							if (list.get(j).contains(key)) {
								if (map.containsKey(fileName)) {
									map.put(fileName, map.get(fileName) + 1);
								} else {
									map.put(fileName, 1);
								}
							}
						}
						list.clear();
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			return map.size();
		}
}
