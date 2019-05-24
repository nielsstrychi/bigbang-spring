package com.nielsandraf.bigbang.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Serie extends AbstractModel {

    private String name;
    private String url;
    private LocalDate startSeason;
    private LocalDate endSeason;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "serie")
    private Set<Part> part = new HashSet<>();

    public Set<Part> getPart() {
        return part;
    }

    public void setPart(Set<Part> part) {
        this.part = part;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getStartSeason() {
        return startSeason;
    }

    public void setStartSeason(LocalDate startSeason) {
        this.startSeason = startSeason;
    }

    public LocalDate getEndSeason() {
        return endSeason;
    }

    public void setEndSeason(LocalDate endSeason) {
        this.endSeason = endSeason;
    }
}
