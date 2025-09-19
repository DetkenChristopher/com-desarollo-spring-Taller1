package com.desarollo.spring.Talelr1.com_desarollo_spring_Taller1.models;

import jakarta.persistence.*;

@Entity(name = "Games")
public class Games {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String GameName;
    private String price;
    private String stock;
    private String description;


    @ManyToOne()
    @JoinColumn(name = "Caregory_id", nullable = false)
    private GameCategory gameCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameName() {
        return GameName;
    }

    public void setGameName(String gameName) {
        GameName = gameName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GameCategory getGameCategory() {
        return gameCategory;
    }

    public void setGameCategory(GameCategory gameCategory) {
        this.gameCategory = gameCategory;
    }
}
