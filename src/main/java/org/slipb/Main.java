package org.slipb;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slipb.Communication.JsonBuilder;
import org.slipb.Communication.JsonSender;
import org.slipb.Exceptions.InvalidIDException;
import org.slipb.Internal.Event;
import org.slipb.Internal.EventReceiver;
import org.slipb.Internal.ID.PiID;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    private static final Boolean DEBUG = true;
    private static final String FILE_LOCATION = "C:/source.id";
    private static final String SERVER_URL = "http://www.test.com";
    private static final int MAX_ATTEMPTS = 3;
    private static final String POS_RESPONSE = "RECEIVED";
    private static final String NEG_RESPONSE = "NOT RECEIVED";

    private static final String INVALID_ID = "Source ID invalid";
    private static final String HTTP_POST_FAILED = "HTTP POST Request failed, retrying...";
    private static final String MAX_HTTP_POST_FAILED = "HTTP POST Request failed, max attempts reached";

    private static PiID piID;

    public static void main(String[] args) {

        // Set Raspberry Pi's unique id
        try {
            piID = PiID.readPiID(FILE_LOCATION);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (InvalidIDException ex) {
            System.err.println(INVALID_ID);
            System.exit(-1);
        }

        if (DEBUG) {
            System.out.println("Source ID set to " + piID.getUUID().toString());
        }

        JsonSender jsonSender = new JsonSender(SERVER_URL);

        // Enter main loop
        while (true) {

            Event latestEvent = EventReceiver.receive();
            String json = new JsonBuilder(latestEvent, piID).getString();

            if (DEBUG) {
                System.out.println("Posting JSON: " + json + " to server");
            }

            int attempts = 0; // try HTTP request MAX_ATTEMPTS times
            while (true) {

                String responseString = NEG_RESPONSE;
                try {
                    HttpResponse httpResponse = jsonSender.send(json);
                    responseString = EntityUtils.toString(httpResponse.getEntity());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                if (responseString.equals(POS_RESPONSE)) {
                    break;
                } else if (attempts >= MAX_ATTEMPTS - 1) {
                    if (DEBUG) {
                        System.err.println(MAX_HTTP_POST_FAILED);
                    }
                    break;
                } else {
                    if (DEBUG) {
                        System.err.println(HTTP_POST_FAILED);
                    }
                    attempts++;
                }
            }
            break;
        }
    }
}
