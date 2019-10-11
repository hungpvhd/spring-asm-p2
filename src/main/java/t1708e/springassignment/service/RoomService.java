package t1708e.springassignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t1708e.springassignment.entity.Room;
import t1708e.springassignment.entity.Student;
import t1708e.springassignment.repository.RoomRepository;

import java.util.List;
@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public List<Room> getAll(){
        return roomRepository.findAll();
    }

    public Room getById(int id) {
        return roomRepository.findById(id).orElse(null);
    }
}
