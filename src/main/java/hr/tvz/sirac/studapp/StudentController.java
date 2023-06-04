package hr.tvz.sirac.studapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @DeleteMapping("/students/{JMBAG}")
    public ResponseEntity<?> deleteStudentByJMBAG(@PathVariable String JMBAG) {
        Optional<Student> studentOptional = studentService.findStudentByJMBAG(JMBAG);
        if (studentOptional.isPresent()) {
            studentService.deleteStudentByJMBAG(JMBAG);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@Valid @RequestBody StudentCommand studentCommand) {
        // Convert StudentCommand to Student
        Student student = new Student(studentCommand.getName(), studentCommand.getLastName(),
                studentCommand.getBirthDate(), studentCommand.getJMBAG(), studentCommand.getECTS());

        // Check for duplicate JMBAG
        if (studentService.isJMBAGAlreadyInUse(student.getJMBAG())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("JMBAG already in use");
        }

        // Add student to repository
        studentService.addStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.findAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/students/{JMBAG}")
    public ResponseEntity<?> getStudentByJMBAG(@PathVariable String JMBAG) {
        Optional<Student> student = studentService.findStudentByJMBAG(JMBAG);
        if (student.isPresent()) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student with JMBAG " + JMBAG + " not found");
        }
    }
}
