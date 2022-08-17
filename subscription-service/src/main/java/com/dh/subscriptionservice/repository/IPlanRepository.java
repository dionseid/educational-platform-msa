package com.dh.subscriptionservice.repository;

import com.dh.subscriptionservice.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanRepository extends JpaRepository<Plan, Integer> {
}
