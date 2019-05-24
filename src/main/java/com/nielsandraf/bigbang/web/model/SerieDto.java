package com.nielsandraf.bigbang.web.model;

import com.nielsandraf.bigbang.web.controller.validation.ValidationCreate;
import com.nielsandraf.bigbang.web.controller.validation.ValidationUpdate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class SerieDto {

    //Set<UUID> partDto;
    /*Set<PartDto> partDto;


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

    private String name;

    private LocalDate startSeason;

    private LocalDate endSeason;

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
