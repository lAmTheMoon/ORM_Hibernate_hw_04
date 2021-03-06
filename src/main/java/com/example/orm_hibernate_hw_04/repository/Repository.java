package com.example.orm_hibernate_hw_04.repository;

import com.example.orm_hibernate_hw_04.entity.Person;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        var query = entityManager.createQuery(
                "select p from Person p where p.cityOfLiving = :city_of_living", Person.class);
        query.setParameter("city_of_living", city);
        return query.getResultList();
    }

    @Transactional
    public List<Person> getPersons() {
        var query = entityManager.createQuery("select p from Person p", Person.class);
        return query.getResultList();
    }

    @Transactional
    public List<Person> savePersons() {
        Random random = new Random();

        var names = List.of("Pups", "Lucy", "Odin", "Uan", "Maks");
        var surnames = List.of("Mur", "Black", "Sweet", "Grom");
        var cities = List.of("SPb", "Msk");

        IntStream.range(0, 100)
                .forEach(i -> {
                    var person = Person.builder()
                            .name(names.get(random.nextInt(names.size())))
                            .surname(surnames.get(random.nextInt(surnames.size())))
                            .age(random.nextInt(100))
                            .cityOfLiving(cities.get(random.nextInt(cities.size())))
                            .phoneNumber("+7" + random.nextInt(999999999))
                            .build();

                    this.entityManager.persist(person);

                });

        var query = entityManager.createQuery("select p from Person p", Person.class);
        return query.getResultList();
    }
}
