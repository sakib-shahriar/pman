package com.ssdev.pman.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {
    private String userName;
    private String password;

    public AuthenticationRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
