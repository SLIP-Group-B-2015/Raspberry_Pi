package org.slipb.Communication.Sensors;

import org.slipb.Internal.Event.Event;
import org.slipb.Internal.Event.EventType;
import org.slipb.Internal.ID.UserID;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;
import java.util.Date;

/**
 * Created by Marshall Bradley (marshallbradley93@gmail.com)
 * ---
 * TODO: Description
 */

public class JsonParser {

    private static final String CODE = "code";
    private static final String USER = "user";
    private static final String NOTE = "note";

    private Event event;
    private String eventString;

    public JsonParser(String eventString) {
        event = null;
        this.eventString = eventString;
    }

    public void parse() {
        if (eventString != null) {
            JsonObject jsonObject = Json.createReader(new StringReader(eventString)).readObject();
            int eventCode = jsonObject.getInt(CODE);
            Date time = new Date();

            if (eventCode == EventType.ID_SCAN_CODE) {
                UserID userId = new UserID(jsonObject.getString(USER));

                if (!jsonObject.isNull(NOTE)) {
                    event = new Event(EventType.ID_SCAN, time, userId, jsonObject.getString(NOTE));
                } else {
                    event = new Event(EventType.ID_SCAN, time, userId);
                }

            } else {
                if (eventCode == EventType.CLOSE_CODE) {
                    event = new Event(EventType.CLOSE, time);
                } else if (eventCode == EventType.OPEN_CODE) {
                    event = new Event(EventType.OPEN, time);
                } else if (eventCode == EventType.KNOCK_CODE) {
                    event = new Event(EventType.KNOCK, time);
                } else if (eventCode == EventType.MAIL_CODE) {
                    event = new Event(EventType.MAIL, time);
                } else {
                    System.err.println("Event code not recognised");
                }
            }
        }
    }

    public Event getEvent() {
        return this.event;
    }
}
