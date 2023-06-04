package hr.tvz.sirac.studapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class JdbcCourseRepository implements CourseRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcCourseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Course> findByStudentsJMBAG(String jmbag) {
        String sql = "SELECT c.* FROM course c JOIN student_course sc ON c.id = sc.course_id JOIN student s ON sc.student_id = s.id WHERE s.jmbag = ?";
        return jdbcTemplate.query(sql, new Object[]{jmbag}, new CourseRowMapper());
    }

    @Override
    public List<Course> findAll() {
        String sql = "SELECT * FROM course";
        return jdbcTemplate.query(sql, new CourseRowMapper());
    }


    private static class CourseRowMapper implements RowMapper<Course> {
        @Override
        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
            Course course = new Course();
            course.setId(rs.getLong("id"));
            course.setName(rs.getString("name"));
            course.setEcts(rs.getInt("ects"));
            return course;
        }
    }
}
