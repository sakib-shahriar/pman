package com.ssdev.pman.constant;

public enum Role {
    ADMIN("Admin"),
    MANAGER("Manager"),
    STANDARD("Standard");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
