package com.demo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * @author Vishal.Limbani
 *
 */
public class PropertiesCache {

	private static final Logger log = Logger.getLogger(PropertiesCache.class);
	private final Properties configProp = new Properties();

	private PropertiesCache() {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.properties");
		log.info(in);
		log.info("Read all properties from file");
		try {
			configProp.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class LazyHolder {
		private static final PropertiesCache INSTANCE = new PropertiesCache();
	}

	public static PropertiesCache getInstance() {
		return LazyHolder.INSTANCE;
	}

	public String getProperty(String key) {
		return configProp.getProperty(key);
	}

	public Set<String> getAllPropertyNames() {
		return configProp.stringPropertyNames();
	}

	public boolean containsKey(String key) {
		return configProp.containsKey(key);
	}

}
