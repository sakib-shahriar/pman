package com.ssdev.pman.dto.response;

import com.ssdev.pman.constant.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class UserResponse {
    private String userName;
    private Role role;
    private String email;
}
