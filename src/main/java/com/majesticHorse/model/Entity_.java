
package com.majesticHorse.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author samuel
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Entity_ {
    @Id
    private String Id;
    private LocalDate created;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
    
    
    
    
}
