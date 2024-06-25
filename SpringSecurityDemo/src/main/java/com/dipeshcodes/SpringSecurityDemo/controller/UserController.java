package com.dipeshcodes.SpringSecurityDemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String dashboard(HttpServletRequest req){
        System.out.println(req.getSession().getId());
        return "Hello World the session id is: "+req.getSession().getId();
    }


}
