package com.tims.tims.repository;

import com.tims.tims.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface courseRepository extends JpaRepository<Course, Integer>{
}
