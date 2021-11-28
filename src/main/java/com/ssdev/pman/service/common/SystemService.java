package com.ssdev.pman.service.common;

import com.ssdev.pman.constant.Role;
import com.ssdev.pman.model.user.User;
import com.ssdev.pman.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SystemService {
    @Autowired
    private UserRepository userRepository;

    public void initializeUser() {
        User user = new User();
        user.setUserName("sakib");
        user.setPassword(new BCryptPasswordEncoder().encode("123456"));
        user.setRole(Role.ADMIN);
        user.setEmail("skbshariar@gmail.com");
        userRepository.save(user);
    }
}
