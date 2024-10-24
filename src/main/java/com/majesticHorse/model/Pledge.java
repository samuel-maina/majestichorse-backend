package com.majesticHorse.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author samuel
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pledge extends GeneralContributions {
    private boolean fullfilled;

    public boolean isFullfilled() {
        return fullfilled;
    }

    public void setFullfilled(boolean fullfilled) {
        this.fullfilled = fullfilled;
    }
    
    
}
