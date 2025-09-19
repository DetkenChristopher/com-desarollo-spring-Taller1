package com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.service;

import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.models.Role;
import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.models.User;
import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceimplements implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Usuario no encontrado"));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map((Role item) -> new SimpleGrantedAuthority(item.getName()))
                        .toList()
        );
    }
}
