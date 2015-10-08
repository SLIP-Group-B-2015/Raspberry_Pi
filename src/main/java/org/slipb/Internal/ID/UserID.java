package org.slipb.Internal.ID;

import java.util.UUID;

/**
 * Created by Marshall on 08/10/2015.
 */
public class UserID {
    private static UUID uuid;

    public UserID(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public String toString() {return this.uuid.toString();}
}
