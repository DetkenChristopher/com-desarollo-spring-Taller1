package com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.service;

import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.models.Role;
import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.models.User;
import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.repository.RoleRepository;
import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public User save(User user){

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));


        //rol de usuario

        Role userRole=roleRepository.findByName("ROLE_USER")
                .orElseGet(()-> {
                    Role newRole= new Role();
                    newRole.setName("ROLE_USER");
                    return roleRepository.save(newRole);


                });
        user.getRoles().add(userRole);
        return this.userRepository.save(user);

    }
}
