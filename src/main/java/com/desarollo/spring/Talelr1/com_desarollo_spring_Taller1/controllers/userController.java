package com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.controllers;

import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.models.User;
import com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class userController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String getFormRegister(@ModelAttribute User user , Authentication authentication){

        if (authentication!= null && authentication.isAuthenticated()){

            return "redirect:/";
        }
        return "auth/register";

    }


    @PostMapping("/register")
    public RedirectView registerUser(@ModelAttribute User user){
        try {
            this.userService.save(user);
            return new RedirectView("/login");
        }catch (Exception ex){
            return new RedirectView("/register?duplicate");
        }
    }

}
