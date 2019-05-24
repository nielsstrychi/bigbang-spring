package com.nielsandraf.bigbang.web.controller;

import com.nielsandraf.bigbang.exception.NoSuchPersonException;
import com.nielsandraf.bigbang.model.Part;
import com.nielsandraf.bigbang.model.Person;
import com.nielsandraf.bigbang.model.Serie;
import com.nielsandraf.bigbang.service.ReposBasedPartService;
import com.nielsandraf.bigbang.service.PersonService;
import com.nielsandraf.bigbang.service.ReposBasedSerieService;
import com.nielsandraf.bigbang.web.controller.mapper.PersonMapper;
import com.nielsandraf.bigbang.web.controller.validation.ValidationCreate;
import com.nielsandraf.bigbang.web.controller.validation.ValidationUpdate;
import com.nielsandraf.bigbang.web.model.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/rest/person")
public class PersonRestController {

    private final PersonService personService;
    private final PersonMapper personMapper;

    public PersonRestController(final PersonService personService, final PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPerson(@PathVariable("id") final UUID id){
        return personService.getPersonById(id).map(personMapper::mapPersonToDto)
                .map(dto-> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<PersonDto> getPerson(@PathVariable("id") final UUID id){
//        PersonDto personDto;
//       Optional<Person> personOpt = personService.getPersonById(id);
//       if (personOpt.isPresent()){
//           personDto = personMapper.mapPersonToDto(personOpt.get());
//           return new ResponseEntity<>(personDto, HttpStatus.OK);
//       }else
//           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    @PostMapping("/")
    public ResponseEntity<PersonDto> newPerson(@RequestBody @Validated(ValidationCreate.class) final PersonDto person){
        Person person1 = personService.newPersonSave(personMapper.mapDtoToPerson(person));
        return new ResponseEntity<>(personMapper.mapPersonToDto(person1), HttpStatus.CREATED);
}

@Autowired
ReposBasedSerieService serviceSerie;
    @Autowired
    ReposBasedPartService partService;

    @GetMapping("/")
    public ResponseEntity<ArrayList<PersonDto>> getAllPersons(){

       Person person = new Person();
        Serie serie = new Serie();
        Part part = new Part();

        person.setActive(true);
        person.setActorName("niels");
        person.setActorURL("www");
        person.getPart().add(part);

        serie.setStartSeason(LocalDate.now());
        serie.setUrl("www2");
        serie.getPart().add(part);

        part.setPerson(person);
        part.setSerie(serie);
        part.setName("123");
        part.setBio("hallo");

        personService.newPersonSave(person);
        serviceSerie.createSerie(serie);
        partService.create(part);

        return new ResponseEntity<>(personMapper.mapPersonListToDtoList(personService.getAll()), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<PersonDto> updatePerson(@RequestBody @Validated(ValidationUpdate.class) final PersonDto person){
        if (!(person.getId().isEmpty())){
            try{
                return new ResponseEntity<>(personMapper.mapPersonToDto(personService.updatePerson(personMapper.mapDtoToPerson(person))), HttpStatus.OK);
            }catch(NoSuchPersonException noSuchPersonException){
                System.out.println(noSuchPersonException.toString());
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/delete/{personId}")
    public ResponseEntity<PersonDto> deletePerson(@PathVariable("personId") final UUID id){
        try{
            return new ResponseEntity<>(personMapper.mapPersonToDto(personService.deletePersonById(id)), HttpStatus.OK);
        }catch(NoSuchPersonException noSuchPersonException){
            System.out.println(noSuchPersonException.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}