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
public class Congregant {

    private String firstName;
    private String lastName;
    private String homeAddress;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long mId;
    private String phone;
    
    @OneToMany(mappedBy = "cog", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Contributions> contributions;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "congregant_groups",
            joinColumns = @JoinColumn(name = "mId"),
            inverseJoinColumns = @JoinColumn(name = "id"),
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"mId", "id"})}
    )
    private List<Groupings> groups;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "member_attendance",
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

    public List<Groupings> getGroups() {
        return groups;
    }

    public void setGroups(List<Groupings> groups) {
        this.groups = groups;
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

    public List<Contributions> getContributions() {
        return contributions;
    }

    public void setContributions(List<Contributions> contributions) {
        this.contributions = contributions;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
    }
    
    

}
