package gluon.projects.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Properties;

class WSApiUtilTest {

    private String apiBinanceUrl;

    @BeforeEach
    void setUp() {
        Properties properties = PropertiesUtil.getPropertiesByFileName("application.properties");
        this.apiBinanceUrl = properties.getProperty("apibinanceurl");
    }

    @Test
    void getDataFrom() {
        Assertions.assertNotNull(this.apiBinanceUrl);
        Assertions.assertNotEquals("", this.apiBinanceUrl);

        String pingTestUrl = this.apiBinanceUrl + "/ping";
        String resultPingTest = WSApiUtil.getDataFrom(pingTestUrl);

        Assertions.assertNotNull(resultPingTest);
        Assertions.assertEquals("{}", resultPingTest);

    }
}