package org.slipb.Internal.Event;

/**
 * Created by Marshall Bradley (marshallbradley93@gmail.com)
 *
 * Enum for the various types of event that can occur and corresponding event codes
 */

public enum EventType {
    CLOSE, OPEN, KNOCK, MAIL, ID_SCAN;

    public static final int CLOSE_CODE = 0;
    public static final int OPEN_CODE = 1;
    public static final int KNOCK_CODE = 2;
    public static final int MAIL_CODE = 3;
    public static final int ID_SCAN_CODE = 4;
}
