package com.animalrenting.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "city")
    @Enumerated(value = EnumType.STRING)
    private City city;

    @Column(name = "address")
    private String address;

    @Column(name = "user_type")
    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "date_of_birth")
    private int dateOfBirth;

    public Long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setID(int i) {
    }

    public void setUsername(String iris111) {
    }

    public void setName(String iris) {
    }

    public String getUsername() {
        return username;
    }

    public void setLastName(String mehanovic) {
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String s) {
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String petrent) {
    }

    public String getPassword() {
        return password;
    }

    public void setCity(City sarajevo) {
    }

    public City getCity() {
        return city;
    }

    public void setAddress(String address) {
    }

    public void setUserType(UserType rentee) {
    }

    public String getAddress() {
        return address;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setPhoneNumber(int i) {
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setDateOfBirth(int i) {
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }
}
