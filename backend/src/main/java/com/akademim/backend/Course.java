package com.akademim.backend;


import jakarta.validation.constraints.NotBlank;

public class Course {
    private Long courseId;
    //NotBlank yapısında "", null veya "    " kabul edilmez.
    @NotBlank
    private String courseName;
    @NotBlank
    private String courseTeacher;

    public Course(Long courseId, String courseName, String courseTeacher){
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
    }

    //Getters

    public Long getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    //Setters

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }
}
