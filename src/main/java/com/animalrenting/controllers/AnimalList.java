package com.animalrenting.controllers;

import com.animalrenting.models.Animals;
import com.animalrenting.services.AnimalsServices;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/animals")
public class AnimalList {

    private final AnimalsServices animalsServices;

    public AnimalList(AnimalsServices animalsServices) {
        this.animalsServices = animalsServices;
    }

    @GetMapping
    public List<Animals> getAnimals() {
        return animalsServices.getAnimals();
    }

    @GetMapping("/{id}")
    public Animals getAnimals(@PathVariable long id) {
        return animalsServices.getById(id);
    }

    @PostMapping
    public Animals createAnimals (@RequestBody Animals animals) {
        return animalsServices.create(animals);
    }

    @PutMapping("/{id}")
    public Animals updateAnimals(@RequestBody Animals animalsDetails, @PathVariable(value="id") long id) {
        this.animalsServices.update(animalsDetails, id);
        return animalsDetails;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(value="id") long id) {
        this.animalsServices.delete(id);
    }

}
