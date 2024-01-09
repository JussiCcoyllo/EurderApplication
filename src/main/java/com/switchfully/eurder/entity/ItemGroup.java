package com.switchfully.eurder.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Data

@NoArgsConstructor
@Entity
@Table(name="ITEM_GROUP")
public class ItemGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID")
    private Long id;
    @Column(name = "ID_ITEM")
    private Long idItem;
    @Column(name="ITEM_NAME")
    private String itemName;
    @Column(name="ITEM_PRICE")
    private double itemPrice;
    @Column(name="AMOUNT")
    private Integer amount;
    @Column(name="SHIPPING_DATE")
    private LocalDate shippingDate;

    private static final int SHIPPING_DATE_WAITING_TIME_IN_STOCK = 1;
    private static final int SHIPPING_DATE_WAITING_TIME_NOT_IN_STOCK = 7;

    public ItemGroup(Long id, Long idItem, String itemName, double itemPrice, Integer amount, LocalDate shippingDate) {
        this.id = id;
        this.idItem = idItem;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.amount = amount;
        this.shippingDate = shippingDate;
    }

    public ItemGroup(Long id, String name, Double price, Double price1, Integer amount, LocalDate shippingDate) {
    }
}
