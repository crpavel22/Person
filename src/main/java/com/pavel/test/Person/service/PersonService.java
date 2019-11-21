package com.pavel.test.Person.service;

import com.pavel.test.Person.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAll();

    Person save(Person p);

    Person findById(Long ids);

}
