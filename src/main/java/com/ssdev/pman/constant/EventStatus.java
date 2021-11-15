package com.ssdev.pman.constant;

public enum EventStatus {
    RUNNABLE("Runnable"),
    COMPLETED("Completed"),
    DISCARDED("Discarded");

    private final String name;

    EventStatus(String name) {
        this.name = name;
    }

    public String getName(String name) {
        return this.name;
    }
}
