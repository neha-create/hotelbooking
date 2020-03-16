package com.hotelbooking.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class MessageBundles {

	private static final Logger logger = LoggerFactory.getLogger(MessageBundles.class);

	private static final Properties appMessages = new Properties();

	private static final String MSG_PROP_FILE = "classpath:/bundles/application_messages.properties";

	private static final String ERR_FILE_LOAD_FAILED = "Unable to load application_messages.properties file.";

	static {
		// CLEAR PROPERTIES
		appMessages.clear();

		loadApplicationMessages();

	}

	public static void loadApplicationMessages() {

		if (logger.isDebugEnabled()) {
			logger.debug("Executing loadApplicationMessages() ->");
		}

		try {
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			Resource resource = resolver.getResource(MSG_PROP_FILE);
			appMessages.load(resource.getInputStream());
		} catch (IOException ex) {
			logger.error(ERR_FILE_LOAD_FAILED);
			throw new RuntimeException(ERR_FILE_LOAD_FAILED, ex);
		}
	}

	public static String getMessage(String propertyName) {
		String str = appMessages.getProperty(propertyName);
		if (Utils.isEmpty(str)) {
			logger.error(propertyName + " - Property Not Found");
		}
		return str;
	}
}
