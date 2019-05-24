package com.nielsandraf.bigbang.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Person extends AbstractModel{

    private String actorName, actorURL, characterName, characterBio;
    private Integer characterStartingSeason;
    private Boolean active;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "serie")
    private Set<Part> part = new HashSet<>();

    public Set<Part> getPart() {
        return part;
    }

    public void setPart(Set<Part> part) {
        this.part = part;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorURL() {
        return actorURL;
    }

    public void setActorURL(String actorURL) {
        this.actorURL = actorURL;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterBio() {
        return characterBio;
    }

    public void setCharacterBio(String characterBio) {
        this.characterBio = characterBio;
    }

    public Integer getCharacterStartingSeason() {
        return characterStartingSeason;
    }

    public void setCharacterStartingSeason(Integer characterStartingSeason) {
        this.characterStartingSeason = characterStartingSeason;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
