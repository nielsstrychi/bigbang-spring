package com.nielsandraf.bigbang.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Part extends AbstractModel{

    private String name;
    private String bio;

    @ManyToOne(optional = false)
    private Person person;
    @ManyToOne(optional = false)
    private Serie serie;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
}
