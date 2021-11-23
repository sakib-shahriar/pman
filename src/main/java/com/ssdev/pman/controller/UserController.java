package com.ssdev.pman.controller;
import com.ssdev.pman.model.user.User;
import com.ssdev.pman.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers() {
        List<User> userList = userService.getUsers();
        return ResponseEntity.ok(userList);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByUserName(@PathVariable String id) {
        List<User> userList = userService.getUser(id);
        return ResponseEntity.ok(userList);
    }
}
