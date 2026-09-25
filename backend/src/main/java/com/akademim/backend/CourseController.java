package com.akademim.backend;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/courses")
@RestController
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }




    @GetMapping
    public List<Course> getCourses(){

        return courseService.getCourses();
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@Valid @RequestBody Course course){

        Course createdCourse = courseService.addCourse(course);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdCourse);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId){
        boolean isDeleted = courseService.deleteCourse(courseId);

        if(isDeleted){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long courseId, @Valid @RequestBody Course updatedCourse){

        Course course = courseService.updateCourse(courseId, updatedCourse);

        if(course == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(course);
    }

}
