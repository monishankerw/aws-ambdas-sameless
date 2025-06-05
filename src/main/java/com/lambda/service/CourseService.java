package com.lambda.service;

import com.lambda.dto.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course addCourse(Course course);
    List<Course> getAllCourses();
    Optional<Course> getCourseById(int id);
    Optional<Course> updateCourse(int id, Course newCourse);
    boolean deleteCourse(int id);
}