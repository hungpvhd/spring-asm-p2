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
import t1708e.springassignment.repository.RoomRepository;
import t1708e.springassignment.repository.StudentRepository;
import t1708e.springassignment.service.RoomService;
import t1708e.springassignment.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomService roomService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(@PathVariable int id, Model model) {
        Room room = roomService.getById(id);
        List<Student> studentList = studentService.getAll();
        if (room == null) {
            return "error/404";
        }
        model.addAttribute("studentList", studentList);
        model.addAttribute("room", room);
        return "room/detail";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String addStudent(int[] studentIds, int roomId) {
        List<Integer> intList = new ArrayList<Integer>();
        for (int i : studentIds)
        {
            intList.add(i);
        }
        List<Student> studentList = studentRepository.findAllById(intList);
        Room room = roomService.getById(roomId);
        for (Student student: studentList
        ) {
            room.addStudent(student);
        }
        roomRepository.save(room);
        return "redirect:/room/"+roomId;
    }
}
