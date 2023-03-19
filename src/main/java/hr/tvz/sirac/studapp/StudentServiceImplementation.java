package hr.tvz.sirac.studapp;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(student -> new StudentDTO(student.getJMBAG(), student.getECTS(), false))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO findStudentByJMBAG(String JMBAG) {
        return studentRepository.findStudentByJMBAG(JMBAG)
                .map(student -> new StudentDTO(student.getJMBAG(), student.getECTS(), false))
                .orElse(null);
    }
}