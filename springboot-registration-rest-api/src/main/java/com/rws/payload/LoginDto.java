package com.rws.payload;

import lombok.Data;

@Data
public class LoginDto {
    private String UsernameOrEmail;
    private String Password;
}
