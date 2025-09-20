package com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.service;


import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.models.Games;
import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public Games saveGame(Games games){
        return gameRepository.save(games);
    }

    public List<Games> getAllGames(){
        return gameRepository.findAll();
    }

    public Optional<Games> getGameById(Long id){
        return gameRepository.findById(id);
    }

    public void deleteGame(Long id){
        gameRepository.deleteById(id);
    }
}
