package com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.repository;

import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
