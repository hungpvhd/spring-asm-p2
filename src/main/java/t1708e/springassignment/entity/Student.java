package t1708e.springassignment.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @NotNull(message = "Description can not be null or empty!")
    @Email(message = "Invalid email")
    private String email;
    @NotNull(message = "Name can not be null or empty!")
    @Size(min = 5, max = 30, message = "Name length must be 5 - 30 characters.")
    private String name;
    @NotNull(message = "Password can not be null or empty!")
    @Size(min = 5, max = 30, message = "Password length must be 5 - 30 characters.")
    private String password;
    @NotNull(message = "RollNumber can not be null or empty!")
    @Size(min = 7, max = 30, message = "RollNumber length must be 7 - 30 characters.")
    private String rollnumber;

    @ManyToMany(mappedBy = "studentSet",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Set<Room> roomSet;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public Set<Room> getRoomSet() {
        return roomSet;
    }

    public void setRoomSet(Set<Room> roomSet) {
        this.roomSet = roomSet;
    }

    public void addRoomSet(Room room) {
        if (this.roomSet == null) {
            this.roomSet = new HashSet<>();
        }
        this.roomSet.add(room);
    }
}
