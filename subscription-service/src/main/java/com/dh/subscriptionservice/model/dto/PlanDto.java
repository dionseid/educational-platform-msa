package com.dh.subscriptionservice.model.dto;

import lombok.Data;

@Data
public class PlanDto {
    private Integer id;
    private String name;
    private Double price;
}
