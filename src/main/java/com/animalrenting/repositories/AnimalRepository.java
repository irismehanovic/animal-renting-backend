package com.animalrenting.repositories;

import com.animalrenting.models.Animal;
import com.animalrenting.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

  //  Animal findAllByVaccinated(boolean isVaccinated);

  //  Animal findAllByLocation();

   // int countAllByAnimalTypeCats();

    List<Animal> findAllByUserId(long id);



}
