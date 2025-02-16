package gluon.projects.utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WSApiUtil {

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
        } catch (IOException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        return httpResponse.body();
    }

}
