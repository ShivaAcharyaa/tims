package com.tims.tims.service;

import com.tims.tims.model.Course;

import java.util.List;

public interface CourseService {
    public Course saveCourse(Course course);
    public List<Course> getAllCourses();
    public Boolean deleteCourse(Integer id);
    public Course getCourseById(Integer id);
    public Course updateCourse(Course course);

}
