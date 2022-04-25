package com.animalrenting.controllers;

import com.animalrenting.models.Users;
import com.animalrenting.services.UserServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public List<Users> getUsers(){
        return userServices.getUsers();
    }

    @GetMapping(value = "/{ID}")
    public Users getUser(@PathVariable long ID) {
        return userServices.getByID(ID);
    }

    @PostMapping
    public Users createProfile(@RequestBody Users profile) {
        return userServices.createUser(profile);
    }


    @PutMapping(value = "/{ID}")
    public Users updateUsername(@RequestBody Users username, @PathVariable(value="ID") long ID) {
        this.userServices.updateUser(username, ID);
        return username;
    }

    @PutMapping(value = "/{ID}")
    public Users updatePassword(@RequestBody Users password, @PathVariable(value="ID") long ID) {
        this.userServices.updateUser(password, ID);
        return password;
    }

    @PutMapping(value = "/{ID}")
    public Users updateCity(@RequestBody Users city, @PathVariable(value="ID") long ID) {
        this.userServices.updateUser(city, ID);
        return city;
    }

}
