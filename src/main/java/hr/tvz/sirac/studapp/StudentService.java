package hr.tvz.sirac.studapp;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    List<StudentDTO> findAll();
    StudentDTO findStudentByJMBAG(String JMBAG);
}
