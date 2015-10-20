package org.slipb.Communication.Sensor;

/**
 * Created by Marshall Bradley (marshallbradley93@gmail.com)
 * ---
 * TODO: Description
 */

import org.slipb.Internal.ID.RaspberryID;

import java.io.IOException;

import javax.bluetooth.*;
import javax.microedition.io.Connector;
import javax.obex.*;

public class BluetoothServer {

    private static RaspberryID raspberryID;

    public BluetoothServer(RaspberryID raspberryID) {
        this.raspberryID = raspberryID;
    }

    public void run() throws IOException {
        LocalDevice.getLocalDevice().setDiscoverable(DiscoveryAgent.GIAC);

        SessionNotifier serverConnection = (SessionNotifier) Connector.open("btgoep://localhost:"
                + raspberryID.toString() + ";name=SmartDoor");

        int count = 0;
        while(count < 2) {
            BluetoothRequestHandler handler = new BluetoothRequestHandler();
            serverConnection.acceptAndOpen(handler);
            System.out.println("Received Bluetooth connection " + (++count));
        }
    }
}
