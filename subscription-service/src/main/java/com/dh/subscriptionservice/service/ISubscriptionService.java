package com.dh.subscriptionservice.service;

import com.dh.subscriptionservice.model.dto.SubscriptionDto;

public interface ISubscriptionService {
    public SubscriptionDto findByUserId(Integer id);
}
