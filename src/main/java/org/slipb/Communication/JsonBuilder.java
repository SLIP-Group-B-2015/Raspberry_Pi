package org.slipb.Communication;

import org.slipb.Internal.Event;
import org.slipb.Internal.ID.PiID;

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
    private static final String PIID = "pi";
    private static final String USERID = "user";

    private JsonObject json;

    public JsonBuilder(Event event, PiID piID) {

        if (event.getUserID() != null) {
            json = Json.createObjectBuilder()
                    .add(EVENT, event.getEventType().name())
                    .add(TIME, event.getTime().toString())
                    .add(PIID, piID.toString())
                    .add(USERID, event.getUserID().toString())
                    .build();
        } else {
            json = Json.createObjectBuilder()
                    .add(EVENT, event.getEventType().name())
                    .add(TIME, event.getTime().toString())
                    .add(PIID, piID.toString())
                    .build();
        }
    }

    public String getString() {
        return json.toString();
    }
}
