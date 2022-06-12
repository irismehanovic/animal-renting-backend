package com.animalrenting.services;

import com.animalrenting.models.Animal;
import com.animalrenting.models.City;
import com.animalrenting.models.UserType;
import com.animalrenting.models.Users;
import com.animalrenting.repositories.AnimalRepository;
import com.animalrenting.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServices {

    private final List<Users> userList = null;
    private final UsersRepository userRepositories;

    public UserServices(UsersRepository userRepository) {
        this.userRepositories = userRepository;
    }

    public List<Users> getUsers() {
        return userRepositories.findAll();
    }

    public Users getById(long id) {
        return getEntity(id);
    }

    public Users create(Users model) {
        return userRepositories.save(model);
    }

    public Users update(Users model, long id) {
        getEntity(id);

        model.setId(id);
        return userRepositories.save(model);
    }

    public void delete(long id) {
        userRepositories.deleteById(id);
    }

    private Users getEntity(long id) {
        //Optional<Users> user = userRepositories.findByUsername("g");
        Optional<Users> usersOptional = userRepositories.findById(id);

        if(usersOptional.isPresent()) {
            return usersOptional.get();
        }

        throw new RuntimeException("User with id: " + id + " does not exist!");
    }

}
