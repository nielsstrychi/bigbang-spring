package com.nielsandraf.bigbang.web.controller.mapper;

import com.nielsandraf.bigbang.model.Part;
import com.nielsandraf.bigbang.model.Person;
import com.nielsandraf.bigbang.web.model.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.*;

@Mapper(uses = {UUIDMapper.class, PersonUUIDMapper.class})
public interface PersonMapper {
   /* @Mapping(source = "part", target = "partDto")*/
    PersonDto mapPersonToDto(Person person);

    /*@Mapping(source = "partDto", target = "part")*/
    Person mapDtoToPerson(PersonDto person);

    ArrayList<PersonDto> mapPersonListToDtoList(List<Person> all);

    /*
    HashSet<UUID> mapPersontToUUID(Set<Person> all);
    HashSet<Person> mapUUIDToPerson(Set<UUID> all);*/
}
