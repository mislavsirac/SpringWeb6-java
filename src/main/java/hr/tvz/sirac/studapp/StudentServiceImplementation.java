package hr.tvz.sirac.studapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findStudentByJMBAG(String JMBAG) {
        return studentRepository.findStudentByJMBAG(JMBAG);
    }

    @Override
    public boolean isJMBAGAlreadyInUse(String jmbag) {
        if(studentRepository.findStudentByJMBAG(jmbag).isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentByJMBAG(String jmbag) {
        Optional<Student> student = studentRepository.findStudentByJMBAG(jmbag);
        studentRepository.delete(student);
    }
}