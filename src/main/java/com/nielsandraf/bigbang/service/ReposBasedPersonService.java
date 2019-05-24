package com.nielsandraf.bigbang.service;

import com.nielsandraf.bigbang.exception.NoSuchPersonException;
import com.nielsandraf.bigbang.model.Person;
import com.nielsandraf.bigbang.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReposBasedPersonService implements PersonService {

    private final PersonRepository personRepository;

    public ReposBasedPersonService(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Optional<Person> getPersonById(final UUID id) {
        return personRepository.findById(id);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person newPersonSave(Person person) {
        person.setActive(true);
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        if(this.checkPerson(person)){
            return personRepository.save(person);
        }else{
            throw new NoSuchPersonException("This person doesn't exist yet");
        }
    }

    @Override
    public Person deletePersonById(UUID id) {
        Optional<Person> person = this.getPersonById(id);
        if(person.isPresent()){
            person.get().setActive(false);
            personRepository.save(person.get());
            System.out.println(person.get().getActive());
            return person.get();
        }else{
            throw new NoSuchPersonException("This person doesn't exist yet");
        }    }

    private boolean checkPerson(Person person) {
        return this.getPersonById(person.getId()).isPresent();
    }
}
