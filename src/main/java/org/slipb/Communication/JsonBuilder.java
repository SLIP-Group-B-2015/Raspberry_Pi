package org.slipb.Communication;

import org.slipb.Internal.Event;
import org.slipb.Internal.Id;

import javax.json.Json;
import javax.json.JsonObject;

/**
 * Created by Marshall on 05/10/2015.
 *
 * This class builds the JSON to be sent to the server
 */

public class JsonBuilder {

    private static final String EVENT = "event";
    private static final String TIME = "time";
    private static final String SOURCE = "source";
    private static final String ID = "id";

    private JsonObject json;

    public JsonBuilder(Event event, Id sourceId) {

        if (event.getId() != null) {
            json = Json.createObjectBuilder()
                    .add(EVENT, event.getEventType().name())
                    .add(TIME, event.getTime().toString())
                    .add(SOURCE, sourceId.getLong())
                    .add(ID, event.getId().getLong())
                    .build();
        } else {
            json = Json.createObjectBuilder()
                    .add(EVENT, event.getEventType().name())
                    .add(TIME, event.getTime().toString())
                    .add(SOURCE, sourceId.getLong())
                    .build();
        }
    }

    public String getString() {
        return json.toString();
    }
}
