package com.majesticHorse.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author samuel
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Sheet {
    @Id
    @Column(length=64)
    private String Id;
    private String sheet;
    @Column(length=100)
    private String description;
    private Date creationDate;
    @ManyToMany
    @JoinTable(name="sheet_tags",joinColumns=@JoinColumn(name="sheet_id"),inverseJoinColumns=@JoinColumn(name="tags_id"), uniqueConstraints = {@UniqueConstraint(columnNames={"sheet_id", "tags_id"})})
    private Set<Tag> tags;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getSheet() {
        return sheet;
    }

    public void setSheet(String sheet) {
        this.sheet = sheet;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    
    
}
