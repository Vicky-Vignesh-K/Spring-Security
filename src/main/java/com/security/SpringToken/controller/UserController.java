package com.security.SpringToken.controller;

import com.security.SpringToken.VO.UserVO;
import com.security.SpringToken.configuration.ResponseStructure;
import com.security.SpringToken.entity.User;
import com.security.SpringToken.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("registerUser")
    public ResponseEntity<ResponseStructure<UserVO>> registerUser(@RequestBody UserVO userVO){
        return userService.registerUser(userVO);
    }

    @PostMapping("login")
    public String login(@RequestBody User user){
        return userService.verifyUser(user);
    }

}
