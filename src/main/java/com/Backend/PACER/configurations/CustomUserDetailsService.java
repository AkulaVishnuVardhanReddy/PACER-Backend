package com.Backend.PACER.configurations;

import java.util.Collection;
import java.util.Collections;

import com.Backend.PACER.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Backend.PACER.entities.Role;
import com.Backend.PACER.entities.User;
import com.Backend.PACER.repositories.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userService.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User Not Found with username "+username));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities((user.getRole()))
        );
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Role role){
        return Collections.singleton(new SimpleGrantedAuthority(role.getName()));
    }

}