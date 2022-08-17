package com.dh.subscriptionservice.repository;

import com.dh.subscriptionservice.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISubscriptionRepository extends JpaRepository<Subscription, Integer> {
    Subscription findByUserId(Integer userId);
}
