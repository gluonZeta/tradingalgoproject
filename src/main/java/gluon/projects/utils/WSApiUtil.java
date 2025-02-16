package gluon.projects.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WSApiUtil {

    private static Logger logger = LoggerFactory.getLogger(WSApiUtil.class);

    private WSApiUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static String getDataFrom(String completeUrl) {
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .uri(URI.create(completeUrl))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> httpResponse = null;

        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            logger.info(e.getMessage());
            Thread.currentThread().interrupt();
        }
        return httpResponse.body();
    }

}
