package com.switchfully.eurder.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="ITEM")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID")
    private Long id;
    @Column(name="NAME")
    private String name;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="PRICE")
    private Double price;
    @Column(name="STOCK_AMOUNT")
    private Integer stockAmount;

    public Item(Long id, String name, String description, Double price, Integer stockAmount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockAmount = stockAmount;
    }

    public Item(String name, String description, Double price, Integer stockAmount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockAmount = stockAmount;
    }
}
