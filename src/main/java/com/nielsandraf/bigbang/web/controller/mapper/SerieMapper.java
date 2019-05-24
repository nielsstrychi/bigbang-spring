package com.nielsandraf.bigbang.web.controller.mapper;

import com.nielsandraf.bigbang.model.Part;
import com.nielsandraf.bigbang.model.Serie;
import com.nielsandraf.bigbang.web.model.SerieDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Mapper(uses = {UUIDMapper.class, SerieUUIDMapper.class})
public interface SerieMapper {

   /* @Mapping(source = "partDto", target = "part")*/
    Serie dtoToSerie(SerieDto dto);
   /* @Mapping(source = "part", target = "partDto")*/

    SerieDto serieToDto(Serie serie);

    List<SerieDto> mapSeriesToDtos(List<Serie> series);

}
