package com.animalrenting.controllers;

import com.animalrenting.models.Animal;
import com.animalrenting.services.AnimalServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalServices animalServices;

    public AnimalController(AnimalServices animalServices) {
        this.animalServices = animalServices;
    }

    @GetMapping
    public List<Animal> getAnimals() {
        return animalServices.getAnimals();
    }

    @GetMapping("/{id}")
    public Animal getAnimals(@PathVariable long id) {
        return animalServices.getById(id);
    }

    @PostMapping
    public Animal createAnimals (@RequestBody Animal animal) {
        return animalServices.create(animal);
    }

    @PutMapping("/{id}")
    public Animal updateAnimals(@RequestBody Animal animalDetails, @PathVariable(value="id") long id) {
        animalServices.update(animalDetails, id);
        return animalDetails;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(value="id") long id) {
        animalServices.delete(id);
    }

}
