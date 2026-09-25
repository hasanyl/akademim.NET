package com.akademim.backend;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private final List<Course> courses = new ArrayList<>();
    private Long nexId = 4L;

    public CourseService(){
        Course course = new Course(1L, "Matematik", "Abdullah Bakır");
        Course course1 = new Course(2L, "Fizik", "Esra Arslan");
        Course course2 = new Course(3L, "Algoritma ve Programlama 2", "Ercan Ezin");

        courses.add(course);
        courses.add(course1);
        courses.add(course2);
    }

    public List<Course> getCourses(){
        return courses;
    }

    public Course addCourse(Course course){
        course.setCourseId(nexId);
        nexId++;

        courses.add(course);
        return course;
    }

    public boolean deleteCourse(Long courseId){
        return courses.removeIf(course -> courseId.equals(course.getCourseId()));
    }

    public Course updateCourse(Long courseId, Course updatedCourse){
        for(Course course : courses) {
            if (courseId.equals(course.getCourseId())) {
                course.setCourseName(updatedCourse.getCourseName());
                course.setCourseTeacher(updatedCourse.getCourseTeacher());

                return course;
            }
        }

        return null;
    }

}
