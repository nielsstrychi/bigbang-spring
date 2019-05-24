package com.nielsandraf.bigbang.web.controller.mapper;

import com.nielsandraf.bigbang.model.Person;
import com.nielsandraf.bigbang.model.Serie;
import com.nielsandraf.bigbang.service.PersonService;
import com.nielsandraf.bigbang.web.model.PersonDto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
@Transactional
public class PersonUUIDMapper {

    private PersonService service;

    public PersonUUIDMapper(PersonService service) {
        this.service = service;
    }

    public Person uuidToperson(UUID uuid) {
        return uuid == null ? null : service.getPersonById(uuid).orElse(null);//throw excp?
    }

    public UUID personToUuid(PersonDto dto) {
        return dto == null ? null : dto.getId()==null?null:UUID.fromString(dto.getId());
    }

    public UUID personToUuid(Person dto) {
        return dto == null ? null : dto.getId();
    }
/*
    Set<UUID> mapSerieToUUID(Set<Person> all) {return (Set<UUID>) all.stream().map(this::personToUuid);}
    HashSet<Person> mapUUIDToSerie(Set<UUID> all) {return (HashSet<Person>) all.stream().map(this::uuidToperson);}*/
}