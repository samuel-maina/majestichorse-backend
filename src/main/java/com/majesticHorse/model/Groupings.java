/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.majesticHorse.model;

import java.io.Serializable;
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
@Entity(name="COG_GROUPS")
public class Groupings implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String groupName;
    private String description;
    @ManyToMany(mappedBy="groups")
    private List<Congregant> congregants;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Congregant> getCongregants() {
        return congregants;
    }

    public void setCongregants(List<Congregant> congregants) {
        this.congregants = congregants;
    }

    public Long getId() {
        return id;
    }
    
    
    
    
}
