package com.example.orm_hibernate_hw_04;

import com.example.orm_hibernate_hw_04.entity.Person;
import com.example.orm_hibernate_hw_04.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class CommandLineApp implements CommandLineRunner {

    @Autowired
    Repository repository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Random random = new Random();

        var names = List.of("Pups", "Lucy", "Odin", "Uan", "Maks");
        var surnames = List.of("Mur", "Black", "Sweet", "Grom");
        var cities = List.of("SPb", "Msk");

        IntStream.range(0, 100).forEach(i -> {
                    var person = Person.builder()
                            .name(names.get(random.nextInt(names.size())))
                            .surname(surnames.get(random.nextInt(surnames.size())))
                            .age(random.nextInt(100))
                            .cityOfLiving(cities.get(random.nextInt(cities.size())))
                            .phoneNumber("+7" + random.nextInt(999999999))
                            .build();

                    repository.save(person);
        });
    }
}
