package com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.service;

import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.models.GameCategory;
import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.repository.GameCategoyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryGameService {

    @Autowired
    GameCategoyRepository gameCategoyRepository;

    public List<GameCategory> getAllCategories(){
        return gameCategoyRepository.findAll();
    }
}
