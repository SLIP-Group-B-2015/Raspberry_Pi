package org.slipb.Communication.Sensor;

/**
 * Created by Marshall Bradley (marshallbradley93@gmail.com)
 * ---
 * TODO: Description
 */

import org.slipb.Internal.ID.RaspberryID;
import org.slipb.Main;

import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;
import java.io.DataInputStream;


public class BluetoothServer {

    private final String url;

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
            DataInputStream inputStream = new DataInputStream(connection.openInputStream());
            if (Main.DEBUG) {
                System.out.println("Bluetooth client connected");
            }

            while (true) {
                System.out.print(inputStream.read());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
