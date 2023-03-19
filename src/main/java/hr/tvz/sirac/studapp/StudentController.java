package hr.tvz.sirac.studapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> students = studentService.findAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/students/{JMBAG}")
    public ResponseEntity<StudentDTO> getStudentByJMBAG(@PathVariable String JMBAG) {
        StudentDTO student = studentService.findStudentByJMBAG(JMBAG);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
}
