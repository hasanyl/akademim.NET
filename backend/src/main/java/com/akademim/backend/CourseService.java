package com.akademim.backend;


import com.akademim.backend.dto.UpdateCourseRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    public boolean deleteCourse(Long courseId){
         if(courseRepository.existsById(courseId)){
             courseRepository.deleteById(courseId);
             return true;
         }

         return false;
    }

    public Course updateCourse(Long courseId, UpdateCourseRequest request){
        Optional<Course> courseOptional = courseRepository.findById(courseId);

        if(courseOptional.isPresent()){
            Course course = courseOptional.get();
            course.setCourseName(request.getCourseName());
            course.setCourseTeacher(request.getCourseTeacher());
            Course savedCourse = courseRepository.save(course);
            return savedCourse;
        }

        return null;
    }

}
