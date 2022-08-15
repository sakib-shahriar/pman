package com.ssdev.pman.dto.response;

import lombok.Getter;

@Getter
public class AuthenticationResponse {
    private final String jwt;
    private final String userName;

    public AuthenticationResponse(String jwt, String userName) {
        this.jwt = jwt;
        this.userName = userName;
    }
}
