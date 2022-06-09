package com.animalrenting.data;

import com.animalrenting.models.Animal;
import com.animalrenting.models.AnimalType;
import com.animalrenting.models.Gender;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnimalTest {
    public static Animal animal() {

        Animal animal = new Animal();
        animal.setId(2);
        animal.setAnimalType(AnimalType.dog);
        animal.setAge("1");
        animal.setPrice(9.40);
        animal.setShortDescription("Beautiful dog");
        animal.setLongDescription("Beautiful dog with brown eyes");
//        animal.setLocation("Kakanj");
        animal.setGender(Gender.male);
        animal.setVaccinated(true);

        return animal;

    }
}


