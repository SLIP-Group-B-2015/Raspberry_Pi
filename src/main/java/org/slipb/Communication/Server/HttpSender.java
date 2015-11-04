package org.slipb.Communication.Server;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slipb.Main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Marshall Bradley (marshallbradley93@gmail.com)
 *
 * This class initiates a HTTP POST request to send the JSON to the server
 */

public class HttpSender {

    private static final String HEADER_NAME = "content-type";
    private static final String HEADER_VALUE = "application/json";
    private static final int MAX_ATTEMPTS = 3;
    private static final String POS_RESPONSE = "True";
    private static final String NEG_RESPONSE = "False";

    private static final String HTTP_POST_FAILED = "HTTP POST Request failed, retrying...";
    private static final String MAX_HTTP_POST_FAILED = "HTTP POST Request failed, max attempts reached";

    private static String destination;

    public HttpSender(String destination) {
        this.destination = destination;
    }

    // returns true if HTTP post succeeds, false otherwise
    public boolean send(String json) {
        int attempts = 0; // try HTTP request MAX_ATTEMPTS times
        while (true) {

            String responseString;

            try {
                HttpResponse httpResponse = postJson(json);
                responseString = EntityUtils.toString(httpResponse.getEntity());
                if (Main.DEBUG) {
                    System.out.println(responseString);
                }
            } catch (IOException ex) {
                responseString = NEG_RESPONSE;
            }

            if (responseString.equals(POS_RESPONSE)) {
                return true;
            } else if (attempts >= MAX_ATTEMPTS - 1) {
                if (Main.DEBUG) {
                    System.err.println(MAX_HTTP_POST_FAILED);
                }
                return false;
            } else {
                if (Main.DEBUG) {
                    System.err.println(HTTP_POST_FAILED);
                }
                attempts++;
            }
        }
    }

    private HttpResponse postJson(String json) throws IOException {
        HttpResponse response = null;
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(destination);
            StringEntity params = new StringEntity(json);
            httpPost.addHeader(HEADER_NAME, HEADER_VALUE);
            httpPost.setEntity(params);
            response = httpClient.execute(httpPost);

        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        return response;
    }
}

