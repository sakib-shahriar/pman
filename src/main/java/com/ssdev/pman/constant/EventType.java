package com.ssdev.pman.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EventType {
    SEND_EMAIL("Send Email");
    private final String name;
}
