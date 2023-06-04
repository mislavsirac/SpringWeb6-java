package hr.tvz.sirac.studapp;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {
    List<Student> findAll();
    Optional<Student> findStudentByJMBAG(String JMBAG);

    boolean isJMBAGAlreadyInUse(String jmbag);

    void addStudent(Student student);

    void deleteStudentByJMBAG(String jmbag);
}
