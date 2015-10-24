package org.slipb.Communication.Server;

import org.slipb.Internal.Event.Event;
import org.slipb.Internal.ID.RaspberryID;

import javax.json.Json;
import javax.json.JsonObject;

/**
 * Created by Marshall Bradley (marshallbradley93@gmail.com)
 *
 * This class builds the JSON to be sent to the server
 */

public class JsonBuilder {

    private static final String EVENT = "event";
    private static final String TIME = "time";
    private static final String RASPBERRY_ID = "raspberry";
    private static final String USER_ID = "user";
    private static final String NOTE = "note";

    private JsonObject json;

    public JsonBuilder(Event event, RaspberryID raspberryID) {

        if (event.getUserID() != null && event.getNote() != null) { // user event with note
            json = Json.createObjectBuilder()
                    .add(EVENT, event.getEventType().name())
                    .add(TIME, event.getTime().toString())
                    .add(RASPBERRY_ID, raspberryID.toString())
                    .add(USER_ID, event.getUserID().toString())
                    .add(NOTE, event.getNote())
                    .build();

        } else if (event.getUserID() != null) { // user event without note
            json = Json.createObjectBuilder()
                    .add(EVENT, event.getEventType().name())
                    .add(TIME, event.getTime().toString())
                    .add(RASPBERRY_ID, raspberryID.toString())
                    .add(USER_ID, event.getUserID().toString())
                    .build();
        } else { // non user event
            json = Json.createObjectBuilder()
                    .add(EVENT, event.getEventType().name())
                    .add(TIME, event.getTime().toString())
                    .add(RASPBERRY_ID, raspberryID.toString())
                    .build();
        }
    }

    public String getString() {return json.toString();}
}
