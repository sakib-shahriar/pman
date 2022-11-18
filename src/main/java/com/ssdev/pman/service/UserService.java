package com.ssdev.pman.service;

import com.ssdev.pman.constant.Entity;
import com.ssdev.pman.dto.response.UserResponse;
import com.ssdev.pman.entity.User;
import com.ssdev.pman.execption.ResourceNotFoundException;
import com.ssdev.pman.repository.UserRepository;
import com.ssdev.pman.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, ValidationUtil validationUtil, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public ResponseEntity<List<UserResponse>> getUsers() {
        return getList(null);
    }

    public ResponseEntity<List<UserResponse>> getUser(String userName) {
        return getList(userName);
    }

    private ResponseEntity<List<UserResponse>> getList(String userName) {
        if(userName == null) {
            return new ResponseEntity<List<UserResponse>>(userRepository.findALlResponse(), HttpStatus.OK);
        }
        UserResponse userResponse = userRepository.findUserByUserNameResponse(userName);
        if (userResponse == null) {
            throw new ResourceNotFoundException(Entity.User);
        }
        return new ResponseEntity<List<UserResponse>>(List.of(userResponse), HttpStatus.OK);
    }

    public ResponseEntity<List<UserResponse>> saveUser(User user) {
        validationUtil.validateUser(user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return getUser(user.getUserName());
    }
}
