package com.ssdev.pman.service;

import com.ssdev.pman.dto.response.UserResponse;
import com.ssdev.pman.entity.User;
import com.ssdev.pman.repository.UserRepository;
import com.ssdev.pman.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;

    @Autowired
    public UserService(UserRepository userRepository, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
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
        List<UserResponse> list = userResponse != null ? List.of(userResponse) : new ArrayList<>();
        return new ResponseEntity<List<UserResponse>>(list, HttpStatus.OK);
    }

    public ResponseEntity<List<UserResponse>> saveUser(User user) {
        validationUtil.validateUser(user);
        user = userRepository.save(user);
        return getUser(user.getUserName());
    }
}
