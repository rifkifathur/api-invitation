package com.undangan.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.undangan.model.entities.AppUser;
import com.undangan.repositories.AppUserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    AppUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username)
        .orElseThrow(()-> 
        new UsernameNotFoundException(String.format("Unauthorized '%s'", username)));
        return user;
    }
}
