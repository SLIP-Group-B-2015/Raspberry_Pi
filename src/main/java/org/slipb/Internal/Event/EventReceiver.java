package org.slipb.Internal.Event;

import org.slipb.Communication.Sensors.PythonServer;


/**
 * Created by Marshall Bradley (marshallbradley93@gmail.com)
 *
 * Receives door events and builds them into internal events
 */

public class EventReceiver {

    private Event event;
    private boolean running = false;
    private PythonServer pythonServer;

    public Event receive() {
        while (!running) {
            pythonServer = new PythonServer();
            running = true;
        }

        event = pythonServer.listen();

        return event;
    }
}
