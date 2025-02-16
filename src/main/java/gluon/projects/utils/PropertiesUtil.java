package gluon.projects.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private PropertiesUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static Properties getPropertiesByFileName(String fileName) {
        Properties properties = new Properties();

        try(InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.info(e.getMessage());
            Thread.currentThread().interrupt();
        }

        return properties;
    }

}
