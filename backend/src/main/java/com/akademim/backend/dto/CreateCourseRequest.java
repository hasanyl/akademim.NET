package com.akademim.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateCourseRequest {
    @NotBlank
    private String courseName;
    @NotBlank
    private String courseTeacher;

    //Getters
    public String getCourseName(){
        return courseName;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    //Setters
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }
}
