package com.nielsandraf.bigbang.web.controller;

import com.nielsandraf.bigbang.service.PartService;
import com.nielsandraf.bigbang.web.controller.mapper.PartMapper;
import com.nielsandraf.bigbang.web.model.PartDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/part")
public class PartThymeleafController {

    PartService service;
    PartMapper mapper;

    public PartThymeleafController(PartService service, PartMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/", produces = {MediaType.TEXT_HTML_VALUE})
    public String presentPartList(Model model) {
        model.addAttribute("Parts", mapper.mapPartsToDtos(service.getAll()));
        return "Part/list";
    }

    @GetMapping(value = "/{id}", produces = {MediaType.TEXT_HTML_VALUE})
    public String presentPartDetail(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("Part", mapper.partToDto(service.getPartbyId(id).orElse(null)));
        return "Part/detail";
    }

    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.TEXT_HTML_VALUE})
    public String postPart(@ModelAttribute PartDto dto, Model model) {
        if (dto.getId() == null) {
            service.create(mapper.dtoToPart(dto));
        } else {
            service.update(mapper.dtoToPart(dto));
        }
        return "redirect:/Part/" + dto.getId();
    }
}
