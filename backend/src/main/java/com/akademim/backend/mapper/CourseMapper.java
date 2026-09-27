package com.akademim.backend.mapper;

import com.akademim.backend.Course;
import com.akademim.backend.dto.CourseResponse;
import com.akademim.backend.dto.CreateCourseRequest;

public class CourseMapper {

    public static CourseResponse toResponse(Course course){
        return new CourseResponse(
                course.getCourseId(),
                course.getCourseName(),
                course.getCourseTeacher()
        );
    }

    public static Course toEntity(CreateCourseRequest request){
        Course course = new Course();

        course.setCourseName(request.getCourseName());
        course.setCourseTeacher(request.getCourseTeacher());

        return course;
    }
}
