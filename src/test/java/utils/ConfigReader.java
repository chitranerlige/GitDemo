package utils;

import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigReader {

	private static Properties properties;
	private static final Logger log = LogManager.getLogger(ConfigReader.class);

	public static void loadProperties() {
		try {
	        InputStream input =
	                ConfigReader.class.getClassLoader()
	                        .getResourceAsStream("config.properties");

	        if (input == null) {
	            throw new RuntimeException("config.properties not found in classpath");
	        }

	        properties = new Properties();
	        properties.load(input);

	    } catch (Exception e) {
	        log.error("Failed to load config", e);
	        throw new RuntimeException("Framework initialization failed", e);
	    }

	}

	public static String getProperty(String key) {
		if (properties == null) {
			loadProperties();
		}
		String returedvalue = properties.getProperty(key);
		return returedvalue;
	}
}
