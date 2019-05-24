package com.nielsandraf.bigbang.web.controller.mapper;

import com.nielsandraf.bigbang.model.Serie;
import com.nielsandraf.bigbang.service.ReposBasedSerieService;
import com.nielsandraf.bigbang.web.model.SerieDto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@Transactional
public class SerieUUIDMapper {

    ReposBasedSerieService service;

    public SerieUUIDMapper(ReposBasedSerieService service) {
        this.service = service;
    }

    public Serie uuidTSerie(UUID uuid) {
        return uuid == null ? null : service.getSerie(uuid).orElse(null);//throw excp?
    }

    public UUID SerieToUuid(SerieDto dto) {
        return dto == null ? null : dto.getId()==null?null:UUID.fromString(dto.getId());
    }

    public UUID SerieToUuid(Serie serie) {
        return serie == null ? null : serie.getId();
    }

/*
    Set<UUID> mapSerieToUUID(Set<Serie> all) {return (Set<UUID>) all.stream().map(this::SerieToUuid);}
    HashSet<Serie> mapUUIDToSerie(Set<UUID> all) {return (HashSet<Serie>) all.stream().map(this::uuidTSerie);}*/
}