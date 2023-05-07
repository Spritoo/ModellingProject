package com.UniProject.Training.Advisor.Controllers;

import com.UniProject.Training.Advisor.Services.CourseService;
import com.UniProject.Training.Advisor.dtos.CourseDTO;
import com.UniProject.Training.Advisor.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/")
    public void addCourse(@RequestBody CourseDTO courseDTO) {
        courseService.addCourse(courseDTO);
    }

    @PostMapping("/{courseId}/register")
    public void registerCourse(@PathVariable Long courseId, @RequestBody UserDTO userDTO) {
        courseService.registerCourse(courseId, userDTO);
    }
}