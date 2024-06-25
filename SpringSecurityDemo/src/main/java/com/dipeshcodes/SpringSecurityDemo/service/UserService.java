package com.dipeshcodes.SpringSecurityDemo.service;

import com.dipeshcodes.SpringSecurityDemo.model.User;
import com.dipeshcodes.SpringSecurityDemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    BCryptPasswordEncoder bcrypt= new BCryptPasswordEncoder(12);

    public User registerUser(User user){
        user.setPassword(bcrypt.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
