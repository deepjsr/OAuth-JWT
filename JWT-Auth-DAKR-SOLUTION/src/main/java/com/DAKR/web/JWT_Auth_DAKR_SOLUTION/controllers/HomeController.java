package com.DAKR.web.JWT_Auth_DAKR_SOLUTION.controllers;

import com.DAKR.web.JWT_Auth_DAKR_SOLUTION.models.User;
import com.DAKR.web.JWT_Auth_DAKR_SOLUTION.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/home")
public class HomeController {



    @Autowired
    private UserService userService;

    //    http://localhost:8081/home/user
    @GetMapping("/user")
    public List<User> getUser() {
        System.out.println("Getting User...");
        return this.userService.getUsers();
    }


//    http://localhost:8081/home/currentUser

    @GetMapping("/current-user")
    public String getUsers(Principal principal) {
        return principal.getName();
    }
    @ExceptionHandler
            (BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
}
