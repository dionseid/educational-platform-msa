package com.dh.subscriptionservice.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "plans")
@Getter
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //strategy = GenerationType.AUTO
    private Integer id;
    private String name;
    private Double price;
}
