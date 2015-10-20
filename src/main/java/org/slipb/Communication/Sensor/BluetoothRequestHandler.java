package org.slipb.Communication.Sensor;

import javax.obex.HeaderSet;
import javax.obex.Operation;
import javax.obex.ResponseCodes;
import javax.obex.ServerRequestHandler;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Marshall Bradley (marshallbradley93@gmail.com)
 * ---
 * TODO: Description
 */

public class BluetoothRequestHandler extends ServerRequestHandler {

    public int onPut(Operation op) {
        try {
            HeaderSet hs = op.getReceivedHeaders();
            String name = (String) hs.getHeader(HeaderSet.NAME);
            if (name != null) {
                System.out.println("put name:" + name);
            }

            InputStream is = op.openInputStream();

            StringBuffer buf = new StringBuffer();
            int data;
            while ((data = is.read()) != -1) {
                buf.append((char) data);
            }

            System.out.println("got:" + buf.toString());

            op.close();
            return ResponseCodes.OBEX_HTTP_OK;
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseCodes.OBEX_HTTP_UNAVAILABLE;
        }
    }
}

