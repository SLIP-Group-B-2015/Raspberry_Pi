package com.company;

public class Main {

    private static final Boolean DEBUG = true;
    private static final String FILE_LOCATION = "C:/source.id";

    private static Id sourceId;

    public static void main(String[] args) {

        // Set Raspberry Pi's unique id
        sourceId = Id.getSourceId(FILE_LOCATION);

        if (DEBUG) {
            System.out.println("Source id set to " + sourceId.getLong());
        }

        while (true) {
            break;
        }
    }
}
