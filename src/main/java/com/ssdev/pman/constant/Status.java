package com.ssdev.pman.constant;

public enum Status {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    DRAFT("Draft"),
    DELETED("Deleted");

    private final String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
