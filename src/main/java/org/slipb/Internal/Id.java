package org.slipb.Internal;

import org.slipb.Exceptions.InvalidIdException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Marshall on 06/10/2015.
 *
 * Class that represents various types of ID (source and personal ID)
 */

public class Id {
    private long id;

    public Id(long id) {
        this.id = id;
    }

    public Id getId() {
        return this;
    }

    public long getLong() {
        return this.id;
    }

    public static Id getSourceId(String fileLocation) throws FileNotFoundException, InvalidIdException {

        long idLong;
        Scanner in = new Scanner(new FileReader(fileLocation));

        if (in.hasNextLong()) {
            idLong = in.nextLong();
        } else { // Valid IDs must be longs
            throw new InvalidIdException();
        }

        if (idLong <= 0) { // Valid IDs must be strictly greater than zero
            throw new InvalidIdException();
        }

        Id id = new Id(idLong);
        return id;
    }
}
