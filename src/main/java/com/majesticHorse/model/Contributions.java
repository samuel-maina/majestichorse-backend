/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.majesticHorse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author samuel
 */
@Entity
public class Contributions {
    
    @Id
    private String Id;
    @ManyToOne
    
    private Congregant cog;
    
    private LocalDate inserted;
    
    private int amount;
    
    @ManyToOne
    @JsonIgnore
    private GeneralContributions generalContributions;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public Congregant getCog() {
        return cog;
    }

    public void setCog(Congregant cog) {
        this.cog = cog;
    }

    public LocalDate getInserted() {
        return inserted;
    }

    public void setInserted(LocalDate inserted) {
        this.inserted = inserted;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public GeneralContributions getGeneralContributions() {
        return generalContributions;
    }

    public void setGeneralContributions(GeneralContributions generalContributions) {
        this.generalContributions = generalContributions;
    }
    
    
    
}
