package com.dh.subscriptionservice.model.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class SubscriptionDto {
    private Integer id;
    private String startDate;
    private String endDate;
    private String plan;

    public String formatDateTimeIntoString(LocalDateTime dateTimeToFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm");
        return dateTimeToFormat.format(formatter);
    }
}
