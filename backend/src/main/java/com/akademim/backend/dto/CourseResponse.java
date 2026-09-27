package com.akademim.backend.dto;

public class CourseResponse {

    private Long courseId;
    private String courseName;
    private String courseTeacher;

    public CourseResponse(Long courseId, String courseName, String courseTeacher){
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
    }

    //getters
    public Long getCourseId(){
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }
}
