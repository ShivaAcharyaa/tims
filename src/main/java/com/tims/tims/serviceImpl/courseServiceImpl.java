package com.tims.tims.serviceImpl;

import com.tims.tims.model.Course;
import com.tims.tims.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class courseServiceImpl implements CourseService {
@Autowired
    private CourseService courseService;
    @Autowired
    private com.tims.tims.repository.courseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {

        return courseRepository.findAll();
    }

    @Override
    public Boolean deleteCourse(Integer id) {
        Course course = courseRepository.findById(id).orElse(null);

        if (course != null) {
            courseRepository.delete(course);
            return true;
        }
        return false;
    }

    @Override
    public Course getCourseById(Integer id) {
        Course course = courseRepository.findById(id).orElse(null);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        Course dbCourse = getCourseById(course.getId());
        if(dbCourse != null) {
            dbCourse.setTitle(course.getTitle());
            dbCourse.setCoach(course.getCoach());
            dbCourse.setPrice(course.getPrice());
            dbCourse.setDiscount(course.getDiscount());
            return courseRepository.save(dbCourse);
        }
        return null;
    }
}
