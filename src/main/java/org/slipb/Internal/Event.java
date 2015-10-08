package org.slipb.Internal;

import org.slipb.Internal.ID.UserID;

import java.util.Date;

/**
 * Created by Marshall on 06/10/2015.
 *
 * Class to internally represent events
 */

public class Event {

    private EventType eventType;
    private Date time;
    private UserID userID;

    public Event(EventType eventType, Date time){
        this.eventType = eventType;
        this.time = time;
    }

    public Event(EventType eventType, Date time, UserID userID){
        this.eventType = eventType;
        this.time = time;
        this.userID = userID;
    }

    public EventType getEventType() {
        return this.eventType;
    }

    public Date getTime() {
        return this.time;
    }

    public UserID getUserID() {
        return this.userID;
    }
}
