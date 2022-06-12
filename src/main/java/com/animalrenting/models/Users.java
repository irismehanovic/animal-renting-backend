package com.animalrenting.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Proxy(lazy = false)

public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_type", nullable = true)
    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @Column(name = "phone_number", nullable = true)
    private int phoneNumber;

    @Column(name = "city")
    @Enumerated(value = EnumType.STRING)
    private City city;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Animal> animals;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
//    private Set<Animal> animals;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "animal_id")
//    @JoinColumn(name = "animal_id", referencedColumnName = "id")
//    private List<Animal> animals = new ArrayList<>();
//    private Set<Animal> animals = new HashSet<>();





}
