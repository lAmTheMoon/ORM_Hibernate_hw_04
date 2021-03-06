package com.example.orm_hibernate_hw_04.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PERSONS")
@Entity
public class Person {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "age", nullable = false)
    @Min(0)
    @Max(100)
    private Integer age;

    @Column(name = "phone_number", nullable = false, unique = true)
    @Size(max = 12, min = 12)
    private String phoneNumber;

    @Column(name = "city_of_living", nullable = false)
    private String cityOfLiving;
}
