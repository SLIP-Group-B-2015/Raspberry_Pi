package org.slipb.Internal.ID;

import java.util.UUID;

/**
 * Created by Marshall Bradley (marshallbradley93@gmail.com)
 *
 * Sub class for IDs assigned to Users
 */
public class UserID extends ID {

    public UserID(UUID uuid) {
        super(uuid);
    }

    public UserID(String uuidString) {
        super(uuidString);
    }
}
