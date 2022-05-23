package com.ssdev.pman.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EventStatus {
    RUNNABLE("Runnable"),
    COMPLETED("Completed"),
    DISCARDED("Discarded");

    private final String name;

    public String getName(String name) {
        return this.name;
    }
}
