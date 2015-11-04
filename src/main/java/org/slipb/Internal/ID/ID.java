package org.slipb.Internal.ID;

import java.util.UUID;

/**
 * Created by Marshall Bradley (marshallbradley93@gmail.com)
 *
 * Base class for different types of ID assigned to Pi/Users
 */

public abstract class ID {

    private static final int SHORT_LENGTH = 8;

    private UUID uuid;

    public ID(UUID uuid) {
        this.uuid = uuid;
    }

    public ID(String uuidString) {
        this.uuid = UUID.fromString(uuidString);
    }

    public String toString() {
        return this.uuid.toString();
    }

    public String toShortString() {
        return this.uuid.toString().substring(0, SHORT_LENGTH);
    }

}
