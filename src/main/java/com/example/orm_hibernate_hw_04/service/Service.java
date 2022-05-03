package com.example.orm_hibernate_hw_04.service;

import com.example.orm_hibernate_hw_04.entity.Person;
import com.example.orm_hibernate_hw_04.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private final Repository repository;
    private static int cntInitTableRequest = 0;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }

    public List<Person> getPersons() {
        cntInitTableRequest++;
        if (cntInitTableRequest > 1) {
            return repository.getPersons();
        }
        return repository.savePersons();
    }
}
