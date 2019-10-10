package t1708e.springassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t1708e.springassignment.entity.Student;
import t1708e.springassignment.repository.StudentRepository;
import t1708e.springassignment.service.StudentService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login() {
        return "login";
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/login")
//    public String getStudent(Model model, @Valid Student student, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("student", student);
//            return "student/form";
//        }
//        Optional<Student> optionalStudent = studentRepository.findByEmailAndPassword(student.getEmail(), student.getPassword());
//        if (optionalStudent == null){
//            return "student/form";
//        }
//        return "redirect:/students";
//    }
}
