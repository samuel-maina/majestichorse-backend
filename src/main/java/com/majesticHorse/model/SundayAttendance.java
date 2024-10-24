package com.majesticHorse.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author samuel
 */
@Entity
public class SundayAttendance {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private LocalDate sundayDate;
    @ManyToMany(mappedBy="attendance")
    private List<Congregant> congregants;
    
     @ManyToMany(mappedBy="attendance")
    private List<Visitor> Visitors;

    public List<Visitor> getVisitors() {
        return Visitors;
    }

    public void setVisitors(List<Visitor> Visitors) {
        this.Visitors = Visitors;
    }
     
     

    public long getId() {
        return id;
    }

  
    public LocalDate getSundayDate() {
        return sundayDate;
    }

    public void setSundayDate(LocalDate sundayDate) {
        this.sundayDate = sundayDate;
    }

    public List<Congregant> getCongregants() {
        return congregants;
    }

    public void setCongregants(List<Congregant> congregants) {
        this.congregants = congregants;
    }
    
    
}
