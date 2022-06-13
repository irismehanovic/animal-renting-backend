package com.animalrenting.controllers;

import com.animalrenting.models.Animal;
import com.animalrenting.models.dtos.AnimalDto;
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

    @GetMapping("/user/{id}")
    public List<AnimalDto> getUserAnimals(@PathVariable long id) {
        return animalServices.getUserAnimals(id);
    }

    @GetMapping
    public List<AnimalDto> getAnimals() {
        return animalServices.getAnimals();
    }

    @GetMapping("/{id}")
    public AnimalDto getAnimals(@PathVariable long id) {
        return animalServices.getById(id);
    }

    @PostMapping
    public AnimalDto createAnimals (@RequestBody AnimalDto animal) {
        return animalServices.create(animal);
    }

    @PutMapping("/{id}")
    public AnimalDto updateAnimals(@RequestBody AnimalDto animalDetails, @PathVariable(value="id") long id) {
        animalServices.update(animalDetails, id);
        return animalDetails;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(value="id") long id) {
        animalServices.delete(id);
    }

}
