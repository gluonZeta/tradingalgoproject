package gluon.projects.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesUtilTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getPropertiesByFileName() {
        Properties properties = PropertiesUtil.getPropertiesByFileName("application.ppt");
        assertNull(properties);
    }

    @Test()
    void testConstructorThrowsException() {
        Exception exception = Assertions.assertThrows(IllegalStateException.class, PropertiesUtil::new);
        Assertions.assertEquals("Utility class", exception.getMessage());
    }
}