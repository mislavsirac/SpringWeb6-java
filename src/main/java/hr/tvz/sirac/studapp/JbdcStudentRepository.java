package hr.tvz.sirac.studapp;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Repository
@Primary
public class JbdcStudentRepository implements StudentRepository {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    @Autowired
    public JbdcStudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("student")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public void delete(Optional<Student> studentOptional) {
        studentOptional.ifPresent(student -> {
            String sql = "DELETE FROM student WHERE jmbag = ?";
            jdbcTemplate.update(sql, student.getJMBAG());
        });
    }

    @Override
    public List<Student> findAll() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    @Override
    public Optional<Student> findStudentByJMBAG(String JMBAG) {
        String sql = "SELECT * FROM student WHERE jmbag = ?";
        List<Student> students = jdbcTemplate.query(sql, new Object[]{JMBAG}, new StudentRowMapper());
        return students.isEmpty() ? Optional.empty() : Optional.of(students.get(0));
    }

    @Override
    public void save(Student student) {
        if (student.getId() == null) {
            // Insert new student
            Number studentId = jdbcInsert.executeAndReturnKey(createStudentMap(student));
            student.setId(studentId.longValue());
        } else {
            // Update existing student
            String sql = "UPDATE student SET name = ?, last_name = ?, jmbag = ?, ects = ?, date_of_birth = ? WHERE id = ?";
            jdbcTemplate.update(sql, student.getName(), student.getLastName(), student.getJMBAG(), student.getECTS(),
                    student.getBirthDate(), student.getId());
        }
    }


    private Map<String, Object> createStudentMap(Student student) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", student.getName());
        map.put("last_name", student.getLastName());
        map.put("jmbag", student.getJMBAG());
        map.put("ects", student.getECTS());
        map.put("birth_date", student.getBirthDate());
        return map;
    }



    @PostConstruct
    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS student (id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), last_name VARCHAR(255), jmbag VARCHAR(10), ects INT, birth_date DATE)";

        jdbcTemplate.update(sql);
    }


    private static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setName(rs.getString("name"));
            student.setLastName(rs.getString("last_name"));
            student.setJMBAG(rs.getString("jmbag"));
            student.setECTS(rs.getInt("ects"));
            student.setBirthDate(rs.getDate("birth_date"));
            return student;
        }
    }
}
