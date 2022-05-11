package com.animalrenting.repositories;

import com.animalrenting.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnimalRepository extends JpaRepository<Animal, Long> {



    Animal findAllByVaccinated(boolean isVaccinated);

    Animal findAllByLocationContaining();

    int countAllByAnimalTypeCats();


}
