package com.dh.courseservice.model.dto;

import com.dh.courseservice.model.Chapter;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
public class CourseDto {
    private Integer id;
    private String name;
    private List<Chapter> chapters;
    private SubscriptionDto subscription;
}
