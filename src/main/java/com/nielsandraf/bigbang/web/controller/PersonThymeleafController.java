package com.nielsandraf.bigbang.web.controller;

import com.nielsandraf.bigbang.service.PersonService;
import com.nielsandraf.bigbang.web.controller.mapper.PersonMapper;
import com.nielsandraf.bigbang.web.model.PersonDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/person")
public class PersonThymeleafController {

    PersonService service;
    PersonMapper mapper;

    public PersonThymeleafController(PersonService service, PersonMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/", produces = {MediaType.TEXT_HTML_VALUE})
    public String presentPersonList(Model model) {
        model.addAttribute("persons", mapper.mapPersonListToDtoList(service.getAll()));
        return "person/list";
    }

    @GetMapping(value = "/{id}", produces = {MediaType.TEXT_HTML_VALUE})
    public String presentPersonDetail(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("person", mapper.mapPersonToDto(service.getPersonById(id).orElse(null)));
        return "person/detail";
    }

    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.TEXT_HTML_VALUE})
    public String postPerson(@ModelAttribute PersonDto dto, Model model) {
        if (dto.getId() == null) {
            service.newPersonSave(mapper.mapDtoToPerson(dto));
        } else {
            service.updatePerson(mapper.mapDtoToPerson(dto));
        }
        return "redirect:/person/" + dto.getId();
    }
}
