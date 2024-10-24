package com.majesticHorse.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;
/**
 *
 * @author samuel
 */
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;
    private String tag;
    @JsonIgnore
    @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Sheet> Sheets;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public Set<Sheet> getSheets() {
        return null;
    }

    public void setSheets(Set<Sheet> Sheets) {
        this.Sheets = Sheets;
    }
    
    
    
}
