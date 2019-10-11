package t1708e.springassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import t1708e.springassignment.entity.Room;
import t1708e.springassignment.entity.Student;
import t1708e.springassignment.service.RoomService;
import t1708e.springassignment.service.StudentService;

import java.util.List;

@Controller
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @Autowired
    StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Student> students = studentService.students();
        List<Room> rooms = roomService.rooms();
        model.addAttribute("rooms", rooms);
        model.addAttribute("student", students);
        return "room/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    public String detail(@PathVariable String name, Model model) {
        List<Student> students = studentService.students();
        Room room = roomService.getByName(name);
        if (room == null) {
            return "error/404";
        }
        model.addAttribute("room", room);
        model.addAttribute("student", students);
        return "room/detail";
    }
}
