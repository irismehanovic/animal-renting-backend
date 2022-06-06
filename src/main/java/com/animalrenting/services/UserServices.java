package com.animalrenting.services;

import com.animalrenting.models.Animal;
import com.animalrenting.models.City;
import com.animalrenting.models.UserType;
import com.animalrenting.models.Users;
import com.animalrenting.repositories.AnimalRepository;
import com.animalrenting.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServices {

    private final List<Users> userList = null;
    private final UsersRepository usersRepository;
    private final AnimalRepository animalRepository;

    public UserServices(UsersRepository usersRepository, AnimalRepository animalRepository){
        this.usersRepository = usersRepository;
        this.animalRepository = animalRepository;
//        userList = new ArrayList<>();
        List<String> usernamesToCheck = new ArrayList<>();
        usernamesToCheck.add("EfnanM");
        usernamesToCheck.add("Iris111");
        if (!doExistUsernames(usernamesToCheck))
        {
            usersRepository.save(generateRenter());
            usersRepository.save(generateRentee());
        }
    }

    private boolean doExistUsernames(List<String> usernamesToCheck) {
        for (var username : usernamesToCheck
             ) {
            if(usersRepository.findFirstByUsername(username) != null) {
                return true;
            }
        }
        return false;
    }

    public Users getByID(long id) {
//        for (Users user : userList) {
//            if(user.getId() == ID) {
//                return user;
//            }
//        }
//        throw new RuntimeException("Value not found provided id:" + ID);
        return usersRepository.getById(id);
    }

    public Users getByUsername(String username) {
        for (Users user : userList) {
            if(user.getUsername() == username) {
                return user;
            }
        }
        throw new RuntimeException("User not found provided username:" + username);
    }

    private Users generateRenter() {
        Users user1 = new Users();
//        user1.setId(0001);
        user1.setUsername("EfnanM");
        user1.setFirstName("Efnan");
        user1.setLastName("Merdan");
        user1.setEmail("efnanmerdan@gmail.com");
        user1.setPassword("Efnan123");
        user1.setCity(City.Sarajevo);
        user1.setUserType(UserType.renter);
        user1.setPhoneNumber(1234567);

        return user1;
    }

    private Users generateRentee() {
        Users user2 = new Users();
//        user2.setId(0002);
        user2.setUsername("Iris111");
        user2.setFirstName("Iris");
        user2.setLastName("Mehanovic");
        user2.setEmail("irismehanovic@gmail.com");
        user2.setPassword("petrent");
        user2.setCity(City.Sarajevo);
        user2.setUserType(UserType.rentee);
        user2.setPhoneNumber(1234567);

        return user2;
    }

    public List<Users> getUsers() {

        return usersRepository.findAll();
    }

    public Users createUser(Users user) {
        Set<Animal> listOfAnimals = new HashSet<>();
        if (!user.getAnimals().isEmpty()) {
            for (var animal : user.getAnimals()
                 ) {
                var animalToSave = animalRepository.save(animal);
                listOfAnimals.add(animalToSave);
            }
        }
        user.setAnimals(listOfAnimals);
        return usersRepository.save(user);
    }

    public void updateUser(Users users, long ID) {
        userList.stream().map(user->{
             if(user.getId()==ID) {
                user.setUsername(users.getUsername());
                user.setFirstName(users.getFirstName());
                user.setLastName(users.getLastName());
                user.setEmail(users.getEmail());
                user.setPassword(users.getPassword());
                user.setCity(users.getCity());
                user.setUserType(users.getUserType());
                user.setPhoneNumber(users.getPhoneNumber());
            }
            return user;
         }).collect(Collectors.toList());
    }
}
