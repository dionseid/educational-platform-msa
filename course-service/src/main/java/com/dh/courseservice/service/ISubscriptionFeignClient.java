package com.dh.courseservice.service;

import com.dh.courseservice.config.FeignConfiguration;
import com.dh.courseservice.model.dto.SubscriptionDto;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "subscription-service")
@LoadBalancerClient(name = "subscription-service", configuration = FeignConfiguration.class)
public interface ISubscriptionFeignClient {
    @GetMapping("/subscription/find")
    ResponseEntity<SubscriptionDto> findByUserId(@RequestParam Integer userId);
}
