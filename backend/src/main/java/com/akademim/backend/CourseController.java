package com.akademim.backend;

import com.akademim.backend.dto.CourseResponse;
import com.akademim.backend.dto.CreateCourseRequest;
import com.akademim.backend.dto.UpdateCourseRequest;
import com.akademim.backend.mapper.CourseMapper;
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
    public List<CourseResponse> getCourses(){
        List<Course> courses = courseService.getCourses();
        List<CourseResponse> responses = new ArrayList<>();

        for(Course course : courses){
            responses.add(CourseMapper.toResponse(course));
        }

        return responses;
    }

    @PostMapping
    public ResponseEntity<CourseResponse> addCourse(@Valid @RequestBody CreateCourseRequest request){

        Course course = CourseMapper.toEntity(request);

        Course createdCourse = courseService.addCourse(course);

        CourseResponse response = CourseMapper.toResponse(createdCourse);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
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
    public ResponseEntity<CourseResponse> updateCourse(@PathVariable Long courseId, @Valid @RequestBody UpdateCourseRequest request){

        Course course = courseService.updateCourse(courseId, request);

        if(course == null){
            return ResponseEntity.notFound().build();
        }

        CourseResponse response = CourseMapper.toResponse(course);

        return ResponseEntity.ok(response);
    }

}
