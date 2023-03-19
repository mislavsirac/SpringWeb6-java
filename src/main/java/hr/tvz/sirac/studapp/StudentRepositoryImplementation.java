package hr.tvz.sirac.studapp;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImplementation implements StudentRepository{
    private List<Student> students = new ArrayList<>();
    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Optional<Student> findStudentByJMBAG(String JMBAG) {
        return students.stream()
                .filter(student -> student.getJMBAG().equals(JMBAG))
                .findFirst();
    }
}
