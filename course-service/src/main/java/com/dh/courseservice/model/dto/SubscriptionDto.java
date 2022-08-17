package com.dh.courseservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // ❓ Cuál es la utilidad de esta anotación para este caso?
// ❓ Realmente necesito un SubscriptionDto del lado del cliente, si ya le tengo del lado del servidor?
public class SubscriptionDto {
    private Integer id;
    private String startDate;
    private String endDate;
    private String plan;
}
