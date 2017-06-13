package automation.config;

import java.util.Properties;

public class ReadPropertiesFile {
	private static Properties properties = null;

	public ReadPropertiesFile() {
		ReadPropertiesFile.properties = new Properties();
		try {
			ReadPropertiesFile.properties.load(ReadPropertiesFile.class.getResourceAsStream("/testconfig.properties"));
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		assert !ReadPropertiesFile.properties.isEmpty();
	}

	public static String getProperty(final String keyName) {
		if (ReadPropertiesFile.properties == null) {
			new ReadPropertiesFile();
		}
		String property = ReadPropertiesFile.properties.getProperty(keyName);
		return property != null ? property.trim() : property;
	}

}
