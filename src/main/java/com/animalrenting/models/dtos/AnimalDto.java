package com.animalrenting.models.dtos;

import com.animalrenting.models.AnimalType;
import com.animalrenting.models.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalDto {
    private String age;
    private double price;
    private String shortDescription;
    private String longDescription;
    private AnimalType animalType;
    private Gender gender;
    private boolean vaccinated;
    private long userId;
}
