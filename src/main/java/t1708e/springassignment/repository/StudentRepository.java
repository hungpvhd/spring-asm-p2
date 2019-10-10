package t1708e.springassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t1708e.springassignment.entity.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {
    Optional<Student> findByEmailAndPassword(String email, String password);
}
