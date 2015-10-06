package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Marshall on 06/10/2015.
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

    public static Id getSourceId(String fileLocation) {

        long idLong = 0;
        try {
            Scanner in = new Scanner(new FileReader(fileLocation));
            if (in.hasNextLong()) {
                idLong = in.nextLong();
            } else {
                System.err.println("Source id file not of expected format");
                System.exit(-1);
            }
        } catch (FileNotFoundException e) {
            System.err.println("No source id file found");
            System.exit(-1);
        }

        if (idLong <= 0) {
            System.err.println("Source id must be strictly greater than zero");
            System.exit(-1);
        }

        Id id = new Id(idLong);
        return id;
    }
}
