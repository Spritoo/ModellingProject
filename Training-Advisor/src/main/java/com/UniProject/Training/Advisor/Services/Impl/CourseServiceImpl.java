package com.UniProject.Training.Advisor.Services.Impl;

import com.UniProject.Training.Advisor.Models.Course;
import com.UniProject.Training.Advisor.Models.User;
import com.UniProject.Training.Advisor.Repositories.CourseRepository;
import com.UniProject.Training.Advisor.Repositories.UserRepository;
import com.UniProject.Training.Advisor.Services.CourseService;
import com.UniProject.Training.Advisor.dtos.CourseDTO;
import com.UniProject.Training.Advisor.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setDescription(courseDTO.getDescription());
        courseRepository.save(course);
    }

    @Override
    public void registerCourse(Long courseId, UserDTO userDTO) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        User user = userRepository.findByUsername(userDTO.getUsername());
        course.getStudents().add(user);
        courseRepository.save(course);
    }
}