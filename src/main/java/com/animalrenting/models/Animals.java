package com.animalrenting.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Animals {
    private long id;
    private int age;
    private double price;
    private String shortDescription;
    private String longDescription;
    private String location;
    private AnimalType animalType;
    private Gender gender;
    private boolean vaccinated;

}
