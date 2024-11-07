package com.security.SpringToken.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String getHomeContent(HttpServletRequest httpServletRequest){
        return "Welcome To Home Page "+ httpServletRequest.getSession().getId();
    }

}
