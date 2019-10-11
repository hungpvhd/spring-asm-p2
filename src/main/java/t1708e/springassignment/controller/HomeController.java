package t1708e.springassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t1708e.springassignment.entity.Room;
import t1708e.springassignment.entity.Student;
import t1708e.springassignment.repository.StudentRepository;
import t1708e.springassignment.service.RoomService;
import t1708e.springassignment.service.StudentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/", "/home"})
public class HomeController {
    @Autowired
    StudentService studentService;

    @Autowired
    RoomService roomService;

    @Autowired
    StudentRepository studentRepository;
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login() {
        return "login";
    }




    @GetMapping
    public String index(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Student student = studentService.getByEmail(name);
        List<Room> roomList = roomService.getAll();
        model.addAttribute("student", student);
        model.addAttribute("room", roomList);
        return "index";
    }
}
