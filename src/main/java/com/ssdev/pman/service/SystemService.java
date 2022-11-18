package com.ssdev.pman.service;

import com.ssdev.pman.constant.Role;
import com.ssdev.pman.entity.User;
import com.ssdev.pman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SystemService {
    public UserRepository userRepository;
    public BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public SystemService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void initializeUser() {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setUserName("sakib");
            user.setPassword(bCryptPasswordEncoder.encode("123456"));
            user.setRole(Role.ADMIN);
            user.setEmail("skbshariar@gmail.com");
            userRepository.save(user);
        }
    }
}
