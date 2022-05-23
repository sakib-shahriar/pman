package com.ssdev.pman.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Role {
    ADMIN("Admin"),
    MANAGER("Manager"),
    STANDARD("Standard");

    private final String name;

    public String getName() {
        return this.name;
    }
}
