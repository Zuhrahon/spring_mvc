package uz.pdp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import uz.pdp.entity.Student;
import uz.pdp.repositorhy.StudentReporistiary;

import javax.swing.tree.RowMapper;
import java.util.List;

//@Repository
public class StudentRepositoryImpl implements StudentReporistiary {

    //bazaga ulanish xosil qilib beradigan
    JdbcTemplate jdbcTemplate;

    public StudentRepositoryImpl(DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int create(Student student) {
        try {
            return jdbcTemplate.update("insert into student(name,email,course) values (?,?,?)",
                    student.getName(), student.getEmail(), student.getCourse());

        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<Student> read() {
        return jdbcTemplate.query("select * from student", BeanPropertyRowMapper.newInstance(Student.class));
    }

    @Override
    public List<Student> findStudentById(int studentId) {
        return null;
    }

    @Override
    public int update(Student student) {
        return 0;
    }

    @Override
    public int dalete(int student) {
        return 0;
    }

    @Override
    public int delete(int studentId) {
        return 0;
    }
}