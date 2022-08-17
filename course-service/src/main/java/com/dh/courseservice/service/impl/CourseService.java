package com.dh.courseservice.service.impl;

import com.dh.courseservice.model.Course;
import com.dh.courseservice.model.dto.CourseDto;
import com.dh.courseservice.repository.ICourseRepository;
import com.dh.courseservice.service.ICourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("courseService")
public class CourseService implements ICourseService {
    private final ICourseRepository courseRepository;

    @Autowired
    public CourseService(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDto findById(Integer id) {
        ModelMapper modelMapper = new ModelMapper();
        Course courseToFind = courseRepository.findById(id).orElse(null);
        CourseDto courseToReturn = modelMapper.map(courseToFind, CourseDto.class);
        courseToReturn.setId(courseToFind.getId());
        courseToReturn.setName(courseToFind.getName());
        courseToReturn.setChapters(courseToFind.getChapters());
        return courseToReturn;
    }
}
