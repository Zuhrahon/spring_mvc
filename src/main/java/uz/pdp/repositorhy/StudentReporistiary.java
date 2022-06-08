package uz.pdp.repositorhy;

import uz.pdp.entity.Student;

import java.util.List;

public interface StudentReporistiary {
    public  int create (Student student);
    public List<Student>read();
    public List<Student>findStudentById(int studentid);

    public int update(Student student);

    public int dalete (int student);

    int delete(int studentId);
}
