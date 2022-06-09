package com.example.orm_hibernate_hw_04.controller;

import com.example.orm_hibernate_hw_04.entity.Person;
import com.example.orm_hibernate_hw_04.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/persons")
    public List<Person> getPersonsTable() {
        return service.getPersons();
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAge(@RequestParam("age") String age) {
        return service.getPersonsByAge(age);
    }

    @GetMapping("/persons/by-name-and-surname")
    public Person getPersonsByNameAndSurname(@RequestParam("name") String name,
                                             @RequestParam("surname") String surname) {
        return service.getPersonsByNameAndSurname(name, surname);
    }
}
