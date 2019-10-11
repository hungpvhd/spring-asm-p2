package t1708e.springassignment.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    @Email
    @NotNull(message = "Không được bỏ trống email")
    private String email;
    @NotNull(message = "Không được bỏ trống mã sinh viên")
    @Length(min = 7, message = "Mã sinh viên phải trên 7 ký tự")
    private String rollNumber;
    @NotNull(message = "Không được bỏ trống tên")
    private String name;
    @NotNull(message = "Không được bỏ trống mật khẩu")
    private String password;
    private int status;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "studentSet")
    private Set<Room> roomSet;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<Room> getRoomSet() {
        return roomSet;
    }

    public void setRoomSet(Set<Room> roomSet) {
        this.roomSet = roomSet;
    }
    public void addRoom(Room room) {
        if (this.roomSet == null) {
            this.roomSet = new HashSet<>();
        }
        this.roomSet.add(room);
    }
}
