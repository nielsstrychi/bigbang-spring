package com.nielsandraf.bigbang.web.controller;

import com.nielsandraf.bigbang.service.ReposBasedSerieService;
import com.nielsandraf.bigbang.service.SerieService;
import com.nielsandraf.bigbang.web.controller.mapper.SerieMapper;
import com.nielsandraf.bigbang.web.controller.validation.ValidationCreate;
import com.nielsandraf.bigbang.web.controller.validation.ValidationUpdate;
import com.nielsandraf.bigbang.web.model.SerieDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/rest/serie")
@RestController
public class SerieRestController {

    private final SerieService service;

    private final SerieMapper mapper;

    public SerieRestController(final SerieService service, final SerieMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SerieDto> getSerie(@PathVariable("id") UUID uuid) {
        return service.getSerie(uuid).map(mapper::serieToDto)
                .map(dto -> new ResponseEntity<>(dto,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT));
    }

    @GetMapping("/")
    public List<SerieDto> getAllSerie() {
        return mapper.mapSeriesToDtos(service.getAll());
    }



    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postSerie(@RequestBody @Validated(ValidationCreate.class) SerieDto serieDto) {
        return new ResponseEntity(mapper.serieToDto(service.createSerie(mapper.dtoToSerie(serieDto))),HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateSerie(@RequestBody @Validated(ValidationUpdate.class) SerieDto serieDto) {
        return new ResponseEntity(mapper.serieToDto(service.updateSerie(mapper.dtoToSerie(serieDto))),HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deletePart(@PathVariable("id") final UUID id){
        return service.deleteSerieById(id)
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
