package com.ssdev.pman.controller;
import com.ssdev.pman.dto.response.UserResponse;
import com.ssdev.pman.execption.ApiException;
import com.ssdev.pman.entity.User;
import com.ssdev.pman.service.UserService;
import com.ssdev.pman.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final CommonUtil commonUtil;

    @Autowired
    public UserController(UserService userService, CommonUtil commonUtil) {
        this.userService = userService;
        this.commonUtil = commonUtil;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserResponse>> getUsers() {
       return userService.getUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<UserResponse>> getUserByUserName(@PathVariable String id) {
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<UserResponse>> saveUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        List<String> errorFields = commonUtil.getFieldNamesFromBindingResult(bindingResult);
        if(errorFields.isEmpty()) {
            return userService.saveUser(user);
        }
        throw new ApiException(commonUtil.buildErrorMessage(errorFields));
    }
}
