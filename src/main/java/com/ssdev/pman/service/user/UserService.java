package com.ssdev.pman.service.user;

import com.ssdev.pman.model.user.User;
import com.ssdev.pman.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return getList(null);
    }

    public List<User> getUser(String userName) {
        return getList(userName);
    }

    private List<User> getList(String userName) {
        if(userName == null) {
            return userRepository.findAllByOrderByIdAsc();
        }
        User user = userRepository.findUserByUserName(userName);
        return user != null ? List.of(user) : new ArrayList<>();
    }
}
