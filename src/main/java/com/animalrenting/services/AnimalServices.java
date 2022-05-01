package com.animalrenting.services;

import com.animalrenting.models.AnimalType;
import com.animalrenting.models.Animal;
import com.animalrenting.models.Gender;
import com.animalrenting.repositories.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalServices {

    private final List<Animal> resultList;
    private final AnimalRepository animalRepositories;

    public AnimalServices(AnimalRepository animalRepository) {
        this.animalRepositories = animalRepository;
        resultList = new ArrayList<>();
        resultList.add(generateCat());
        resultList.add(generateDog());
    }

    public List<Animal> getAnimals() {
        return animalRepositories.findAll();
    }

    public Animal getById(long id) {
        for (Animal animal : resultList) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        throw new RuntimeException("Value not found provided id:" + id);
    }

    public Animal create(Animal model) {
        animalRepositories.save(model);
        return model;
    }

    public void update(Animal model, long id) {
        resultList.stream().map(b -> {
            if (b.getId() == id) {
                b.setAge(model.getAge());
                b.setPrice(model.getPrice());
                b.setShortDescription(model.getShortDescription());
                b.setLongDescription(model.getLongDescription());
                b.setLocation(model.getLocation());
                b.setAnimalType(model.getAnimalType());
                b.setGender(model.getGender());
                //fali mi za vaccinated
            }
            return b;
        }).collect(Collectors.toList());
    }

    public void delete(long id) {
        resultList.stream().filter(animal -> {
            if (animal.getId() != id) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
    }


    private Animal generateCat() {
        Animal animal = new Animal();
        animal.setId(1);
        animal.setAnimalType(AnimalType.cats);
        animal.setAge(2);
        animal.setPrice(8.20);
        animal.setShortDescription("Beautiful cat");
        animal.setLongDescription("Beautiful cat with black eyes");
        animal.setLocation("Sarajevo");
        animal.setGender(Gender.female);
        animal.setVaccinated(true);

        return animal;
    }

    private Animal generateDog() {
        Animal animal = new Animal();
        animal.setId(2);
        animal.setAnimalType(AnimalType.dogs);
        animal.setAge(1);
        animal.setPrice(9.40);
        animal.setShortDescription("Beautiful dog");
        animal.setLongDescription("Beautiful dog with brown eyes");
        animal.setLocation("Kakanj");
        animal.setGender(Gender.male);
        animal.setVaccinated(true);

        return animal;
    }


}
