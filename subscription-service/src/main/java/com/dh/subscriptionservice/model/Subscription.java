package com.dh.subscriptionservice.model;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "subscriptions")
@Getter
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //strategy = GenerationType.AUTO
    private Integer id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @ManyToOne //(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // ❓ Qué tipo de cascade me conviene?
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Integer userId;
}
