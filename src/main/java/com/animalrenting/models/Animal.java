package com.animalrenting.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "animals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Animal implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "age")
    private String age;

    @Column(name = "price")
    private double price;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "long_secription")
    private String longDescription;

    @Column(name = "animal_Type")
    @Enumerated(value = EnumType.STRING)
    private AnimalType animalType;

    @Column(name = "Gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name = "vaccinated", nullable = false)
    private boolean vaccinated;



//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id")
//    private Users user;
    
    @ManyToOne
    @JoinColumn(name = "users", referencedColumnName = "id")
    private Users users;



//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "animals")
//    private Animal animals;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private Users owner;
}
