package com.rws.nitin.spring.service;

import com.rws.nitin.spring.model.User;
import com.rws.nitin.spring.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
