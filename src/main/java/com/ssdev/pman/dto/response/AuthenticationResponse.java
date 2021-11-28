package com.ssdev.pman.dto.response;

import lombok.Getter;

@Getter
public class AuthenticationResponse {
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }
}
