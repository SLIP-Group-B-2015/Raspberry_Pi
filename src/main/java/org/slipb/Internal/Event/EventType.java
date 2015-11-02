package org.slipb.Internal.Event;

/**
 * Created by Marshall Bradley (marshallbradley93@gmail.com)
 *
 * Enum for the various types of event that can occur
 */

public enum EventType {
    KNOCK, MAIL, ID_SCAN, OPEN, CLOSE;

    public static final int KNOCK_CODE = 100;
    public static final int MAIL_CODE = 101;
    public static final int OPEN_CODE = 1;
    public static final int CLOSE_CODE = 0;
}
