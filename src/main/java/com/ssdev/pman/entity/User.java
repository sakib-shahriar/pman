package com.ssdev.pman.entity;

import com.ssdev.pman.constant.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
public class User extends BaseModel {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String userName;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @NotNull
    @Column(nullable = false)
    private Role role;

}
