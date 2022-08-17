package com.dh.courseservice.service;

import com.dh.courseservice.model.dto.CourseDto;

public interface ICourseService {
    public CourseDto findById(Integer id);
}
