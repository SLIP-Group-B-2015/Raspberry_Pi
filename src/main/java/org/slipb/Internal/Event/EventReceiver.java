package org.slipb.Internal.Event;

import org.slipb.Communication.Sensor.BluetoothServer;
import org.slipb.Internal.ID.RaspberryID;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;

/**
 * Created by Marshall Bradley (marshallbradley93@gmail.com)
 *
 * Receives door events and builds them into internal events
 */

public class EventReceiver {

    private Event event;
    private Boolean running = false;
    private BluetoothServer bluetoothServer;

    public Event receive(RaspberryID raspberryID) {
        if (!running) {
            bluetoothServer = new BluetoothServer(raspberryID);
            bluetoothServer.run();
            running = true;
        }

        event = bluetoothServer.listen();

        return event;
    }
}
