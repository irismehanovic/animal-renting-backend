package com.animalrenting.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Users {
      private long ID;
      private String username;
      private String name;
      private String lastName;
      private String email;
      private String password;
      private City city;
      private String address;
      private UserType userType;
      private int phoneNumber;
      private int dateOfBirth;
}
