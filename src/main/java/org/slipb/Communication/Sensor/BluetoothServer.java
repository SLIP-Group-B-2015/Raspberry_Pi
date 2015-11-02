package org.slipb.Communication.Sensor;

/**
 * Created by Marshall Bradley (marshallbradley93@gmail.com)
 * ---
 * TODO: Description
 */

import org.slipb.Internal.Event.Event;
import org.slipb.Internal.Event.EventType;
import org.slipb.Internal.ID.RaspberryID;
import org.slipb.Main;

import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;
import java.io.DataInputStream;
import java.util.Date;


public class BluetoothServer extends Thread {

    private final String url;
    private Event event;
    private DataInputStream inputStream;

    public BluetoothServer(RaspberryID raspberryID) {
        UUID uuid = new UUID(raspberryID.toShortString(), true);
        this.url = "btspp://localhost:" +
                uuid + ";" +
                "name=SmartDoor;" +
                "authenticate=false;" +
                "encrypt=false;";
    }

    public void run() {

        try {
            LocalDevice.getLocalDevice().setDiscoverable(DiscoveryAgent.GIAC);
            StreamConnectionNotifier server = (StreamConnectionNotifier) Connector.open(url);
            StreamConnection connection = server.acceptAndOpen();
            inputStream = new DataInputStream(connection.openInputStream());
            if (Main.DEBUG) {
                System.out.println("Bluetooth client connected");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Event listen() {

        try {

            while (true) {
                int eventCode = inputStream.read();
                Date time = new Date();

                if (eventCode == EventType.KNOCK_CODE) {
                    event = new Event(EventType.KNOCK, time);
                    break;
                } else if (eventCode == EventType.MAIL_CODE) {
                    event = new Event(EventType.MAIL, time);
                    break;
                } else if (eventCode == EventType.OPEN_CODE) {
                    event = new Event(EventType.OPEN, time);
                    break;
                } else if (eventCode == EventType.CLOSE_CODE) {
                    event = new Event(EventType.CLOSE, time);
                    break;
                } else {
                    System.err.println("Event code not recognised");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return event;
    }
}
