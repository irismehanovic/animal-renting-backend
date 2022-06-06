package com.animalrenting.services;

import com.animalrenting.models.AnimalType;
import com.animalrenting.models.Animal;
import com.animalrenting.models.Gender;
import com.animalrenting.repositories.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServices {

    private final AnimalRepository animalRepositories;

    public AnimalServices(AnimalRepository animalRepository) {
        this.animalRepositories = animalRepository;
    }

    public List<Animal> getAnimals() {
        return animalRepositories.findAll();
    }

    public Animal getById(long id) {
        return getEntity(id);
    }

    public Animal create(Animal model) {
        return animalRepositories.save(model);
    }

    public Animal update(Animal model, long id) {
        getEntity(id);

        model.setId(id);
        return animalRepositories.save(model);
    }

    private Animal getEntity(long id) {
        Optional<Animal> animalOptional = animalRepositories.findById(id);
        if(animalOptional.isPresent()) {
            return animalOptional.get();
        }

        throw new RuntimeException("Animal with id:" + id + " does not exist!");
    }

    public void delete(long id) {
        animalRepositories.deleteById(id);
    }

    private Animal generateCat() {
        Animal animal = new Animal();
        animal.setId(1);
        animal.setAnimalType(AnimalType.cats);
        animal.setAge("2");
        animal.setPrice(8.20);
        animal.setShortDescription("Beautiful cat");
        animal.setLongDescription("Beautiful cat with black eyes");
        animal.setGender(Gender.female);
        animal.setVaccinated(true);

        return animal;
    }

    private Animal generateDog() {
        Animal animal = new Animal();
        animal.setId(2);
        animal.setAnimalType(AnimalType.dogs);
        animal.setAge("2 months");
        animal.setPrice(9.40);
        animal.setShortDescription("Beautiful dog");
        animal.setLongDescription("Beautiful dog with brown eyes");
        animal.setGender(Gender.male);
        animal.setVaccinated(true);

        return animal;
    }


}
