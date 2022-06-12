package com.animalrenting.controllers;

import com.animalrenting.models.Animal;
import com.animalrenting.models.Users;
import com.animalrenting.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private final UserServices userServices;

    public UsersController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public List<Users> getUsers(){
        return userServices.getUsers();
    }

    @GetMapping(value = "/{ID}")
    public Users getUser(@PathVariable long ID) {
        return userServices.getById(ID);
    }

    @PostMapping
    public Users createProfile(@RequestBody Users profile) {
        return userServices.create(profile);
    }

    @PutMapping("/{id}")
    public Users updateUser(@RequestBody Users userDetails, @PathVariable(value="id") long id) {
        userServices.update(userDetails, id);
        return userDetails;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(value="id") long id) {
        userServices.delete(id);
    }


}
