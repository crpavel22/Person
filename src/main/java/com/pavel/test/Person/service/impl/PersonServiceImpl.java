package com.pavel.test.Person.service.impl;

import com.pavel.test.Person.entity.Person;
import com.pavel.test.Person.repository.PersonRepository;
import com.pavel.test.Person.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAll() {
        List<Person> personList = new ArrayList<>();
        personRepository.findAll().forEach(personList::add);
        return personList;
    }
    @Override
    public Person save(Person p) {
        return personRepository.save(p);
    }
    @Override
    public Person findById(Long id) {
        Optional<Person> dbPerson = personRepository.findById(id);
        return dbPerson.orElse(null);
    }
}
