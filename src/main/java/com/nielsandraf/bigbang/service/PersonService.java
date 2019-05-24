package com.nielsandraf.bigbang.service;

import com.nielsandraf.bigbang.model.Person;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonService {

    Optional<Person> getPersonById(final UUID id);

    List<Person> getAll();

    Person newPersonSave(Person person);

    Person updatePerson(Person person);

    Person deletePersonById(UUID id);
}
