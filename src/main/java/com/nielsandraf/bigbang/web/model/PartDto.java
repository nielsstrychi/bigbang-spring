package com.nielsandraf.bigbang.web.model;

import com.nielsandraf.bigbang.web.controller.validation.ValidationCreate;
import com.nielsandraf.bigbang.web.controller.validation.ValidationUpdate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

public class PartDto {

   // UUID serieDto;
    private SerieDto serieDto;

    //UUID personDto;
    private PersonDto personDto;

    public void setSerieDto(SerieDto serieDto) {
        this.serieDto = serieDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }

    public SerieDto getSerieDto() {
        return serieDto;
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    @Pattern(regexp = "[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}")
    @Null(groups = ValidationCreate.class)
    @NotNull(groups = ValidationUpdate.class)
    private String id;

    private String name;

    private String bio;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

}
