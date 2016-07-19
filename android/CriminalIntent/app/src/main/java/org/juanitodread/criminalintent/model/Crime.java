package org.juanitodread.criminalintent.model;

import java.util.UUID;

/**
 * Created by juanitodread on 7/19/16.
 */
public class Crime {
    private UUID id;
    private String title;

    public Crime() {
        this.setId(UUID.randomUUID());
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
