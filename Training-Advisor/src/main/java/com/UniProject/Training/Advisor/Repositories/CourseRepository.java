package com.UniProject.Training.Advisor.Repositories;

import com.UniProject.Training.Advisor.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByTitle(String title);

}
