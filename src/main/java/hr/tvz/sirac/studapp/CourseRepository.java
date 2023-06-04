package hr.tvz.sirac.studapp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository{
    List<Course> findByStudentsJMBAG(String jmbag);

    List<Course> findAll();
}
