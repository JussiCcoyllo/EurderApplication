package com.switchfully.eurder.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EURDER")
public class Eurder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID")
    private Long id;
    @Column(name="ID_CUSTOMER")
    private Long idCustomer;
    @OneToMany(cascade = {CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name="ID_EURDER")
    private List<ItemGroup> itemGroups;
    @Column(name = "TOTAL_PRICE")
    private double totalPrice;
    @Column(name="EURDER_DATE")
    private LocalDate orderDate;


}
