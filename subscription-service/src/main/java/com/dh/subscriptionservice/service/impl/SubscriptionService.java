package com.dh.subscriptionservice.service.impl;

import com.dh.subscriptionservice.model.Plan;
import com.dh.subscriptionservice.model.Subscription;
import com.dh.subscriptionservice.model.dto.SubscriptionDto;
import com.dh.subscriptionservice.repository.IPlanRepository;
import com.dh.subscriptionservice.repository.ISubscriptionRepository;
import com.dh.subscriptionservice.service.ISubscriptionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("subscriptionService")
public class SubscriptionService implements ISubscriptionService {
    private final ISubscriptionRepository subscriptionRepository;
    private final IPlanRepository planRepository;

    @Autowired
    public SubscriptionService(ISubscriptionRepository subscriptionRepository, IPlanRepository planRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.planRepository = planRepository;
    }

    @Override
    public SubscriptionDto findByUserId(Integer id) {
        ModelMapper modelMapper = new ModelMapper();
        Subscription subscriptionToFind = subscriptionRepository.findByUserId(id);
        SubscriptionDto subscriptionToReturn = modelMapper.map(subscriptionToFind, SubscriptionDto.class);
        subscriptionToReturn.setId(subscriptionToFind.getId());
        subscriptionToReturn.setStartDate(subscriptionToReturn.formatDateTimeIntoString(subscriptionToFind.getStartDate()));
        subscriptionToReturn.setEndDate(subscriptionToReturn.formatDateTimeIntoString(subscriptionToFind.getEndDate()));
        Integer planId = subscriptionToFind.getPlan().getId();
        Plan subscriptionPlan = planRepository.findById(planId).get();
        subscriptionToReturn.setPlan(subscriptionPlan.getName());
        return subscriptionToReturn;
    }
}
