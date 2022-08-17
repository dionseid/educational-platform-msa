package com.dh.courseservice.model;

import com.dh.courseservice.model.dto.SubscriptionDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "chapters")
@Getter
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String urlStreaming;
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @JsonIgnore // ❓ Por qué esta anotación?
        // Quizás porque cuando retornemos un curso como respuesta,
        // va a ser redundante volverlo a mostrar como atributo de sus capítulos
        // ❗ Pero si tengo un DTO no voy a retornar esta clase como respuesta
    private Course course;
}
