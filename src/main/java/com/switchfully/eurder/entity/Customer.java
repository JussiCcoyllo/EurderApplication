package com.switchfully.eurder.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID")
    private Long id;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;
    @Column(name="ADDRESS")
    private String address;

}
