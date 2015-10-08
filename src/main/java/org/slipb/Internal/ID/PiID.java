package org.slipb.Internal.ID;

import org.slipb.Exceptions.InvalidIDException;

import java.io.FileNotFoundException;
import java.util.UUID;

/**
 * Created by Marshall on 08/10/2015.
 */
public class PiID {
    private static UUID uuid;

    public PiID(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public String toString() {return this.uuid.toString();}

    public static PiID readPiID(String fileLocation) throws FileNotFoundException, InvalidIDException {
        return(new PiID(UUID.randomUUID()));
    }
}
/*   public static Id getSourceId(String fileLocation) throws FileNotFoundException, InvalidIDException {

        long idLong;
        Scanner in = new Scanner(new FileReader(fileLocation));

        if (in.hasNextLong()) {
            idLong = in.nextLong();
        } else { // Valid IDs must be longs
            throw new InvalidIDException();
        }

        if (idLong <= 0) { // Valid IDs must be strictly greater than zero
            throw new InvalidIDException();
        }

        Id id = new Id(idLong);
        return id;
    } */
