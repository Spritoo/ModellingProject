package com.UniProject.Training.Advisor.Services;

import com.UniProject.Training.Advisor.dtos.CourseDTO;
import com.UniProject.Training.Advisor.dtos.UserDTO;

public interface CourseService {

    void addCourse(CourseDTO courseDTO);

    void registerCourse(Long courseId, UserDTO userDTO);
}