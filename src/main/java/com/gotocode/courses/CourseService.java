package com.gotocode.courses;

import jakarta.annotation.PostConstruct;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CourseService {

    private static final Logger log = (Logger) LoggerFactory.getLogger(CourseService.class);
    private List<Course> courses = new ArrayList<>();

    //Client
    @Tool(name = "dv_get_courses", description = "Get a list of courses from Dan Vega")
    public List<Course> getCourses() {
        return courses;
    }

    @Tool(name = "dv_get_course", description = "Get a single courses from Dan Vega by title")
    public Course getCourse(String title) {
        return courses.stream().filter(course -> course.title().equals(title)).findFirst().orElse(null);
    }


    @PostConstruct
    public void init() {
        courses.addAll(List.of(
                new Course("Título do vídeo 01", "https://www.urlvideo01"),
                new Course("Título do vídeo 02", "https://www.urlvideo02")
        ));
    }

}
