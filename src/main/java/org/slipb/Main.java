package org.slipb;

import org.slipb.Communication.Server.JsonBuilder;
import org.slipb.Communication.Server.HttpSender;
import org.slipb.Internal.Event.Event;
import org.slipb.Internal.Event.EventReceiver;
import org.slipb.Internal.ID.RaspberryID;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static final Boolean DEBUG = true;
    private static final String FILE_LOCATION = "/home/pi/Desktop/source.id"; //"C:/source.id";
<<<<<<< HEAD
    private static final String DEFAULT_URL = "http://193.62.81.88:5000/";
=======
    private static final String DEFAULT_URL = "http://193.62.81.88:5000";
>>>>>>> 83c5e826acd725c496df928ee93e1af6a9fb658c

    private static String serverUrl;
    private static RaspberryID raspberryID;

    public static void main(String[] args) {

        // Set serverUrl
        if (args.length > 0) {
            serverUrl = args[0];
        } else {
            serverUrl = DEFAULT_URL;
            System.err.println("No server URL specified, reverting to default: " + DEFAULT_URL);
        }

        // Set Raspberry Pi's unique id
        try {
            raspberryID = RaspberryID.readPiID(FILE_LOCATION);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        if (DEBUG) {
            System.out.println("Source ID set to " + raspberryID.toString());
        }

        HttpSender httpSender = new HttpSender(serverUrl);
        EventReceiver eventReceiver = new EventReceiver();

        // Enter main loop
        while (true) {
            try {
                Event latestEvent = eventReceiver.receive(raspberryID);
                if (DEBUG) {
                    System.out.println("Received event");
                }

                String json = new JsonBuilder(latestEvent, raspberryID).getString();
                if (DEBUG) {
                    System.out.println("Posting JSON: " + json + " to server");
                }

                boolean success = httpSender.send(json);
                if (DEBUG && success) {
                    System.out.println("HTTP Post succeeded");
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
