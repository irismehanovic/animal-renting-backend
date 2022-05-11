package com.animalrenting.repositories;

import com.animalrenting.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findAllByCity(String city);
    Users findAllByAddress(String address);
}
