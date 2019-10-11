package t1708e.springassignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import t1708e.springassignment.entity.Student;
import t1708e.springassignment.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Student create(Student student) {
        student.setStatus(1);
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(int id) {
        return studentRepository.findById(id).orElse(null);
    }
    public Student getByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}
