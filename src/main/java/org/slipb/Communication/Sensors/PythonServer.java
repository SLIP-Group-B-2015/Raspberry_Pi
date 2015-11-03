package org.slipb.Communication.Sensors;

import org.slipb.Internal.Event.Event;

import java.io.*;
import java.net.*;

/**
 * Created by Marshall Bradley (marshallbradley93@gmail.com)
 * ---
 * TODO: Description
 */

public class PythonServer {

    private static final int PORT = 12000;

    private Event event;
    private ServerSocket server;
    private Socket client;
    private BufferedReader in;

    public PythonServer() {
        try {
            server = new ServerSocket(PORT);
            client = server.accept();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Event listen() {
        try {
            while (true) {
                in = new BufferedReader((new InputStreamReader(client.getInputStream())));
                String eventString = in.readLine();
                JsonParser jsonParser = new JsonParser(eventString);
                jsonParser.parse();
                event = jsonParser.getEvent();
                if (event != null) {
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return event;
    }
}
