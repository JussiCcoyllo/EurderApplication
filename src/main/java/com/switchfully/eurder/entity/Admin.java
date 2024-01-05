package com.switchfully.eurder.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name="ADMIN")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID")
    private Long id;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PASSWORD")
    private String password;

}
