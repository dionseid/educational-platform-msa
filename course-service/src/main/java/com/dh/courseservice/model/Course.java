package com.dh.courseservice.model;

import com.dh.courseservice.model.dto.SubscriptionDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "course") // ❓ Qué funcionalidad tiene mappedBy?
    private List<Chapter> chapters;
//    @Setter
//    @Transient
//    private SubscriptionDto subscription;
}
