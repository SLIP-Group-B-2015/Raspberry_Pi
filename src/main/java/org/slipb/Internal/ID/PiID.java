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
public class PiID extends ID {

    public PiID(UUID uuid) {
        super(uuid);
    }

    public PiID(String uuidString) {
        super(uuidString);
    }

    public static PiID readPiID(String fileLocation) throws FileNotFoundException {

        String uuidString;
        Scanner in = new Scanner(new FileReader(fileLocation));

        uuidString = in.next();
        PiID piID = new PiID(uuidString);

        return piID;
    }
}
