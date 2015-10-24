package org.slipb.Internal.Event;

import org.slipb.Internal.ID.UserID;

import java.util.Date;

/**
 * Created by Marshall Bradley (marshallbradley93@gmail.com)
 *
 * Class to internally represent events
 */

public class Event {

    private EventType eventType;
    private Date time;
    private UserID userID;
    private String note;

    public Event(EventType eventType, Date time){
        this.eventType = eventType;
        this.time = time;
    }

    public Event(EventType eventType, Date time, UserID userID){
        this.eventType = eventType;
        this.time = time;
        this.userID = userID;
    }

    public Event(EventType eventType, Date time, UserID userID, String note){
        this.eventType = eventType;
        this.time = time;
        this.userID = userID;
        this.note = note;
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

    public String getNote() {
        return this.note;
    }
}
