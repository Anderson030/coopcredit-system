package com.riwi.coopcredit.credit_application_service.domain.model;

import com.riwi.coopcredit.credit_application_service.domain.enums.Role;

import java.util.Set;

public class User {

    private Long id;
    private String username;
    private String password;
    private Set<Role> roles;

    public User() {
    }

    public User(Long id, String username, String password, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    // g and s
}
