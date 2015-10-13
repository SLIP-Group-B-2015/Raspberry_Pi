package org.slipb.Internal.ID;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.UUID;

/**
 * Created by Marshall Bradley (marshallbradley93@gmail.com)
 *
 * Sub class for IDs assigned to Pis
 */
public class RaspberryID extends ID {

    public RaspberryID(UUID uuid) {
        super(uuid);
    }

    public RaspberryID(String uuidString) {
        super(uuidString);
    }

    public static RaspberryID readPiID(String fileLocation) throws FileNotFoundException {

        String uuidString;
        Scanner in = new Scanner(new FileReader(fileLocation));

        uuidString = in.next();
        RaspberryID raspberryID = new RaspberryID(uuidString);

        return raspberryID;
    }
}
