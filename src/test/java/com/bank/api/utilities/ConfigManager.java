package com.bank.api.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	private static Properties properties;

	private ConfigManager() {
	}

	public static Properties getInstance() {
		if (properties == null) {
			properties = new Properties();

			String env = System.getProperty("env");

			if (env == null) {
				env = "dev"; // Default environment if system property is not set
				System.out.println("No environment specified. Defaulting to 'dev'");
			}

			String configFileName = "src/test/resource/config_" + env + ".properties";
			try {
				FileInputStream fileInputStream = new FileInputStream(configFileName);
				properties = new Properties();
				properties.load(fileInputStream);
			} catch (IOException e) {
				System.out.println("Failed to load config.properties file");
			}
		}
		return properties;
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
