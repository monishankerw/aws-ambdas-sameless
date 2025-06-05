package com.lambda.service.impl;

import com.lambda.dto.Course;
import com.lambda.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    // Simulating a database with an in-memory list
    private final List<Course> courseList = new ArrayList<>();
    private int currentId = 1; // To simulate auto-increment IDs

    @Override
    public Course addCourse(Course course) {
        course.setId(currentId++);
        courseList.add(course);
        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        return new ArrayList<>(courseList); // Return a copy to prevent modification
    }

    @Override
    public Optional<Course> getCourseById(int id) {
        return courseList.stream()
                .filter(course -> course.getId() == id)
                .findFirst();
    }

    @Override
    public Optional<Course> updateCourse(int id, Course newCourse) {
        return getCourseById(id).map(existingCourse -> {
            existingCourse.setName(newCourse.getName());
            existingCourse.setDescription(newCourse.getDescription());
            return existingCourse;
        });
    }

    @Override
    public boolean deleteCourse(int id) {
        return courseList.removeIf(course -> course.getId() == id);
    }
}