package com.dh.courseservice.controller;

import com.dh.courseservice.model.dto.CourseDto;
import com.dh.courseservice.model.dto.SubscriptionDto;
import com.dh.courseservice.repository.ICourseRepository;
import com.dh.courseservice.service.ICourseService;
import com.dh.courseservice.service.ISubscriptionFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@RestController
@RequestMapping("/courses")
public class CourseRestController {
    @Qualifier("courseService")
    private final ICourseService courseService;
    private final ISubscriptionFeignClient subscriptionFeignClient;
    private final ICourseRepository courseRepository;
    @Value("${server.port}")
    private int serverPort;

    @Autowired
    public CourseRestController(ICourseService subscriptionService, ISubscriptionFeignClient subscriptionFeignClient, ICourseRepository courseRepository) {
        this.courseService = subscriptionService;
        this.subscriptionFeignClient = subscriptionFeignClient;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> authenticateUserAndThenFindById(@PathVariable Integer id, @RequestHeader("userId") Integer userId, HttpServletResponse response) {
        response.addHeader("port", String.valueOf(serverPort));

        ResponseEntity<SubscriptionDto> userSubscription = subscriptionFeignClient.findByUserId(userId);

        System.out.println("Puerto utilizado para conectarnos a subscription-service: " + userSubscription.getHeaders().get("port"));

        SubscriptionDto subscriptionDto = userSubscription.getBody();
        CourseDto courseDto;

        if (Objects.nonNull(subscriptionDto)) {
            String startOfSubscription = subscriptionDto.getStartDate();
            String endOfSubscription = subscriptionDto.getEndDate();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm");
            LocalDateTime endOfSubscriptionEncoded = LocalDateTime.parse(endOfSubscription, formatter);
            LocalDateTime startOfSubscriptionEncoded = LocalDateTime.parse(startOfSubscription, formatter);

            if (startOfSubscriptionEncoded.isBefore(LocalDateTime.now()) && endOfSubscriptionEncoded.isAfter(LocalDateTime.now())) {
                courseDto = courseService.findById(id);
                courseDto.setSubscription(subscriptionDto);
                return new ResponseEntity<>(courseDto, HttpStatus.OK);
            } else return new ResponseEntity<>("La subscripción del usuarie ha finalizadx", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("No existe una subscripción para este usuarie", HttpStatus.BAD_REQUEST);
    }
}
