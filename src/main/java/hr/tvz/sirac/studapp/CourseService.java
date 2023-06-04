package hr.tvz.sirac.studapp;

import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    List<Course> getCoursesByStudentJMBAG(String jmbag);
}

