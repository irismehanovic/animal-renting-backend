package com.animalrenting.repositories;

import com.animalrenting.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findFirstByUsername(String username);
}
