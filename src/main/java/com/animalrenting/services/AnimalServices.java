package com.animalrenting.services;

import com.animalrenting.models.Animal;
import com.animalrenting.models.dtos.AnimalDto;
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

    public List<AnimalDto> getAnimals() {
        return animalRepositories.findAll().stream().map((animal)->toDto(animal)).toList();
    }

    public AnimalDto getById(long id) {
        return toDto(getEntity(id));
    }

    public AnimalDto create(AnimalDto model) {
        Animal entity = toEntity(model);
        entity = animalRepositories.save(entity);

        return toDto(entity);
    }

    private AnimalDto toDto(Animal entity) {
        AnimalDto result = new AnimalDto();
        result.setAnimalType(entity.getAnimalType());
        result.setGender(entity.getGender());
        result.setShortDescription(entity.getShortDescription());
        result.setLongDescription(entity.getLongDescription());
        result.setAge(entity.getAge());
        result.setPrice(entity.getPrice());
        result.setVaccinated(entity.isVaccinated());
        return result;
    }

    private Animal toEntity(AnimalDto model) {
        Animal entity = new Animal();
        entity.setAnimalType(model.getAnimalType());
        entity.setPrice(model.getPrice());
        entity.setGender(model.getGender());
        entity.setVaccinated(model.isVaccinated());
        entity.setAge(model.getAge());
        entity.setShortDescription(model.getShortDescription());
        entity.setLongDescription(model.getLongDescription());
        return entity;
    }

    public AnimalDto update(AnimalDto model, long id) {
        getEntity(id);
        Animal entity = toEntity(model);
        entity.setId(id);
        entity = animalRepositories.save(entity);

        return toDto(entity);
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

}
