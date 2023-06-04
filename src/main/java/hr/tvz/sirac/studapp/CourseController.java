package hr.tvz.sirac.studapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        List<CourseDTO> courseDTOs = courses.stream()
                .map(course -> new CourseDTO(course.getId(), course.getName(), course.getEcts()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(courseDTOs, HttpStatus.OK);
    }

    @GetMapping("/students/{jmbag}")
    public ResponseEntity<List<CourseDTO>> getCoursesByStudentJMBAG(@PathVariable String jmbag) {
        List<Course> courses = courseService.getCoursesByStudentJMBAG(jmbag);
        List<CourseDTO> courseDTOs = courses.stream()
                .map(course -> new CourseDTO(course.getId(), course.getName(), course.getEcts()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(courseDTOs, HttpStatus.OK);
    }
}