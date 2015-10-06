package com.company;

import java.util.Date;

/**
 * Created by Marshall on 06/10/2015.
 */
public class Event {

    private EventType eventType;
    private Date time;
    private Id id;

    public Event(EventType eventType, Date time){
        this.eventType = eventType;
        this.time = time;
    }

    public Event(EventType eventType, Date time, Id id){
        this.eventType = eventType;
        this.time = time;
        this.id = id;
    }

    public EventType getEventType() {
        return this.eventType;
    }

    public Date getTime() {
        return this.time;
    }

    public Id getId() {
        return this.id;
    }
}
