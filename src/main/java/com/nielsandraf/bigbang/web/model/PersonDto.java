package com.nielsandraf.bigbang.web.model;

import com.nielsandraf.bigbang.web.controller.validation.ValidationCreate;
import com.nielsandraf.bigbang.web.controller.validation.ValidationUpdate;

import javax.validation.constraints.*;

public class PersonDto {

    //Set<UUID> partDto;
/*
    Set<PartDto> partDto;

    public Set<PartDto> getPartDto() {
        return partDto;
    }

    public void setPartDto(Set<PartDto> partDto) {
        this.partDto = partDto;
    }*/

    @Pattern(regexp = "[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}")
    @Null(groups = ValidationCreate.class)
    @NotNull(groups = ValidationUpdate.class)
    private String id;

    @NotNull
    @NotEmpty
    private String actorName, actorURL, characterName, characterBio;

    @Min(1)
    private Integer characterStartingSeason;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Pattern(regexp = "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$")
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


}
