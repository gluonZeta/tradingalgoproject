package gluon.projects.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    PropertiesUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static Properties getPropertiesByFileName(String fileName) {
        Properties properties = new Properties();

        InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);

        if(inputStream == null) {
            properties = null;
        } else {
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                logger.info(e.getMessage());
                properties = null;
                Thread.currentThread().interrupt();
            }
        }

        return properties;
    }

}
