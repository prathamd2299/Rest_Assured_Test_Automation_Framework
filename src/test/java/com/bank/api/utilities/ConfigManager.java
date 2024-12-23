package com.bank.api.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	private static Properties properties;

	static {
		try {
			FileInputStream fileInputStream = new FileInputStream("src/test/resource/config.properties");
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (IOException e) {
			System.out.println("Failed to load config.properties file");
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}
