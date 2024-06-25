package com.dipeshcodes.SpringSecurityDemo.service;

import com.dipeshcodes.SpringSecurityDemo.model.User;
import com.dipeshcodes.SpringSecurityDemo.model.UserPriniciple;
import com.dipeshcodes.SpringSecurityDemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUsername(username);
        return new UserPriniciple(user);
    }
}
