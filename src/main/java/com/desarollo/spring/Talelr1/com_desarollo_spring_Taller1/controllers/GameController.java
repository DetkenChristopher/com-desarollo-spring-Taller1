package com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.controllers;

import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.models.Games;
import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.service.CategoryGameService;
import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.stream.Collectors;

@Controller
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    CategoryGameService categoryGameService;

    @GetMapping("/")
    public String home(Model model, Authentication authentication){
        //rol de usuario

        String role=authentication.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.joining(","));

        model.addAttribute("role", role);
        model.addAttribute("Games", gameService.getAllGames());
        return "Games/home";
    }

    @GetMapping("/add-game")
    public String getFormProduct(@ModelAttribute Games games, Model model){
        model.addAttribute("Games", new Games());
        model.addAttribute("GameCategories", categoryGameService.getAllCategories());
        return "Games/add-game";
    }

    @PostMapping("/add-game")
    public String addGame(@ModelAttribute Games games){
        gameService.saveGame(games);
        return "redirect:/";
    }

    @GetMapping("/Games/edit/{id}")
    public String getFormProductEdit(@PathVariable Long id, Model model){
        Games games = gameService.getGameById(id).orElseThrow();
        model.addAttribute("Games", games);
        model.addAttribute("GameCategories", categoryGameService.getAllCategories());
        return "Games/edit-game";
    }

    @PostMapping("/Games/edit/{id}")
    public String updateGame(@PathVariable Long id, @ModelAttribute Games games){
        games.setId(id);
        gameService.saveGame(games);
        return "redirect:/";
    }

    @PostMapping("/Games/delete/{id}")
    public String deleteGame(@PathVariable Long id){
        gameService.deleteGame(id);
        return "redirect:/";
    }


}
