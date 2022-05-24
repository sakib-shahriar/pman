package com.ssdev.pman.util;

import com.ssdev.pman.execption.ApiException;
import com.ssdev.pman.model.User;
import com.ssdev.pman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtil {
    @Autowired
    private UserRepository userRepository;

    public void validateUser(User user) {
        if(userRepository.countAllByEmail(user.getEmail()) > 0) {
            throw new ApiException("This email already exist");
        }
        if(userRepository.countAllByUserName(user.getUserName()) > 0) {
            throw new ApiException("This username already exist");
        }
    }
}
