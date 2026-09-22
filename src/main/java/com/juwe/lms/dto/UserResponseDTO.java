package com.juwe.lms.dto;

import javax.management.relation.Role;

public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private Role role;
    // getters, setters — no password field, ever


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
