package com.animalrenting.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "animals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "users", referencedColumnName = "id")
    private Users users;

    @Column(name = "age")
    private int age;

    @Column(name = "price")
    private double price;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "long_secription")
    private String longDescription;

    @Column(name = "location")
    private String location;

    @Column(name = "animal_Type")
    @Enumerated(value = EnumType.STRING)
    private AnimalType animalType;

    @Column(name = "Gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name = "vaccinated", nullable = false)
    private boolean vaccinated;

}
