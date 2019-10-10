package t1708e.springassignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t1708e.springassignment.entity.Student;
import t1708e.springassignment.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public String login(String email, String password){
        Optional<Student> optionalStudent = studentRepository.findByEmailAndPassword(email, password);
        return "";
    }

    public Student create(Student student){
        return studentRepository.save(student);
    }

    public List<Student> students() {
        return studentRepository.findAll();
    }

    public Student getById(String id){
        return studentRepository.findById(id).orElse(null);
    }
}
