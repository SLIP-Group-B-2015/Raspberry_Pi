package org.slipb.Internal;

import java.util.Date;

/**
 * Created by Marshall on 06/10/2015.
 */

public class EventReceiver {

    private static final Id DUMMY_ID = new Id(33011);

    public static Event receive() {

        Event event;
        // TODO: Using dummy inputs now
        EventType eventType = EventType.ID_SCAN;
        Date time = new Date();

        if (eventType == EventType.ID_SCAN) {
            Id id = DUMMY_ID;
            event = new Event(eventType, time, id);
        } else {
            event = new Event(eventType, time);
        }

        return event;
    }
}
