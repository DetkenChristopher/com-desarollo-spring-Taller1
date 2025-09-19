package com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.repository;

import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.models.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Games, Long> {
}
