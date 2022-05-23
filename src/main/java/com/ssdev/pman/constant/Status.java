package com.ssdev.pman.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    DRAFT("Draft"),
    DELETED("Deleted");

    private final String name;

    public String getName() {
        return this.name;
    }
}
