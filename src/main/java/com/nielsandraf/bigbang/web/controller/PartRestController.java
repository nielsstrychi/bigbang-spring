package com.nielsandraf.bigbang.web.controller;

import com.nielsandraf.bigbang.service.PartService;
import com.nielsandraf.bigbang.service.ReposBasedPartService;
import com.nielsandraf.bigbang.web.controller.mapper.PartMapper;
import com.nielsandraf.bigbang.web.controller.validation.ValidationCreate;
import com.nielsandraf.bigbang.web.controller.validation.ValidationUpdate;
import com.nielsandraf.bigbang.web.model.PartDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rest/part")
public class PartRestController {

    private final PartService service;
    private final PartMapper mapper;

    public PartRestController(PartService service, PartMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartDto> getPart(@PathVariable("id") UUID uuid) {
       return service.getPartbyId(uuid).map(mapper::partToDto).map(d -> new ResponseEntity<>(d, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/")
    public List<PartDto> getAllPart() {
        return mapper.mapPartsToDtos(service.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<PartDto> postPart(@RequestBody @Validated(ValidationCreate.class) PartDto dto) {
        return new ResponseEntity<>(mapper.partToDto(service.create(mapper.dtoToPart(dto))), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<PartDto> PutPart(@RequestBody @Validated(ValidationUpdate.class) PartDto partDto) {
        return new ResponseEntity<>(mapper.partToDto(service.update(mapper.dtoToPart(partDto))),HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deletePart(@PathVariable("id") final UUID id){
        return service.deletePartById(id)
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
