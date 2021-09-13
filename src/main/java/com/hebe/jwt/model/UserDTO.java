package com.hebe.jwt.model;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String password;
    private String provider;
}
