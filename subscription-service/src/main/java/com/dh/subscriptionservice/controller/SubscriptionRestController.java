package com.dh.subscriptionservice.controller;

import com.dh.subscriptionservice.model.dto.SubscriptionDto;
import com.dh.subscriptionservice.service.ISubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/subscription")
public class SubscriptionRestController {
    @Qualifier("subscriptionService")
    private final ISubscriptionService subscriptionService;
    @Value("${server.port}")
    private int serverPort;

    @Autowired
    public SubscriptionRestController(ISubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/find")
    public ResponseEntity<SubscriptionDto> findByUserId(@RequestParam Integer userId, HttpServletResponse response) {
        response.addHeader("port", String.valueOf(serverPort));
        return new ResponseEntity<>(subscriptionService.findByUserId(userId), HttpStatus.OK);
    }
}
