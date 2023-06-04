package hr.tvz.sirac.studapp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository{
    void delete(Optional<Student> student);
    List<Student> findAll();
    Optional<Student> findStudentByJMBAG(String JMBAG);
    void save(Student student);
}