package com.cloudera.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class AppTestPropertyUtil {

	private static final Logger logger = Logger.getLogger(AppTestPropertyUtil.class);
	
	private static final String resource = "/app.properties";

	private Properties properties;

	public AppTestPropertyUtil() {
		try (InputStream inStream = this.getClass().getResourceAsStream(resource)) {
			Properties tmp = new Properties();

			tmp.load(inStream);

			properties = tmp;
		} catch (IOException e) {
			throw new RuntimeException("Unable to load application properties");
		}
	}

	public String getProperty(String name) {
		String result = properties.getProperty(name);
		logger.info("Looked up property [" + name + "] and found [" + result + "]");
		return result;
	}

}
