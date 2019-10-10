package t1708e.springassignment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import t1708e.springassignment.entity.Student;
import t1708e.springassignment.repository.StudentRepository;
import t1708e.springassignment.service.StudentService;

public class MyUserDetailService implements UserDetailsService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentRepository.findById(email).orElse(null);
        if (student == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        //System.out.println(account.getRoles().stream().map(x -> x.getName()).toArray());
        UserDetails user =
                User.builder()
                        .username(student.getEmail())
                        .password(student.getPassword())
                        .roles("")
                        .build();
        return user;
    }
}
