package com.ssdev.pman.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Entity {
    User("User"),
    Board("Board"),
    Event("Event");

    private final String name;

    public String getName() {
        return this.name;
    }
}
