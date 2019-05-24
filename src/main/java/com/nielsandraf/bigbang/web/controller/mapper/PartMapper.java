package com.nielsandraf.bigbang.web.controller.mapper;

import com.nielsandraf.bigbang.model.Part;
import com.nielsandraf.bigbang.web.model.PartDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.*;

@Mapper(uses = {UUIDMapper.class, PersonUUIDMapper.class, SerieUUIDMapper.class})
public interface PartMapper {
    @Mapping(source = "personDto", target = "person")
    @Mapping(source = "serieDto", target = "serie")
    Part dtoToPart(PartDto dto);
    @Mapping(source = "person", target = "personDto")
    @Mapping(source = "serie", target = "serieDto")
    PartDto partToDto(Part part);

    List<PartDto> mapPartsToDtos(List<Part> series);

}
