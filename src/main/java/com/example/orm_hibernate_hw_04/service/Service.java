package com.example.orm_hibernate_hw_04.service;

import com.example.orm_hibernate_hw_04.entity.Person;
import com.example.orm_hibernate_hw_04.repository.Repository;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class Service {

    private final Repository repository;

    public List<Person> getPersonsByCity(String city) {
        return repository.findByCityOfLiving(city);
    }

    public List<Person> getPersons() {
        return (List<Person>) repository.findAll();
    }

    public List<Person> getPersonsByAge(String age) {
        return repository.findByAgeOrderByAgeAsc(Integer.getInteger(age));
    }

    public Person getPersonsByNameAndSurname(String name, String surname) {
        return Optional.ofNullable(repository.findByNameAndSurname(name, surname)).get()
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                String.format("Entity with name = %s and surname = %s not found", name, surname)));
    }
}
