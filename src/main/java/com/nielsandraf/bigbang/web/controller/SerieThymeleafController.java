package com.nielsandraf.bigbang.web.controller;

import com.nielsandraf.bigbang.service.SerieService;
import com.nielsandraf.bigbang.web.controller.mapper.SerieMapper;
import com.nielsandraf.bigbang.web.model.SerieDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/serie")
public class SerieThymeleafController {

    SerieService service;
    SerieMapper mapper;

    public SerieThymeleafController(SerieService service, SerieMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/", produces = {MediaType.TEXT_HTML_VALUE})
    public String presentSerieList(Model model) {
        model.addAttribute("Series", mapper.mapSeriesToDtos(service.getAll()));
        return "Serie/list";
    }

    @GetMapping(value = "/{id}", produces = {MediaType.TEXT_HTML_VALUE})
    public String presentSerieDetail(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("Serie", mapper.serieToDto(service.getSerie(id).orElse(null)));
        return "Serie/detail";
    }

    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.TEXT_HTML_VALUE})
    public String postSerie(@ModelAttribute SerieDto dto, Model model) {
        if (dto.getId() == null) {
            service.createSerie(mapper.dtoToSerie(dto));
        } else {
            service.updateSerie(mapper.dtoToSerie(dto));
        }
        return "redirect:/Serie/" + dto.getId();
    }
}
