package org.slipb.Internal;

import org.slipb.Internal.ID.UserID;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Marshall on 06/10/2015.
 */

public class EventReceiver {

    private static final UserID DUMMY_ID = new UserID(UUID.randomUUID());

    public static Event receive() {

        Event event;
        // TODO: Using dummy inputs now
        EventType eventType = EventType.ID_SCAN;
        Date time = new Date();

        if (eventType == EventType.ID_SCAN) {
            UserID userID = DUMMY_ID;
            event = new Event(eventType, time, userID);
        } else {
            event = new Event(eventType, time);
        }

        return event;
    }
}
