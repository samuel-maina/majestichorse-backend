package com.majesticHorse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author samuel
 */
@Entity
public class Visitor {

    private String firstName;
    private String lastName;
    private String homeAddress;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long mId;
    private String phone;
 
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "visitor_attendance",
            joinColumns = @JoinColumn(name = "mId"),
            inverseJoinColumns = @JoinColumn(name = "id"),
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"mId", "id"})}
    )
    private List<SundayAttendance> attendance;

    public List<SundayAttendance> getAttendance() {
        return attendance;
    }

    public void setAttendance(List<SundayAttendance> attendance) {
        this.attendance = attendance;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
    }
    
    

}

