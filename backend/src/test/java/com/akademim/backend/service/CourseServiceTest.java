package com.akademim.backend.service;



import com.akademim.backend.entity.Course;
import com.akademim.backend.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {
    @Mock
    private CourseRepository courseRepository;
    @InjectMocks
    private CourseService courseService;

    @Test
    void shouldReturnAllCourses(){
        Course course1 = new Course();
        course1.setCourseId(1L);
        course1.setCourseName("Matematik");
        course1.setCourseTeacher("Abdullah Bakır");

        Course course2 = new Course();
        course1.setCourseId(2L);
        course2.setCourseName("Mikroişlemciler");
        course2.setCourseTeacher("Mehmet Hadi Süzer");

        List<Course> courses = List.of(course1,course2);

        when(courseRepository.findAll())
                .thenReturn(courses);

        List<Course> result = courseService.getCourses();

        assertEquals(2, result.size());
        assertEquals("Matematik", result.get(0).getCourseName());
        assertEquals("Abdullah Bakır", result.get(0).getCourseTeacher());
        assertEquals("Mikroişlemciler", result.get(1).getCourseName());
        assertEquals("Mehmet Hadi Süzer", result.get(1).getCourseTeacher());

        verify(courseRepository).findAll();
    }

    @Test
    void shouldReturnEmptyListWhenNoCourseExist(){
        when(courseRepository.findAll())
                .thenReturn(List.of());

        List<Course> result = courseService.getCourses();

        assertTrue(result.isEmpty());

        verify(courseRepository).findAll();
    }

}
