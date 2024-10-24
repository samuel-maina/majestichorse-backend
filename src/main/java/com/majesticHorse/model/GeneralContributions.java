package com.majesticHorse.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author samuel
 */
@Entity
public class GeneralContributions extends Sheet {
@OneToMany(mappedBy = "generalContributions", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Contributions> contributions;    

    public List<Contributions> getContributions() {
        return contributions;
    }

    public void setContributions(List<Contributions> contributions) {
        this.contributions = contributions;
    }

}
