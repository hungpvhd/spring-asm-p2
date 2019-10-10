package t1708e.springassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t1708e.springassignment.entity.Room;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Optional<Room> findByName(String name);
}
