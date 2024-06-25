package com.dipeshcodes.SpringSecurityDemo.controller;

import com.dipeshcodes.SpringSecurityDemo.model.User;
import com.dipeshcodes.SpringSecurityDemo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String dashboard(HttpServletRequest req){
        System.out.println(req.getSession().getId());
        return "Hello World the session id is: "+req.getSession().getId();
    }

    @GetMapping("/csrf-token")
    public CsrfToken generateCsrfToken(HttpServletRequest req){
        return (CsrfToken) req.getAttribute("_csrf");
    }

    @PostMapping("/register")
    public String addUser(@RequestBody User user){
        User addedUser = userService.registerUser(user);
        return "user added: "+addedUser;
    }


}
