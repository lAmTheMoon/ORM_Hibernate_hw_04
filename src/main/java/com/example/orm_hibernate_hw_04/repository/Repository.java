package com.example.orm_hibernate_hw_04.repository;

import com.example.orm_hibernate_hw_04.entity.Person;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<Person, Long> {


    @Transactional
    List<Person> findByCityOfLiving(String city);

    @Transactional
    List<Person> findByAgeOrderBy(Integer age);

    @Transactional
    List<Optional> findByNameAndSurname(String name, String surname);
}
