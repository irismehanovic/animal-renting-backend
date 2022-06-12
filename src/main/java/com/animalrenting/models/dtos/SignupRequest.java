package com.animalrenting.models.dtos;


import com.animalrenting.models.City;
import com.animalrenting.models.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private int phoneNumber;
    private UserType userType;
    private City city;


}
