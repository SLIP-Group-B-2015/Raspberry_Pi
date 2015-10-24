package org.slipb.Internal.Event;

import org.slipb.Communication.Sensor.BluetoothServer;
import org.slipb.Internal.ID.RaspberryID;
import org.slipb.Internal.ID.UserID;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Marshall Bradley (marshallbradley93@gmail.com)
 *
 * Receives door events and builds them into internal events
 */

public class EventReceiver {

    private static final UserID DUMMY_ID = new UserID(UUID.randomUUID());
    private static Event event;

    public static Event receive(RaspberryID raspberryID) {

        BluetoothServer bluetoothServer = new BluetoothServer(raspberryID);
        bluetoothServer.run();

        EventType eventType = EventType.ID_SCAN;
        Date time = new Date();

        if (eventType == EventType.ID_SCAN) {
            UserID userID = DUMMY_ID;
            event = new Event(eventType, time, userID);
        } else {
            event = new Event(eventType, time);
        }

        return event;
    }
}
