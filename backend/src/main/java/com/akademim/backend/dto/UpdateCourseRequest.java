package com.akademim.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class UpdateCourseRequest {
    @NotBlank(message = "Ders adı boş olamaz")
    private String courseName;
    @NotBlank(message = "Öğretmen adı boş olamaz")
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
