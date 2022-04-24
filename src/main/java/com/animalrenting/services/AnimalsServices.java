package com.animalrenting.services;

import com.animalrenting.models.AnimalType;
import com.animalrenting.models.Animals;
import com.animalrenting.models.Gender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalsServices {

    private final List<Animals> resultList;

    public AnimalsServices() {
        resultList = new ArrayList<>();
        resultList.add(generateCat());
        resultList.add(generateDog());
    }

    public List<Animals> getAnimals() {
        return resultList;
    }

    public Animals getById(long id) {
        for (Animals animals : resultList) {
            if(animals.getId() == id) {
                return animals;
            }
        }
        throw new RuntimeException("Value not found provided id:" + id);
    }

    public Animals create(Animals model) {
        long id = resultList.size() + 1;
        model.setId(id);
        resultList.add(model);
        return model;
    }

    public void update(Animals model, long id) {
        resultList.stream().map(b->{
            if(b.getId()==id) {
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
        resultList.stream().filter(animal->{
            if(animal.getId()!=id){
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
    }


    private Animals generateCat() {
        Animals animals = new Animals();
        animals.setId(1);
        animals.setAnimalType(AnimalType.cats);
        animals.setAge(2);
        animals.setPrice(8.20);
        animals.setShortDescription("Beautiful cat");
        animals.setLongDescription("Beautiful cat with black eyes");
        animals.setLocation("Sarajevo");
        animals.setGender(Gender.female);
        animals.setVaccinated(true);

        return animals;
    }

    private Animals generateDog() {
        Animals animals = new Animals();
        animals.setId(2);
        animals.setAnimalType(AnimalType.dogs);
        animals.setAge(1);
        animals.setPrice(9.40);
        animals.setShortDescription("Beautiful dog");
        animals.setLongDescription("Beautiful dog with brown eyes");
        animals.setLocation("Kakanj");
        animals.setGender(Gender.male);
        animals.setVaccinated(true);

        return animals;
    }


}
