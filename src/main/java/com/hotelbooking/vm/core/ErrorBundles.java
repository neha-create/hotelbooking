package com.hotelbooking.vm.core;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class ErrorBundles {

    private static final Logger logger = LoggerFactory.getLogger(ErrorBundles.class);

    private static final Properties appErrors = new Properties();

    private static final String ERR_PROP_FILE = "classpath:/bundles/application_errors.properties";

    private static final String ERR_FILE_LOAD_FAILED =
                    "Unable to load application_errors.properties file.";

    static {
        // CLEAR PROPERTIES
        appErrors.clear();

        loadApplicationErrors();

    }

    public static void loadApplicationErrors() {

        try {
            PathMatchingResourcePatternResolver resolver =
                            new PathMatchingResourcePatternResolver();
            Resource resource = resolver.getResource(ERR_PROP_FILE);
            appErrors.load(resource.getInputStream());
        } catch (IOException ex) {
            logger.error(ERR_FILE_LOAD_FAILED);
            throw new RuntimeException(ERR_FILE_LOAD_FAILED, ex);
        }
    }

    public static String getProperty(String propertyName) {
        return appErrors.getProperty(propertyName);
    }
}
